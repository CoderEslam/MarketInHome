package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.context;
import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.CHILDREN;
import static com.doubleclick.marktinhome.Model.Constantes.PARENTS;
import static com.doubleclick.marktinhome.Model.Constantes.PRODUCT;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.doubleclick.Products;
import com.doubleclick.Servies.Servies;
import com.doubleclick.marktinhome.Model.ChildCategory;
import com.doubleclick.marktinhome.Model.ClassificationPC;
import com.doubleclick.marktinhome.Model.ParentCategory;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.Model.RecentSearch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created By Eslam Ghazy on 3/2/2022
 */
public class ProductRepository extends BaseRepository {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> QueryProducts = new ArrayList<>();
    private ArrayList<Product> QueryProductsByParents = new ArrayList<>();
    private ArrayList<Product> QueryProductsByChild = new ArrayList<>();
    private ArrayList<Product> productWithTrademark = new ArrayList<>();
    private ArrayList<Product> productsTopDeals = new ArrayList<>();
    private ArrayList<ParentCategory> parentCategories = new ArrayList<>();
    private ArrayList<ChildCategory> childCategories = new ArrayList<>();
    private ArrayList<Product> recentSearchProduct = new ArrayList<>();
    private static ArrayList<ArrayList<ArrayList<Product>>> arrayListOfArrayLists = new ArrayList<>();
    private Products product;

    public ProductRepository(Products product) {
        this.product = product;
    }

    // to get All products from Firebase
    public void getProduct() {
        reference.child(PRODUCT)/*.orderByChild("TotalRating")*/.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            if (task.isComplete()) {
                                DataSnapshot snapshot = task.getResult();
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    Product product = dataSnapshot.getValue(Product.class);
//                                    HashMap<String, Object> map = new HashMap<>();
//                                    map.put("keywords","");
//                                    dataSnapshot.getRef().updateChildren(map);
                                    products.add(product);
                                }
                                // to sort products according to total rate
                                Collections.sort(products, Collections.reverseOrder());
                                product.getProduct(products);
                            }
                        }
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });
//        Rearrange();

    }


    // to get all parents from Firebase
    public void getParents() {
        reference.child(PARENTS).orderByChild("order").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            if (task.isComplete()) {
                                DataSnapshot snapshot = task.getResult();
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    ParentCategory parentCategory = dataSnapshot.getValue(ParentCategory.class);
//                                    HashMap<String, Object> map = new HashMap<>();
//                                    map.put("discount",0);
//                                    dataSnapshot.getRef().updateChildren(map);
                                    parentCategories.add(parentCategory);
                                }
                            }
                            product.Parentproduct(parentCategories);
                        }
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });

    }


    // to get all Children from Firebase
    public void getChild() {
        reference.child(CHILDREN).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            if (task.isComplete()) {
                                DataSnapshot snapshot = task.getResult();
                                childCategories.clear();
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    ChildCategory childCategory = dataSnapshot.getValue(ChildCategory.class);
                                    childCategories.add(childCategory);
                                }
                            }
                            product.Childproduct(childCategories);
                            Classification();
                        }
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });

    }

    // to Classification all Children to according parents
    public void getChildren(String child) {
        reference.child(CHILDREN).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected()) {
                        if (task.getResult().exists()) {
                            if (task.isComplete()) {
                                DataSnapshot snapshot = task.getResult();
                                childCategories.clear();
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    ChildCategory childCategory = dataSnapshot.getValue(ChildCategory.class);
                                    if (childCategory.getPushIdParents().equals(child)) {
                                        childCategories.add(childCategory);
                                    }
                                }
                            }
                            product.Childrenproduct(childCategories);
                        }
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });

    }

    // to associate Children with his parents
    public void Classification() {
        ArrayList<ClassificationPC> classificationPCS = new ArrayList<>();
        for (ParentCategory parentCategory : parentCategories) {
            ArrayList<ChildCategory> c1 = new ArrayList<>();
            for (ChildCategory childCategory : childCategories) {
                if (parentCategory.getPushId().equals(childCategory.getPushIdParents())) {
                    c1.add(childCategory);
                }
            }
            classificationPCS.add(new ClassificationPC(c1, parentCategory.getName(), parentCategory.getImage(), false));
        }
        product.getClassificationPC(classificationPCS);
    }


    //  لم تستخدم بعد
    private void Rearrange() {
        for (int i = 0; i < parentCategories.size(); i++) {
            ArrayList<ArrayList<Product>> arrayListArrayList = new ArrayList<>();
            for (int j = 0; j < childCategories.size(); j++) {
                ArrayList<Product> al = new ArrayList<>();
                for (Product product : products) {
                    if (product.getParentCategoryId().equals(parentCategories.get(i).getName())) {
                        if (product.getChildCategoryId().equals(childCategories.get(j).getName())) {
                            al.add(product);
                        }
                    }
                }
                arrayListArrayList.add(al);
            }
            arrayListOfArrayLists.add(arrayListArrayList);
        }
        product.product(arrayListOfArrayLists);
    }


    public void getQuery(String query) {
        reference.child(PRODUCT).orderByChild("productName").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (task.getResult().exists() && isNetworkConnected()) {
                        DataSnapshot snapshot = task.getResult();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Product product = dataSnapshot.getValue(Product.class);
                            if (Objects.requireNonNull(product).getProductName().contains(query) || product.getChildCategoryName().contains(query) || product.getParentCategoryName().contains(query) || product.getKeywords().contains(query)) {
                                QueryProducts.add(product);
                            }
                        }
                        product.getQueryProducts(QueryProducts);
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });
    }

    // to get all product which in the same parent
    public void FilterByParent(String parentId) {
        reference.child(PRODUCT).orderByChild("parentCategoryId").equalTo(parentId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Product product = dataSnapshot.getValue(Product.class);
                            QueryProductsByParents.add(product);
                        }
                        product.getQueryByParents(QueryProductsByParents);
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });
    }

    public void getSearchByChild(String ChildId) {
        reference.child(PRODUCT).orderByChild("parentCategoryId").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Product product = dataSnapshot.getValue(Product.class);
                            if (product.getChildCategoryId().equals(ChildId)) {
                                QueryProductsByChild.add(product);
                            }
                        }
                        product.getQueryByChild(QueryProductsByChild);
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });
    }

    public void ProductWithTrademark(String name) {
        reference.child(PRODUCT).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (isNetworkConnected() && task.getResult().exists()) {
                    DataSnapshot snapshot = task.getResult();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Product product = dataSnapshot.getValue(Product.class);
                        if (product.getTradeMark().equals(name)) {
                            productWithTrademark.add(product);
                        }
                    }
                    product.getProductWithTrademark(productWithTrademark);
                }
            }
        });
    }

    // to get Top Deals
    public void TopDeals() {
        reference.child(PRODUCT).orderByChild("discount").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Product product = dataSnapshot.getValue(Product.class);
                            productsTopDeals.add(product);
                        }
                        product.getProductTopDeals(productsTopDeals);
                    }
                } catch (Exception e) {
                    Log.e("Exception", e.toString());
                    ShowToast("No Internet Connection");
                }
            }
        });

    }

    public void getProductById(String id) {
        reference.child(PRODUCT).child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                ArrayList<Product> productArrayList = new ArrayList<>();
                try {
                    if (isNetworkConnected() && task.getResult().exists()) {
                        Product p = task.getResult().getValue(Product.class);
                        productArrayList.add(p);
                        product.getProductById(productArrayList);
                    }
                } catch (Exception e) {
                    Log.e("Exception", e.toString());
                    ShowToast("No Internet Connection");
                }
            }
        });

    }


    public void getLastSearches(List<String> recentSearches) {
        reference.child(PRODUCT).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try {
                    if (task.getResult().exists() && isNetworkConnected()) {
                        DataSnapshot snapshot = task.getResult();
                        recentSearchProduct.clear();
                        for (String recentSearch : recentSearches) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Product product = dataSnapshot.getValue(Product.class);
                                if (product.getKeywords().contains(recentSearch)) {
                                    recentSearchProduct.add(product);
                                }
                            }
                        }
                        product.getLastSearchProduct(recentSearchProduct);
                    }
                } catch (Exception e) {
                    ShowToast("No Internet Connection");
                }

            }
        });
    }

}

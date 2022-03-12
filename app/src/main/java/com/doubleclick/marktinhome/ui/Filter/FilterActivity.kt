package com.doubleclick.marktinhome.ui.Filter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnProduct
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.marktinhome.Adapters.ProductAdapter
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.ProductActivity.ProductActivity

class FilterActivity : AppCompatActivity(), OnProduct {


    lateinit var FilterRecycler: RecyclerView;
    lateinit var productViewModel: ProductViewModel
    lateinit var search: String
    lateinit var childCategoryId: String
    lateinit var idProduct: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        FilterRecycler = findViewById(R.id.FilterRecycler)

        childCategoryId = intent.extras!!.getString("childCategoryId", "").toString()
        search = intent.extras!!.getString("search", "").toString()
        idProduct = intent.extras!!.getString("idProduct", "").toString()
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        if (!search.equals("")) {
            productViewModel.getSearch(search);
            productViewModel.searchLiveData.observe(this, Observer {
                var productAdapter = ProductAdapter(it, this);
                FilterRecycler.adapter = productAdapter

            })
        }
        if (!childCategoryId.equals("")) {
            productViewModel.getSearchByChild(childCategoryId)
            productViewModel.FilterByChildLiveDate().observe(this, Observer {
                var productAdapter = ProductAdapter(it, this);
                FilterRecycler.adapter = productAdapter
            })
        }
        if (!idProduct.equals("")){
            productViewModel.getSearchByIdProduct(idProduct)
            productViewModel.searchByIdProductLiveData.observe(this, Observer {
                var productAdapter = ProductAdapter(it, this);
                FilterRecycler.adapter = productAdapter
            })
        }


    }

    override fun onItemProduct(product: Product?) {
        var intent = Intent(applicationContext,ProductActivity::class.java);
        intent.putExtra("Product",product);
        startActivity(intent)
    }
}
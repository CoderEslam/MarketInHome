package com.doubleclick.marktinhome.ui.MainScreen;

import static com.doubleclick.marktinhome.Model.Constantes.RECENTSEARCH;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.ProductViewModel;
import com.doubleclick.ViewModel.RecentSearchViewModel;
import com.doubleclick.ViewModel.UserViewModel;
import com.doubleclick.marktinhome.Adapters.CartAdapter;
import com.doubleclick.marktinhome.Adapters.NavAdapter;
import com.doubleclick.marktinhome.Model.Cart;
import com.doubleclick.marktinhome.Model.ChildCategory;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.Model.RecentSearch;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Repository.Sending;
import com.doubleclick.marktinhome.Views.SmoothButtom.SmoothBottomBar;
import com.doubleclick.marktinhome.ui.Filter.FilterActivity;
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.HomeFragment;
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.menu_listFragment;
import com.doubleclick.marktinhome.ui.ProductActivity.productFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.common.util.NumberUtils;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainScreenActivity extends AppCompatActivity implements NavAdapter.onClickChild {

    private SmoothBottomBar bottomBar;
    private NavController navController;
    private RecyclerView menu_recycler_view;
    private ProductViewModel productViewModel;
    private SearchView search;
    private FlowingDrawer drawerLayout;
    private ImageView openDrawer;
    private UserViewModel userViewModel;
    private CircleImageView myImage;
    private View main_fragment;
    private final String PLAIN_TEXT_MIME = "text/plain";
    private DatabaseReference reference;
    private String[] lastSearch = new String[3000];
    private String myId;
    private RecentSearchViewModel recentSearchViewModel;
    private String ProductId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        reference = FirebaseDatabase.getInstance().getReference();
        recentSearchViewModel = new ViewModelProvider(this).get(RecentSearchViewModel.class);
        myId = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        ProductId = getIntent().getStringExtra("ProductId");
        main_fragment = findViewById(R.id.main_fragment);
        navController = Navigation.findNavController(this, main_fragment.getId());
        menu_recycler_view = findViewById(R.id.menu_recycler_view);
        search = findViewById(R.id.search);
        bottomBar = findViewById(R.id.bottomBar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        openDrawer = findViewById(R.id.openDrawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        myImage = findViewById(R.id.myImage);
        drawerLayout.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Glide.with(MainScreenActivity.this).load(user.getImage()).into(myImage);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.menu_Cart,/* R.id.menu_list, */R.id.homeFragment, R.id.menu_profile).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        setupSmoothBottomMenu();
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getClassificationPC().observe(this, classificationPCS -> {
            NavAdapter catecoriesAdapter = new NavAdapter(classificationPCS, this);
            menu_recycler_view.setAdapter(catecoriesAdapter);
        });

        openDrawer.setOnClickListener(v -> {
            drawerLayout.openMenu(true);
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.contains("https://com.doubleclick.marktinhome/")) {
                    String[] url = query.split("com.doubleclick.marktinhome/");
                    String idProduct = url[1];
                    Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                    intent.putExtra("idProduct", idProduct);
                    startActivity(intent);
                    search.setTag(getResources().getString(R.string.search_here));
                    search.setQueryHint(getResources().getString(R.string.search_here));
                } else {
                    Sending.Check(query, MainScreenActivity.this, MainScreenActivity.this);
                    Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
                    intent.putExtra("search", query);
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        //  https://developer.android.com/training/sharing/receive#java
//        HandleShare();
        Share(ProductId);
    }

    private void Share(String ProductId) {
        try {
            if (!ProductId.equals("")) {
                Bundle bundle = new Bundle();
                bundle.putString("idProduct", ProductId);
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);
                productFragment productFragment = new productFragment();
                productFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.main_fragment, homeFragment).commit();
//                Intent intent = new Intent(MainScreenActivity.this, FilterActivity.class);
//                intent.putExtra("idProduct", ProductId);
//                startActivity(intent);
            }
        } catch (NullPointerException e) {

        }

    }

    private void HandleShare() {
        if (Intent.ACTION_SEND.equals(getIntent().getAction()) && getIntent().getType() != null) {
            if (PLAIN_TEXT_MIME.equals(getIntent().getType())) {
                handleSendText(getIntent());
            }
        }
    }

    private void handleSendText(Intent intent) {
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
        String[] url = text.split("https://www.market.doublethink.com/");
        String idProduct = url[1];
        Intent FilterActivityintent = new Intent(MainScreenActivity.this, FilterActivity.class);
        FilterActivityintent.putExtra("idProduct", idProduct);
        startActivity(FilterActivityintent);
    }


    private void setupSmoothBottomMenu() {
        PopupMenu popupMenu = new PopupMenu(this, null);
        popupMenu.inflate(R.menu.menu_bottom);
        Menu menu = popupMenu.getMenu();
        bottomBar.setupWithNavController(menu, navController);
    }

    @Override
    public void onClickedNavChild(ChildCategory childCategory) {
        Intent intent = new Intent(this, FilterActivity.class);
        intent.putExtra("childCategoryId", childCategory.getPushId());
        startActivity(intent);
    }

}
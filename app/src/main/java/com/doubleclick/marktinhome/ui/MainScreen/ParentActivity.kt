package com.doubleclick.marktinhome.ui.MainScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnProduct
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.marktinhome.Adapters.ProductAdapter
import com.doubleclick.marktinhome.Model.ClassificationPC
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.Filter.FilterActivity
import com.doubleclick.marktinhome.ui.ProductActivity.productActivity

class ParentActivity : AppCompatActivity(), OnProduct {


    //    lateinit var  binding :ActivityParentBinding
    lateinit var parents: RecyclerView
    lateinit var classificationPC: ClassificationPC
    lateinit var productViewModel: ProductViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_parent)
        parents = findViewById(R.id.parents);
        classificationPC = intent.getSerializableExtra("classificationPC") as ClassificationPC
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java];
        productViewModel.getClassificationByParent(classificationPC.parentPushId);
        productViewModel.classificationByParentLiveData.observe(this, Observer {
            val productAdapter = ProductAdapter(it, this);
            parents.adapter = productAdapter
        })

    }

    override fun onItemProduct(product: Product?) {
        val intent = Intent(this@ParentActivity, productActivity::class.java)
        intent.putExtra("product", product);
        startActivity(intent);

    }
}
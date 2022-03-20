package com.doubleclick.marktinhome.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.databinding.ActivityParentBinding

class ParentActivity : AppCompatActivity() {


//    lateinit var  binding :ActivityParentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_parent)



    }
}
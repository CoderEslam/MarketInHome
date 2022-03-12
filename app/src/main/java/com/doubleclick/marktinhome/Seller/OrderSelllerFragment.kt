package com.doubleclick.marktinhome.Seller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.marktinhome.Adapters.OrderAdapter
import com.doubleclick.marktinhome.R


class OrderSelllerFragment : Fragment()  {

    lateinit var MyOrder:RecyclerView;
    lateinit var cartViewModel: CartViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_order_selller, container, false)
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        MyOrder = view.findViewById(R.id.MyOrder);

        cartViewModel.OrdersLiveData().observe(this, Observer {
            var orderAdapter:OrderAdapter = OrderAdapter(it)
            MyOrder.adapter = orderAdapter;
        })


        return view;
    }

}
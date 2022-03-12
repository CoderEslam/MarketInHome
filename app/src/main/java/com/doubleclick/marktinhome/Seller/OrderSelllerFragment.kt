package com.doubleclick.marktinhome.Seller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.OnOrder
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.ViewModel.OrderViewModel
import com.doubleclick.marktinhome.Adapters.OrderAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Cart
import com.doubleclick.marktinhome.Model.Constantes.CART
import com.doubleclick.marktinhome.Model.Constantes.RECENTORDER
import com.doubleclick.marktinhome.R


class OrderSelllerFragment : BaseFragment(), OnOrder {

    lateinit var MyOrder: RecyclerView;
    lateinit var cartViewModel: CartViewModel
    lateinit var orderViewModel : OrderViewModel
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
        orderViewModel = ViewModelProvider(this)[OrderViewModel::class.java]
        orderViewModel.myOrderLiveData.observe(viewLifecycleOwner, Observer {

        })
        MyOrder = view.findViewById(R.id.MyOrder);
//        cartViewModel.OrdersSellerLiveData().observe(viewLifecycleOwner, Observer {
//            var orderAdapter: OrderAdapter = OrderAdapter(it, this)
//            MyOrder.adapter = orderAdapter;
//        })

        return view;
    }

    override fun OnOKItemOrder(cart: Cart?) {
        val pushId = myId + ":" + cart!!.productId
        val map: HashMap<String, Any> = HashMap();
        map["ProductId"] = cart.productId;
        map["BuyerId"] = myId;
        map["SellerId"] = cart.sellerId;
        map["TotalPrice"] = cart.totalPrice;
        map["Quantity"] = cart.quantity;
        map["price"] = cart.price;
        map["image"] = cart.image;
        map["productName"] = cart.productName;
        reference.child(RECENTORDER).child(pushId).updateChildren(map);
        reference.child(CART).child(cart!!.buyerId+":"+cart.productId).removeValue().addOnCompleteListener {
            if (it.isSuccessful){
                ShowToast(context,"Deliverd")
            }
        }
    }

    override fun OnCancelItemOrder(cart: Cart?) {
        reference.child(CART).child(cart!!.buyerId+":"+cart.productId).removeValue().addOnCompleteListener {
            if (it.isSuccessful){
                ShowToast(context,"Deleted")
            }
        }
    }

}
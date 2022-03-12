package com.doubleclick.marktinhome.ui.ProductActivity

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.doubleclick.ViewModel.RateViewModel
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes.*
import com.doubleclick.marktinhome.Model.Product
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.ChildFragmentArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.HashMap


class productFragment : BaseFragment() {


    private lateinit var fab: FloatingActionButton
    private lateinit var imageProduct: ImageView
    private lateinit var productName: TextView
    private lateinit var trarmark: TextView
    private lateinit var price: TextView
    private lateinit var lastPrice: TextView
    private lateinit var description: TextView
    private lateinit var TotalRating: TextView;
    private lateinit var tvRate1: TextView
    private lateinit var tvRate2: TextView
    private lateinit var tvRate3: TextView
    private lateinit var tvRate4: TextView
    private lateinit var tvRate5: TextView
    private lateinit var progressBar1: ProgressBar
    private lateinit var progressBar2: ProgressBar
    private lateinit var progressBar3: ProgressBar
    private lateinit var progressBar4: ProgressBar
    private lateinit var progressBar5: ProgressBar
    private lateinit var yourRate: RatingBar;
    private lateinit var rateViewModel: RateViewModel;
    var r1 = 0f
    var r2 = 0f
    var r3 = 0f
    var r4 = 0f
    var r5 = 0f
    lateinit var plus: ImageView
    lateinit var mins: ImageView
    lateinit var quantity: TextView
    var q: Int = 0
    lateinit var share: ImageView


    private val product by navArgs<productFragmentArgs>()

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
        var view = inflater.inflate(R.layout.fragment_product, container, false)
        rateViewModel = ViewModelProvider(this)[RateViewModel::class.java]
        fab = view.findViewById(R.id.fab)
        imageProduct = view.findViewById(R.id.imageProduct)
        productName = view.findViewById(R.id.productName)
        trarmark = view.findViewById(R.id.trarmark)
        price = view.findViewById(R.id.price)
        lastPrice = view.findViewById(R.id.lastPrice)
        description = view.findViewById(R.id.description)
        TotalRating = view.findViewById(R.id.TotalRating)
        tvRate1 = view.findViewById(R.id.tvRate1)
        tvRate2 = view.findViewById(R.id.tvRate2)
        tvRate3 = view.findViewById(R.id.tvRate3)
        tvRate4 = view.findViewById(R.id.tvRate4)
        tvRate5 = view.findViewById(R.id.tvRate5)
        progressBar1 = view.findViewById(R.id.progressBar1);
        progressBar2 = view.findViewById(R.id.progressBar2);
        progressBar3 = view.findViewById(R.id.progressBar3);
        progressBar4 = view.findViewById(R.id.progressBar4);
        progressBar5 = view.findViewById(R.id.progressBar5);
        yourRate = view.findViewById(R.id.yourRate);
        plus = view.findViewById(R.id.plus)
        quantity = view.findViewById(R.id.quantity)
        mins = view.findViewById(R.id.mins)
        share = view.findViewById(R.id.share);
        productName.text = product.product!!.productName
        trarmark.text = product.product!!.tradeMark
        price.text = product.product!!.price
        lastPrice.text = product.product!!.lastPrice
        description.text = product.product!!.description
        Glide.with(this).load(product.product!!.image).into(imageProduct)
        rateViewModel.getMyRate(myId, product.product!!.productId)
        rateViewModel.myRateing.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                yourRate.rating = it.rate.toFloat();
            }
        })
        rateViewModel.getAllRate(product.product!!.productId)
        rateViewModel.allRateing.observe(viewLifecycleOwner, Observer {
            TotalRating.text = it.size.toString()
            var map: HashMap<String, Any> = HashMap();
            map.put("TotalRating", (it.size));
            reference.child(PRODUCT).child(product.product!!.productId).updateChildren(map);
            for (i in it) {
                if (0.0 < i.rate.toFloat() && i.rate.toFloat() <= 1.0) {
                    r1 += 1
                    progressBar1.progress = ((r1.toInt() / it.size) * 100)
                    tvRate1.text = r1.toInt().toString()

                }
                if (1.0 < i.rate.toFloat() && i.rate.toFloat() <= 2.0) {
                    r2 += 1
                    progressBar2.progress = ((r2.toInt() / it.size) * 100)
                    tvRate2.text = r2.toInt().toString()

                }
                if (2.0 < i.rate.toFloat() && i.rate.toFloat() <= 3.0) {
                    r3 += 1
                    progressBar3.progress = ((r3.toInt() / it.size) * 100)
                    tvRate3.text = r3.toInt().toString()

                }
                if (3.0 < i.rate.toFloat() && i.rate.toFloat() <= 4.0) {
                    r4 += 1
                    progressBar4.progress = ((r4.toInt() / it.size) * 100)
                    tvRate4.text = r4.toInt().toString()

                }
                if (4.0 < i.rate.toFloat() && i.rate.toFloat() <= 5.0) {
                    r5 += 1
                    progressBar5.progress = ((r5.toInt() / it.size) * 100)
                    tvRate5.text = r5.toInt().toString()
                }
            }
        })

        fab.setOnClickListener { v: View? ->
            if (q != 0) {
                var pushId = myId + ":" + product.product!!.productId
                var map: HashMap<String, Any> = HashMap();
                map.put("ProductId", product.product!!.productId);
                map.put("BuyerId", myId);
                map.put("SellerId", product.product!!.adminId);
                map.put("TotalPrice", (q.toDouble() * product.product!!.price.toDouble()).toLong());
                map.put("Quantity", q.toLong());
                map.put("price", product.product!!.price.toLong());
                map.put("image", product.product!!.image);
                map.put("productName", product.product!!.productName);
                reference.child(CART).child(pushId).setValue(map);
            } else {
                ShowToast(context, "you can't order less than one!");
            }


        }

        yourRate.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            var push = myId + ":" + product.product!!.productId
            if (rating > 0f) {
                var map: HashMap<String, Any> = HashMap();
                map.put("push", push)
                map.put("rate", rating.toString())
                map.put("productId", product.product!!.productId)
                map.put("myId", myId)
                reference.child(RATE).child(push).updateChildren(map);
            }
            if (rating == 0f) {
                reference.child(RATE).child(push).removeValue();

            }
        }

        plus.setOnClickListener {
            q++
            quantity.text = q.toString()
        }

        mins.setOnClickListener {

            if (quantity.text.toString().equals("0")) {
                q = 1;
                quantity.text = q.toString()
                ShowToast(context, "you can't order less than one!");
                return@setOnClickListener
            } else {
                q--
                quantity.text = q.toString()
            }

        }

        share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "https://com.doubleclick.marktinhome/" + product.product!!.productId
                )
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
        return view;
    }

}
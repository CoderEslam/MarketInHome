package com.doubleclick.marktinhome.ui.MainScreen.Address

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Cart
import com.doubleclick.marktinhome.Model.Constantes.REQUESTS
import com.doubleclick.marktinhome.R
import com.google.android.material.textfield.TextInputEditText
import de.hdodenhof.circleimageview.CircleImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddressFragment : BaseFragment() {

    lateinit var imagePerson: CircleImageView;
    lateinit var name: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var anotherPhone: TextInputEditText
    lateinit var address: TextInputEditText
    lateinit var confirmFinalOrderBtn: Button
    private lateinit var cartViewModel: CartViewModel
    lateinit var carts: ArrayList<Cart>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_address, container, false)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        imagePerson = view.findViewById(R.id.imagePerson);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        anotherPhone = view.findViewById(R.id.anotherPhone);
        address = view.findViewById(R.id.address);
        confirmFinalOrderBtn = view.findViewById(R.id.confirmFinalOrderBtn)

        confirmFinalOrderBtn.setOnClickListener {
            confirmOrder(
                name.text.toString(),
                phone.text.toString(),
                anotherPhone.text.toString(),
                address.text.toString()
            )
        }

        cartViewModel.CartLiveData().observe(viewLifecycleOwner) { carts: ArrayList<Cart> ->
            if (carts.size != 0) {
                confirmFinalOrderBtn.isEnabled = true
                this.carts = carts;
            }
        }

        return view;
    }

    private fun confirmOrder(name: String, phone: String, AnotherPhone: String, Address: String) {
        for (i in carts.indices) {
            var pushId = reference.push().key.toString();
            var map: HashMap<String, Any> = HashMap();
            map.put("ProductId", carts[i].productId)
            map.put("price", carts[i].price)
            map.put("Quantity", carts[i].quantity)
            map.put("lastPrice", carts[i].lastPrice)
            map.put("productName", carts[i].productName)
            map.put("image", carts[i].image)
            map.put("id", pushId)
            map.put("BuyerId", carts[i].buyerId)
            map.put("SellerId", carts[i].sellerId)
            map.put("TotalPrice", carts[i].totalPrice)
            map.put("phone", phone)
            map.put("anotherPhone", AnotherPhone)
            map.put("address", Address)
            map.put("name", name)
            sendNotifiaction(getContext(), carts[i].sellerId, carts[i].productName);
            reference.child(REQUESTS).child(pushId).updateChildren(map)
        }
    }

}
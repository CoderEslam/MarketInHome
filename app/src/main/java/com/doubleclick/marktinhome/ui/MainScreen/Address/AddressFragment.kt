package com.doubleclick.marktinhome.ui.MainScreen.Address

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.doubleclick.ConfigPay.ConfigPay.PAYPAL_CLINT_ID
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Cart
import com.doubleclick.marktinhome.Model.Constantes.CART
import com.doubleclick.marktinhome.Model.Constantes.ORDERS
import com.doubleclick.marktinhome.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.textfield.TextInputEditText
import com.paypal.android.sdk.payments.PayPalConfiguration
import com.paypal.android.sdk.payments.PayPalPayment
import com.paypal.android.sdk.payments.PayPalService
import com.paypal.android.sdk.payments.PaymentActivity
import de.hdodenhof.circleimageview.CircleImageView
import java.math.BigDecimal
import java.util.*


class AddressFragment : BaseFragment(), OnMapReadyCallback {

    lateinit var imagePerson: CircleImageView;
    lateinit var name: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var anotherPhone: TextInputEditText
    lateinit var address: TextInputEditText
    lateinit var confirmFinalOrderBtn: Button
    private lateinit var cartViewModel: CartViewModel
    lateinit var carts: ArrayList<Cart>
    var client: FusedLocationProviderClient? = null
    var googleMap: GoogleMap? = null
    var supportMapFragment: SupportMapFragment? = null
    var mLocationRequest: LocationRequest? = null
    var locationManager: LocationManager? = null
    var uri: String? = null
    lateinit var myLocation: SwitchCompat

    private val config =
        PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK)
            .clientId(PAYPAL_CLINT_ID)

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
        myLocation = view.findViewById(R.id.myLocation);
        locationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        client = LocationServices.getFusedLocationProviderClient(requireContext())
        supportMapFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        confirmFinalOrderBtn.setOnClickListener {
            confirmOrder(
                name.text.toString(),
                phone.text.toString(),
                anotherPhone.text.toString(),
                address.text.toString()
            )
            // TODO Pay by PayPal
//            onBuyPressed();
        }

        cartViewModel.CartLiveData().observe(viewLifecycleOwner) { carts: ArrayList<Cart> ->
            if (carts.size != 0) {
                confirmFinalOrderBtn.isEnabled = true
                this.carts = carts;
            }
        }

        myLocation.setOnClickListener {
            getMyLocation()
        }

        return view;
    }

    private fun confirmOrder(name: String, phone: String, AnotherPhone: String, Address: String) {
        for (i in carts.indices) {
            var time: Long = Date().time
            var id = myId + ":" + carts[i].productId + ":" + time;
            var map: HashMap<String, Any> = HashMap();
            map["ProductId"] = carts[i].productId
            map["price"] = carts[i].price
            map["Quantity"] = carts[i].quantity
            map["lastPrice"] = carts[i].lastPrice
            map["productName"] = carts[i].productName
            map["images"] = carts[i].images
            map["id"] = id
            map["BuyerId"] = carts[i].buyerId
            map["SellerId"] = carts[i].sellerId
            map["TotalPrice"] = carts[i].totalPrice
            map["phone"] = phone
            map["anotherPhone"] = AnotherPhone
            map["address"] = Address
            map["name"] = name
            map["date"] = time
            map["ToggleItem"] = carts[i].toggleItem
            if (myLocation.isChecked) {
                if (!uri.toString().equals("")) {
                    map["locationUri"] = uri!!
                    sendNotifiaction(getContext(), carts[i].sellerId, carts[i].productName);
                    reference.child(ORDERS).child(id).updateChildren(map)
                    reference.child(CART).child(carts[i].id).removeValue()
                } else {
                    Toast.makeText(requireContext(), "Open your location", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                sendNotifiaction(getContext(), carts[i].sellerId, carts[i].productName);
                reference.child(ORDERS).child(id).updateChildren(map)
                reference.child(CART).child(carts[i].id).removeValue()
            }


        }
    }

    private fun getMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val task = client!!.lastLocation
            task.addOnSuccessListener { location ->
                if (location != null) {
//                    supportMapFragment!!.getMapAsync {
                    val latLng = LatLng(location.latitude, location.longitude)
                    uri = "[" + location.latitude + "," + location.longitude + "]"
//                    }
                } else {
                    Toast.makeText(requireContext(), "Open your location", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = 1000
        mLocationRequest!!.fastestInterval = 1000
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    fun onBuyPressed() {

        // PAYMENT_INTENT_SALE will cause the payment to complete immediately.
        // Change PAYMENT_INTENT_SALE to
        //   - PAYMENT_INTENT_AUTHORIZE to only authorize payment and capture funds later.
        //   - PAYMENT_INTENT_ORDER to create a payment for authorization and capture
        //     later via calls from your server.

//        PayPalPayment payment = new PayPalPayment(new BigDecimal("100.75"), "USD", "Frankenstein", PayPalPayment.PAYMENT_INTENT_SALE);
        val payment =
            PayPalPayment(BigDecimal(100), "USD", "Total Price", PayPalPayment.PAYMENT_INTENT_SALE)
        val intent = Intent(context, PaymentActivity::class.java)
        // send the same configuration for restart resiliency
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment)
        startActivityForResult(intent, 0)
    }


}
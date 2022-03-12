package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.ViewModel.CartViewModel
import com.doubleclick.marktinhome.Adapters.CartAdapter
import com.doubleclick.marktinhome.Adapters.CartAdapter.CartViewHolder
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Cart
import com.doubleclick.marktinhome.Model.Constantes.CART
import com.doubleclick.marktinhome.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import de.hdodenhof.circleimageview.CircleImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : BaseFragment() {


    private lateinit var cartViewModel: CartViewModel
    private lateinit var cartRecycler: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var Continue: TextView
    private lateinit var totalPrice: TextView
    var Carts: ArrayList<Cart>? = null;
    private var Total = 0.0

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
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        cartRecycler = view.findViewById(R.id.cartRecycler)
        Continue = view.findViewById(R.id.Continue)
        totalPrice = view.findViewById(R.id.totalPrice)

        cartViewModel.CartLiveData().observe(viewLifecycleOwner) { carts: ArrayList<Cart> ->
            if (carts.size != 0) {
                Carts = carts
                cartAdapter = CartAdapter(carts)
                cartRecycler.adapter = cartAdapter
                for (i in carts.indices) {
                    Total += carts[i].price.toDouble() * carts[i].quantity.toDouble()
                    totalPrice.text = Total.toString()
                }
            }
        }
        Continue.setOnClickListener { v ->
            findNavController().navigate(
                CartFragmentDirections.actionMenuCartToAddressFragment(Carts!!.toTypedArray())
            )
        }

        val options = FirebaseRecyclerOptions.Builder<Cart>()
            .setQuery(reference.child(CART), Cart::class.java)
            .setLifecycleOwner(this)
            .build()

        val adapter = object : FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
                return CartViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.layaut_cart, parent, false)
                )
            }

            protected override fun onBindViewHolder(holder: CartViewHolder, position: Int, cart: Cart) {



            }

            override fun onDataChanged() {

            }
        }

        return view
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageCart: CircleImageView
        private val CartName: TextView
        private val price: TextView
        private val quantity: TextView
        private val add: ImageView
        private val mins: ImageView
        private val delete: ImageView

        init {
            imageCart = itemView.findViewById(R.id.imageCart)
            CartName = itemView.findViewById(R.id.CartName)
            price = itemView.findViewById(R.id.price)
            quantity = itemView.findViewById(R.id.quantity)
            add = itemView.findViewById(R.id.add)
            mins = itemView.findViewById(R.id.mins)
            delete = itemView.findViewById(R.id.delete)
        }
    }


}
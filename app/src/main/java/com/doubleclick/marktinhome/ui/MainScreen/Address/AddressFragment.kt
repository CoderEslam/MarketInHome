package com.doubleclick.marktinhome.ui.MainScreen.Address

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.navArgs
import com.doubleclick.marktinhome.R
import com.doubleclick.marktinhome.ui.MainScreen.Frgments.FilterParentFragmentArgs
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
class AddressFragment : Fragment() {

    lateinit var imagePerson: CircleImageView;
    lateinit var name: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var anotherPhone: TextInputEditText
    lateinit var address: TextInputEditText
    lateinit var confirmFinalOrderBtn: Button
    private val addressFragmentArgs by navArgs<AddressFragmentArgs>()


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
        imagePerson = view.findViewById(R.id.imagePerson);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        anotherPhone = view.findViewById(R.id.anotherPhone);
        address = view.findViewById(R.id.address);
        confirmFinalOrderBtn = view.findViewById(R.id.confirmFinalOrderBtn)

        for (i in addressFragmentArgs.carts!!.indices){
            Log.e("addressFragmentArgs",""+addressFragmentArgs.carts!![i].toString())
        }

        return view;
    }

}
package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.marktinhome.Adapters.TrademarkAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.R
import java.io.File


class UploadFragment : BaseFragment() {


    lateinit var marke: String
    private lateinit var productImage: ImageView;
    private lateinit var productName: EditText;
    private lateinit var productPrice: EditText;
    private lateinit var productLastPrice: EditText;
    private lateinit var description: EditText;
    lateinit var keywords: EditText
    private lateinit var trademark: AppCompatSpinner;
    private lateinit var Upload: Button;
    private lateinit var baseFragment: BaseFragment;
    private lateinit var tradmarkViewModel: TradmarkViewModel
    val parent_child by navArgs<UploadFragmentArgs>()


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
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_upload, container, false)
        productImage = view.findViewById(R.id.productImage);
        productName = view.findViewById(R.id.productName);
        productPrice = view.findViewById(R.id.productPrice);
        productLastPrice = view.findViewById(R.id.productLastPrice);
        description = view.findViewById(R.id.description);
        trademark = view.findViewById(R.id.trademark);
        Upload = view.findViewById(R.id.Upload);
        keywords = view.findViewById(R.id.keywords);
        tradmarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
        tradmarkViewModel.namesMark.observe(viewLifecycleOwner, Observer {
//            var trademarkAdapter  = TrademarkAdapter(it)
            trademark.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    marke = it.get(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    marke = it.get(0)

                }
            }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it)
            trademark.setAdapter(adapter)


        })

        Upload.setOnClickListener {
            upload(
                productName.text.toString(),
                productPrice.text.toString().toDouble(),
                productLastPrice.text.toString().toDouble(),
                description.text.toString(),
                keywords.text.toString(),
                marke,
                parent_child.parent!!.pushId,
                parent_child.child!!.pushId,
                parent_child.parent!!.name,
                parent_child.child!!.name
            )
        }
        productImage.setOnClickListener {
            openImage()
        }

        return view;
    }

    override fun onStart() {
        try {
            var file = File(imageUri.toString())
            val fileSizeInBytes: Long = file.length()
            if (fileSizeInBytes > 5000) {
                ShowToast(context, "Size of image is to ")
            }
            if (imageUri != null && fileSizeInBytes > 5000) {
                productImage.setImageURI(imageUri)
            }
        } catch (e: RuntimeException) {
            ShowToast(context, "" + e.message.toString())
        } catch (e: Exception) {
            ShowToast(context, "" + e.message.toString())
        }
        super.onStart()
    }


}
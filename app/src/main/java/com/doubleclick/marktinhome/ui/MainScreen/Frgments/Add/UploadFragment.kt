package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add


import android.app.Activity.RESULT_OK
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.marktinhome.Adapters.ImageAdapter
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.Constantes
import com.doubleclick.marktinhome.Model.Constantes.PRODUCT
import com.doubleclick.marktinhome.R
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import java.util.*


class UploadFragment : BaseFragment() {


    lateinit var marke: String
    private var IMAGES_REQUEST: Int = 100
    private lateinit var productName: EditText;
    private lateinit var productPrice: EditText;
    private lateinit var productLastPrice: EditText;
    private lateinit var description: EditText;
    private lateinit var keywords: EditText
    private lateinit var trademark: AppCompatSpinner;
    private lateinit var Upload: Button;
    private lateinit var tradmarkViewModel: TradmarkViewModel
    private lateinit var uris: MutableList<Uri>
    private lateinit var productImages: RecyclerView
    private lateinit var downloadUri: HashMap<String, Any>
    lateinit var selectImages: Button

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
        productName = view.findViewById(R.id.productName);
        productPrice = view.findViewById(R.id.productPrice);
        productLastPrice = view.findViewById(R.id.productLastPrice);
        description = view.findViewById(R.id.description);
        trademark = view.findViewById(R.id.trademark);
        Upload = view.findViewById(R.id.Upload);
        keywords = view.findViewById(R.id.keywords);
        productImages = view.findViewById(R.id.productImages);
        selectImages = view.findViewById(R.id.selectImages);
        uris = ArrayList()
        downloadUri = HashMap();
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
            UploadImages(
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
        selectImages.setOnClickListener {
            openImage()
        }
        return view;
    }

    override fun openImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent, IMAGES_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGES_REQUEST && resultCode == RESULT_OK) {
            val clip = data!!.clipData
            if (clip != null) {
                for (j in 0 until clip.itemCount) {
                    val item = clip.getItemAt(j)
                    uris.add(item.uri)
                    Log.e("clipData", uris.toString())
                }
                var ImageAdapter = ImageAdapter(uris);
                productImages.adapter = ImageAdapter
            }
        }
    }

    override fun getFileExtension(uri: Uri?): String? {
        val contentResolver = requireContext().contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri!!))
    }


    /*override fun upload(
        name: String?,
        price: Double,
        LastPrice: Double,
        descroiprion: String,
        keywords: String,
        trademark: String?,
        ParentId: String?,
        ChildId: String?,
        ParentName: String?,
        ChildName: String?
    ) {
        val pd = ProgressDialog(context)
        pd.setMessage("Uploading")
        pd.show()
        if (uris.size != 0) {
            val fileReference = storageReference.child(
                System.currentTimeMillis().toString() + "." + getFileExtension(imageUri)
            )
            val uploadTask: StorageTask<*>
            uploadTask = fileReference.putFile(imageUri)
            uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot?, Task<Uri?>?> { task ->
                if (!task.isSuccessful) {
                    throw task.exception!!
                }
                fileReference.downloadUrl
            }).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri: Uri? = task.result
                    val mUri = downloadUri.toString()
                    val push = reference.push().key.toString()
                    val date = Date()
                    val map: HashMap<String, Any> = HashMap()
                    val discount = 100.0 - -1.0 * (price / LastPrice * 100.0)
                    map["productId"] = push
                    map["price"] = price
                    map["description"] = descroiprion + ""
                    map["date"] = date.time
                    map["adminId"] = myId
                    map["productName"] = name!!
                    map["lastPrice"] = LastPrice
                    map["tradeMark"] = trademark!!
                    map["parentCategoryId"] = ParentId!!
                    map["childCategoryId"] = ChildId!!
                    map["parentCategoryName"] = ParentName!!
                    map["childCategoryName"] = ChildName!!
                    map["keywords"] = keywords + ""
                    map["Image"] = mUri
                    map["TotalRating"] = 0
                    map["discount"] = discount
                    reference.child(Constantes.PRODUCT).child(Objects.requireNonNull(push))
                        .setValue(map)
                    pd.dismiss()
                } else {
                    Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
                    pd.dismiss()
                }
            }.addOnFailureListener { e ->
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                pd.dismiss()
            }
        } else {
            Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
        }
    }*/

    fun UploadImages(
        name: String?,
        price: Double,
        LastPrice: Double,
        descroiprion: String,
        keywords: String,
        trademark: String?,
        ParentId: String?,
        ChildId: String?,
        ParentName: String?,
        ChildName: String?
    ) {
        if (uris.size != 0) {
            val pd = ProgressDialog(requireContext())
            pd.setMessage("Uploading")
            pd.show()
            var storageReference = FirebaseStorage.getInstance().getReference("Uploads")
            for (i in 0 until uris.size) {
                val fileReference = storageReference.child(
                    System.currentTimeMillis().toString() + "." + getFileExtension(uris[i])
                )
                val uploadTask: StorageTask<*>
                uploadTask = fileReference.putFile(uris[i])
                uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot?, Task<Uri?>?> { task ->
                    if (!task.isSuccessful) {
                        throw task.exception!!
                    }
                    fileReference.downloadUrl.addOnSuccessListener(OnSuccessListener {
                        downloadUri["" + i + ""] = it
                        Log.e("uri", downloadUri.toString());

                    })
                }).addOnCompleteListener { task ->
                    if (task.isSuccessful()) {
                        if (uris.size == downloadUri.values.size) {
                            UplaodAllData(
                                name,
                                price,
                                LastPrice,
                                descroiprion,
                                keywords,
                                trademark,
                                ParentId,
                                ChildId,
                                ParentName,
                                ChildName,
                            )
                        }
                    }
                }
            }

            pd.dismiss()
        }
    }

    fun UplaodAllData(
        name: String?,
        price: Double,
        LastPrice: Double,
        descroiprion: String,
        keywords: String,
        trademark: String?,
        ParentId: String?,
        ChildId: String?,
        ParentName: String?,
        ChildName: String?,
    ) {
        val push = reference.push().key.toString()
        val date = Date()
        val map: HashMap<String, Any> = HashMap()
        var lastMoney = 0.0
        var money = 0.0
        if (price > LastPrice) {
            var helper = LastPrice;
            lastMoney = price
            money = helper;
        } else {
            money = price
            lastMoney = LastPrice
        }
        val discount = ((-1.0 * (price / LastPrice * 100.0)) - 100)
        map["productId"] = push
        map["price"] = money
        map["description"] = descroiprion + ""
        map["date"] = date.time
        map["adminId"] = myId
        map["productName"] = name!!
        map["lastPrice"] = lastMoney
        map["tradeMark"] = trademark!!
        map["parentCategoryId"] = ParentId!!
        map["childCategoryId"] = ChildId!!
        map["parentCategoryName"] = ParentName!!
        map["childCategoryName"] = ChildName!!
        map["keywords"] = keywords + ""
        map["TotalRating"] = 0
        map["discount"] = discount
        reference.child(PRODUCT).child(Objects.requireNonNull(push)).updateChildren(map)
        uploadImages(push)
    }

    fun uploadImages(id: String) {
        reference.child(PRODUCT).child(id).child("Images").setValue(downloadUri.values.toString())
    }

}


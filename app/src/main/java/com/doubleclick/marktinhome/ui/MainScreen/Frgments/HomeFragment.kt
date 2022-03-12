package com.doubleclick.marktinhome.ui.MainScreen.Frgments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.doubleclick.OnItem
import com.doubleclick.OnProduct
import com.doubleclick.Tradmarkinterface
import com.doubleclick.ViewModel.AdvertisementViewModel
import com.doubleclick.ViewModel.ProductViewModel
import com.doubleclick.ViewModel.RecentSearchViewModel
import com.doubleclick.ViewModel.TradmarkViewModel
import com.doubleclick.marktinhome.Adapters.HomeAdapter
import com.doubleclick.marktinhome.BaseApplication
import com.doubleclick.marktinhome.BaseFragment
import com.doubleclick.marktinhome.Model.*
import com.doubleclick.marktinhome.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : BaseFragment(), OnItem, OnProduct, Tradmarkinterface {


    lateinit var MainRecyceler: RecyclerView
    private lateinit var productViewModel: ProductViewModel
    private lateinit var homeModels: ArrayList<HomeModel>
    lateinit var homeAdapter: HomeAdapter
    lateinit var advertisementViewModel: AdvertisementViewModel
    lateinit var trademarkViewModel: TradmarkViewModel
    lateinit var fab: ExtendedFloatingActionButton;
    lateinit var animationView: LottieAnimationView
    lateinit var recentSearchViewModel: RecentSearchViewModel

    var mAddAlarmFab: FloatingActionButton? = null
    var mAddPersonFab: FloatingActionButton? = null
    var addAlarmActionText: TextView? = null
    var addPersonActionText: TextView? = null
    var isAllFabsVisible: Boolean? = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment\
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        MainRecyceler = view.findViewById(R.id.MainRecyceler)
        animationView = view.findViewById(R.id.animationView);
        fab = view.findViewById(R.id.fab);
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        advertisementViewModel = ViewModelProvider(this)[AdvertisementViewModel::class.java];
        trademarkViewModel = ViewModelProvider(this)[TradmarkViewModel::class.java]
        recentSearchViewModel = ViewModelProvider(this)[RecentSearchViewModel::class.java]

        homeModels = ArrayList()
        productViewModel.getProduct().observe(
            viewLifecycleOwner,
            Observer { products: ArrayList<Product?>? ->
                if (products!!.size != 0) {
                    homeModels.add(HomeModel(products, HomeModel.Products, this))
                    homeAdapter = HomeAdapter(homeModels);
                    MainRecyceler.adapter = homeAdapter
                    animationView.visibility = View.GONE
                } else {
                    animationView.visibility = View.VISIBLE
                }

            });
        productViewModel.getTopDealsLiveData().observe(viewLifecycleOwner, Observer {
            homeModels.add(HomeModel(it, HomeModel.TopDeal, this, HomeModel.TopDeal))
        })

        productViewModel.parent.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {

                homeModels.add(0, HomeModel(it, HomeModel.TopCategory, this))
            }
        });

        advertisementViewModel.allAdv.observe(viewLifecycleOwner, Observer {
            homeModels.add(1, HomeModel(it, HomeModel.Advertisement))
        });

        trademarkViewModel.allMark.observe(viewLifecycleOwner, Observer {
            homeModels.add(HomeModel(it, HomeModel.Trademarks, this))
        });


        recentSearchViewModel.lastSearchListLiveDataOneTime.observe(viewLifecycleOwner, Observer {
            if (it.size != 0) {
                productViewModel.getLastSearches(it)
            }
        })

        productViewModel.lastSearchProductLiveData.observe(viewLifecycleOwner) {
            if (it.size != 0) {
                homeModels.add(HomeModel(HomeModel.RecentSearch, it, this))
            }
        }

        mAddAlarmFab = view.findViewById(R.id.add_alarm_fab);
        mAddPersonFab = view.findViewById(R.id.add_person_fab);

        // Also register the action name text, of all the
        // FABs. except parent FAB action name text
        addAlarmActionText = view.findViewById(R.id.add_alarm_action_text);
        addPersonActionText = view.findViewById(R.id.add_person_action_text);

        // Now set all the FABs and all the action name
        // texts as GONE
        mAddAlarmFab!!.visibility = View.GONE
        mAddPersonFab!!.visibility = View.GONE;
        addAlarmActionText!!.visibility = View.GONE;
        addPersonActionText!!.visibility = View.GONE;
        fab.shrink();

        fab.setOnClickListener {
            if (!isAllFabsVisible!!) {
                mAddAlarmFab!!.show();
                mAddPersonFab!!.show();
                addAlarmActionText!!.setVisibility(View.VISIBLE);
                addPersonActionText!!.setVisibility(View.VISIBLE);
                fab.extend();
                isAllFabsVisible = true;
            } else {
                mAddAlarmFab!!.hide();
                mAddPersonFab!!.hide();
                addAlarmActionText!!.setVisibility(View.GONE);
                addPersonActionText!!.setVisibility(View.GONE);
                fab.shrink();
                isAllFabsVisible = false;
            }
        }

        mAddPersonFab!!.setOnClickListener {
            Toast.makeText(
                context,
                "Person Added",
                Toast.LENGTH_SHORT
            ).show()
        }

        mAddAlarmFab!!.setOnClickListener {
            Toast.makeText(
                context,
                "Alarm Added",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view;
    }

    override fun onItem(parentCategory: ParentCategory?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToFilterParentFragment(
                parentCategory
            )
        )
    }

    override fun onItemLong(parentCategory: ParentCategory?) {}

    override fun onItemProduct(product: Product?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToProductFragment2(
                product
            )
        )
    }

    override fun AllTradmark(tradmark: ArrayList<Trademark?>?) {}

    override fun AllNameTradmark(names: List<String?>?) {}

    override fun OnItemTradmark(tradmark: Trademark?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToTrademarkFragment(
                tradmark
            )
        )
    }
}
package com.doubleclick.ViewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.doubleclick.CartInter;
import com.doubleclick.marktinhome.Model.Cart;
import com.doubleclick.marktinhome.Repository.CartRepository;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/2/2022
 */
public class CartViewModel extends ViewModel implements CartInter {

    MutableLiveData<ArrayList<Cart>> mutableLiveData = new MutableLiveData<>();
    MutableLiveData<ArrayList<Cart>> mutableLiveDataOrderSeller = new MutableLiveData<>();

    CartRepository cartRepository = new CartRepository(this);

    public CartViewModel() {
        cartRepository.getCart();
        cartRepository.getOrderSeller();
    }


    public LiveData<ArrayList<Cart>> CartLiveData() {
        return mutableLiveData;
    }

    public LiveData<ArrayList<Cart>> OrdersSellerLiveData() {
        return mutableLiveDataOrderSeller;
    }


    @Override
    public void getCart(ArrayList<Cart> cart) {
        mutableLiveData.setValue(cart);
    }

    @Override
    public void getOrderSeller(@Nullable ArrayList<Cart> cart) {
        mutableLiveDataOrderSeller.setValue(cart);
    }
}

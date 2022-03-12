package com.doubleclick.marktinhome.Repository;

import static com.doubleclick.marktinhome.BaseApplication.isNetworkConnected;
import static com.doubleclick.marktinhome.Model.Constantes.CART;

import android.util.Log;

import androidx.annotation.NonNull;

import com.doubleclick.CartInter;
import com.doubleclick.marktinhome.Model.Cart;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created By Eslam Ghazy on 3/2/2022
 */
public class CartRepository extends BaseRepository {

    ArrayList<Cart> carts = new ArrayList<>();
    CartInter cartinter;

    public CartRepository(CartInter cartinter) {
        this.cartinter = cartinter;
    }

    // for User Orders
    public void getCart() {
        reference.child(CART).get().addOnCompleteListener(task -> {
            try {
                if (isNetworkConnected()) {
                    if (task.getResult().exists()) {
                        if (task.isSuccessful()) {
                            DataSnapshot snapshot = task.getResult();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Cart cart = dataSnapshot.getValue(Cart.class);
                                if (cart.getBuyerId().equals(myId)) {
                                    carts.add(cart);
                                    cartinter.getCart(carts);
                                }
                            }
                        }
                    }
                } else {
                    ShowToast("No Internet Connection");
                }
            } catch (Exception e) {
                Log.e("ExceptionCart", e.getMessage());
            }
        });
    }


    // for Orders Seller
    public void getOrderSeller() {
        reference.child(CART).get().addOnCompleteListener(task -> {
            try {
                if (isNetworkConnected()) {
                    if (task.getResult().exists()) {
                        if (task.isSuccessful()) {
                            DataSnapshot snapshot = task.getResult();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Cart cart = dataSnapshot.getValue(Cart.class);
                                if (Objects.requireNonNull(cart).getSellerId().equals(myId)) {
                                    carts.add(cart);
                                    cartinter.getOrderSeller(carts);
                                }
                            }
                        }
                    }
                } else {
                    ShowToast("No Internet Connection");
                }
            } catch (Exception e) {
                Log.e("ExceptionCart", e.getMessage());
            }
        });
    }

}

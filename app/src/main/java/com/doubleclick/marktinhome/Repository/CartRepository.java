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

    public void getCart() {
        reference.child(CART).get().addOnCompleteListener(task -> {
            try {
                if (isNetworkConnected()) {
                    if (task.getResult().exists()) {
                        if (task.isComplete()) {
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
                }
            } catch (Exception e) {
                ShowToast("No Internet Connection");
                Log.e("Exception", e.getMessage());
            }
        });
    }


    public void getOrderSeller() {
        reference.child(CART).get().addOnCompleteListener(task -> {
            try {
                if (isNetworkConnected()) {
                    if (task.getResult().exists()) {
                        if (task.isComplete()) {
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
                }

            } catch (Exception e) {
                Log.e("Exception", e.getMessage());
                ShowToast("No Internet Connection");
            }
        });
    }

}

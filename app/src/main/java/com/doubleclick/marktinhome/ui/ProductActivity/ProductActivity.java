package com.doubleclick.marktinhome.ui.ProductActivity;

import static com.doubleclick.marktinhome.Model.Constantes.CART;
import static com.doubleclick.marktinhome.Model.Constantes.PRODUCT;
import static com.doubleclick.marktinhome.Model.Constantes.RATE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.doubleclick.ViewModel.RateViewModel;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.Model.Rate;
import com.doubleclick.marktinhome.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private ImageView imageProduct, plus, mins, share;
    private TextView productName, trarmark, price, lastPrice, description, TotalRating, tvRate1, tvRate2, tvRate3, tvRate4, tvRate5, quantity;
    private ProgressBar progressBar1, progressBar2, progressBar3, progressBar4, progressBar5;
    private RatingBar yourRate;
    private RateViewModel rateViewModel;
    private float r1, r2, r3, r4, r5;
    private Product product;
    private int q = 1;
    private String myId;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        myId = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        reference = FirebaseDatabase.getInstance().getReference();
        rateViewModel = new ViewModelProvider(this).get(RateViewModel.class);
        fab = findViewById(R.id.fab);
        imageProduct = findViewById(R.id.imageProduct);
        plus = findViewById(R.id.plus);
        mins = findViewById(R.id.mins);
        share = findViewById(R.id.share);
        TotalRating = findViewById(R.id.TotalRating);
        tvRate1 = findViewById(R.id.tvRate1);
        tvRate2 = findViewById(R.id.tvRate2);
        tvRate3 = findViewById(R.id.tvRate3);
        tvRate4 = findViewById(R.id.tvRate4);
        tvRate5 = findViewById(R.id.tvRate5);
        quantity = findViewById(R.id.quantity);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);
        progressBar5 = findViewById(R.id.progressBar5);
        yourRate = findViewById(R.id.yourRate);
        productName = findViewById(R.id.productName);
        trarmark = findViewById(R.id.trarmark);
        price = findViewById(R.id.price);
        lastPrice = findViewById(R.id.lastPrice);
        description = findViewById(R.id.description);
        product = (Product) getIntent().getSerializableExtra("Product");
        productName.setText(product.getProductName());
        trarmark.setText(product.getTradeMark());
        price.setText(product.getPrice());
        lastPrice.setText(product.getLastPrice());
        description.setText(product.getDescription());
        Glide.with(this).load(product.getImage()).into(imageProduct);
        rateViewModel.getMyRate(myId, product.getProductId());
        rateViewModel.getMyRateing().observe(this, new Observer<Rate>() {
            @Override
            public void onChanged(Rate rate) {
                if (rate != null) {
                    yourRate.setRating(Float.parseFloat(rate.getRate()));
                }
            }
        });
        rateViewModel.getAllRate(product.getProductId());
        rateViewModel.getAllRateing().observe(this, new Observer<ArrayList<Rate>>() {
            @Override
            public void onChanged(ArrayList<Rate> rates) {
                TotalRating.setText(rates.size() + "");
                HashMap<String, Object> map = new HashMap<>();
                map.put("TotalRating", rates.size());
                reference.child(PRODUCT).child(product.getProductId()).updateChildren(map);
                for (Rate rate : rates) {
                    if (0.0 < Float.parseFloat(rate.getRate()) && Float.parseFloat(rate.getRate()) >= 1.0) {
                        r1 += 1;
                        progressBar1.setProgress(((int) r1 / rates.size()) * 100);
                        tvRate1.setText(r1 + "");
                    }
                    if (1.0 < Float.parseFloat(rate.getRate()) && Float.parseFloat(rate.getRate()) >= 2.0) {
                        r2 += 1;
                        progressBar2.setProgress(((int) r2 / rates.size()) * 100);
                        tvRate2.setText(r2 + "");
                    }
                    if (2.0 < Float.parseFloat(rate.getRate()) && Float.parseFloat(rate.getRate()) >= 3.0) {
                        r3 += 1;
                        progressBar3.setProgress(((int) r3 / rates.size()) * 100);
                        tvRate3.setText(r3 + "");
                    }
                    if (3.0 < Float.parseFloat(rate.getRate()) && Float.parseFloat(rate.getRate()) >= 4.0) {
                        r4 += 1;
                        progressBar4.setProgress(((int) r4 / rates.size()) * 100);
                        tvRate4.setText(r4 + "");
                    }
                    if (4.0 < Float.parseFloat(rate.getRate()) && Float.parseFloat(rate.getRate()) >= 5.0) {
                        r5 += 1;
                        progressBar5.setProgress(((int) r5 / rates.size()) * 100);
                        tvRate5.setText(r5 + "");
                    }

                }

            }
        });
        fab.setOnClickListener(v -> {
            if (q != 0) {
                String pushId = myId + ":" + product.getProductId();
                HashMap<String, Object> map = new HashMap<>();
                map.put("ProductId", product.getProductId());
                map.put("BuyerId", myId);
                map.put("SellerId", product.getAdminId());
                map.put("TotalPrice", (q * Double.parseDouble(product.getPrice())) + "");
                map.put("Quantity", q + "");
                map.put("price", product.getPrice());
                map.put("image", product.getImage());
                reference.child(CART).child(pushId).updateChildren(map);
            } else {
                Toast.makeText(this, "you can't order less than one!", Toast.LENGTH_LONG).show();
            }

        });

        yourRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String push = myId + ":" + product.getProductId();
                if (rating > 0f) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("push", push);
                    map.put("rate", rating + "");
                    map.put("productId", product.getProductId());
                    map.put("myId", myId);
                    reference.child(RATE).child(push).updateChildren(map);
                }
                if (rating == 0f) {
                    reference.child(RATE).child(push).removeValue();
                }
            }
        });

        plus.setOnClickListener(v -> {
            q++;
            quantity.setText(q + "");
        });

        mins.setOnClickListener(v -> {
            if (quantity.getText().toString().equals("0")) {
                q = 1;
                quantity.setText(q + "");
                Toast.makeText(this, "you can't order less than one!", Toast.LENGTH_LONG).show();
                return;
            } else {
                q--;
                quantity.setText(q + "");
            }
        });

        share.setOnClickListener(v -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,"https://com.doubleclick.marktinhome/" +product.getProductId());
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent,null);
            startActivity(shareIntent);
        });

    }
}
package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.OnProduct;
import com.doubleclick.ViewHolder.ProductViewHolder;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/9/2022
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> products = new ArrayList<>();
    private OnProduct onProduct;

    public ProductAdapter(ArrayList<Product> products, OnProduct onProductItemListener) {
        this.products = products;
        this.onProduct = onProductItemListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productName.setText(products.get(position).getProductName());
        holder.description.setText(products.get(position).getDescription());
        holder.productPrice.setText(products.get(position).getPrice());
        holder.productLastPrice.setText(products.get(position).getLastPrice());
        holder.trademark.setText(products.get(position).getTradeMark());
        Glide.with(holder.itemView.getContext()).load(products.get(position).getImage()).into(holder.imageProduct);
        holder.itemView.setOnClickListener(v -> {
            onProduct.onItemProduct(products.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageProduct;
        public TextView productName;
        public TextView description;
        public TextView productPrice;
        public TextView productLastPrice;
        public TextView trademark;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.imageProduct);
            productName = itemView.findViewById(R.id.productName);
            description = itemView.findViewById(R.id.description);
            productPrice = itemView.findViewById(R.id.productPrice);
            productLastPrice = itemView.findViewById(R.id.productLastPrice);
            trademark = itemView.findViewById(R.id.trademark);
        }
    }
}

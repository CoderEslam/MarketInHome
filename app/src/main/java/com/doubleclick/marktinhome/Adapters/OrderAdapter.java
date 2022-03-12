package com.doubleclick.marktinhome.Adapters;

import static com.doubleclick.marktinhome.Model.Constantes.CART;
import static com.doubleclick.marktinhome.Model.Constantes.RECENTORDER;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doubleclick.OnOrder;
import com.doubleclick.marktinhome.Model.Cart;
import com.doubleclick.marktinhome.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/7/2022
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<Cart> carts = new ArrayList<>();
    private OnOrder onOrder;

    public OrderAdapter(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    public OrderAdapter(ArrayList<Cart> carts, OnOrder onOrder) {
        this.carts = carts;
        this.onOrder = onOrder;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.orders, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.nameOrder.setText(carts.get(holder.getAdapterPosition()).getProductName());
        holder.PriceOrder.setText(String.format("%s", carts.get(holder.getAdapterPosition()).getPrice()));
        holder.quantityOrder.setText(String.format("%s", carts.get(holder.getAdapterPosition()).getQuantity()));
        holder.totalPrice.setText(String.format("%s", carts.get(holder.getAdapterPosition()).getTotalPrice()));
        Glide.with(holder.itemView.getContext()).load(carts.get(holder.getAdapterPosition()).getImage()).into(holder.orderImage);
        holder.ok.setOnClickListener(v -> {
            onOrder.OnOKItemOrder(carts.get(holder.getAdapterPosition()));
            holder.itemView.setVisibility(View.GONE);
            notifyItemRemoved(holder.getAdapterPosition());
        });

        holder.cancel.setOnClickListener(v -> {
            onOrder.OnCancelItemOrder(carts.get(holder.getAdapterPosition()));
            holder.itemView.setVisibility(View.GONE);
            notifyItemRemoved(holder.getAdapterPosition());
        });

    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        private ImageView orderImage;
        private TextView nameOrder, PriceOrder, cancel, ok, quantityOrder, totalPrice;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOrder = itemView.findViewById(R.id.nameOrder);
            orderImage = itemView.findViewById(R.id.orderImage);
            PriceOrder = itemView.findViewById(R.id.PriceOrder);
            quantityOrder = itemView.findViewById(R.id.quantityOrder);
            totalPrice = itemView.findViewById(R.id.totalPrice);
            cancel = itemView.findViewById(R.id.cancel);
            ok = itemView.findViewById(R.id.ok);
        }

    }
}

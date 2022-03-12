package com.doubleclick.marktinhome.Adapters;

import static com.doubleclick.marktinhome.Model.Constantes.CART;

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

    public OrderAdapter(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.orders, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.nameOrder.setText(carts.get(holder.getAdapterPosition()).getProductName());
        holder.PriceOrder.setText(carts.get(holder.getAdapterPosition()).getPrice());
        holder.quantityOrder.setText(carts.get(holder.getAdapterPosition()).getQuantity());
        holder.totalPrice.setText(carts.get(holder.getAdapterPosition()).getTotalPrice());
        Glide.with(holder.itemView.getContext()).load(carts.get(holder.getAdapterPosition()).getImage()).into(holder.orderImage);
        holder.ok.setOnClickListener(v -> {

//            FirebaseDatabase.getInstance().getReference().child(CART).child(carts.get(holder.getAdapterPosition()).getId())

        });

        holder.cancel.setOnClickListener(v -> {
            FirebaseDatabase.getInstance().getReference().child(CART).child(carts.get(holder.getAdapterPosition()).getId()).removeValue(new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                    Toast.makeText(holder.itemView.getContext(), "Deleted", Toast.LENGTH_LONG).show();
                }
            });
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

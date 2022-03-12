package com.doubleclick.marktinhome.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.doubleclick.marktinhome.Model.Product;
import com.doubleclick.marktinhome.R;

import java.util.List;

/**
 * Created By Eslam Ghazy on 3/7/2022
 */
public class GridViewAdapter extends ArrayAdapter<Product> {

    public GridViewAdapter(@NonNull Context context, @NonNull List<Product> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview = convertView;
        if (listitemview == null) {
            // Layout Inflater inflates each item to be displayed in GridView.

            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.g_v_layout, parent, false);
        }
        Product product = getItem(position);
        ImageView imageProduct = listitemview.findViewById(R.id.imageProduct);
        TextView productName = listitemview.findViewById(R.id.productName);
        TextView description = listitemview.findViewById(R.id.description);
        TextView productPrice = listitemview.findViewById(R.id.productPrice);
        TextView productLastPrice = listitemview.findViewById(R.id.productLastPrice);
        TextView trademark = listitemview.findViewById(R.id.trademark);

        Glide.with(listitemview.getContext()).load(product.getImage()).into(imageProduct);
        productName.setText(product.getProductName());
        description.setText(product.getDescription());
        productPrice.setText(product.getPrice());
        productLastPrice.setText(product.getLastPrice());
        trademark.setText(product.getTradeMark());
        return listitemview;
    }
}

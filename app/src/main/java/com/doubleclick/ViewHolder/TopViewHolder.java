package com.doubleclick.ViewHolder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.OnItem;
import com.doubleclick.marktinhome.Adapters.TopCategory;
import com.doubleclick.marktinhome.Model.ParentCategory;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class TopViewHolder extends RecyclerView.ViewHolder {


    private RecyclerView topParents;

    public TopViewHolder(@NonNull View itemView) {
        super(itemView);
        topParents = itemView.findViewById(R.id.topParents);
    }

    public void setParent(ArrayList<ParentCategory> parentCategories, OnItem onItem) {
        TopCategory topCategory = new TopCategory(parentCategories, onItem);
        topParents.setAdapter(topCategory);
    }

}
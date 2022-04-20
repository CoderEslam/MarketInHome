package com.doubleclick.marktinhome.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselLayoutManager;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.doubleclick.marktinhome.Views.carousellayoutmanager.CenterScrollListener;

/**
 * Created By Eslam Ghazy on 4/20/2022
 */
public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupViewHolder> {


    @NonNull
    @Override
    public GroupsAdapter.GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group, parent, false));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public void onBindViewHolder(@NonNull GroupsAdapter.GroupViewHolder holder, int position) {

    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView images;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
            CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
            images.setLayoutManager(layoutManager);
            images.setHasFixedSize(true);
            images.addOnScrollListener(new CenterScrollListener());
            layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
            images.setAdapter(new ImagesGroupAdapter());

        }
    }
}

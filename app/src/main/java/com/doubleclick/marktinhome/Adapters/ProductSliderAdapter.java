package com.doubleclick.marktinhome.Adapters;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.doubleclick.marktinhome.Model.Advertisement;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/15/2022
 */
public class ProductSliderAdapter extends PagerAdapter {

    private List<String> list = new ArrayList<>();

    public ProductSliderAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slider_image_layout, container, false);
        ConstraintLayout bannerContiner = view.findViewById(R.id.BannerContiner);
        ImageView banner = view.findViewById(R.id.banner_sliderImageView);
        Log.e("Imagedddd", list.get(position));
        Glide.with(container.getContext()).load(list.get(position).toString()).into(banner);
        container.addView(view, 0);
        return view;
    }
}

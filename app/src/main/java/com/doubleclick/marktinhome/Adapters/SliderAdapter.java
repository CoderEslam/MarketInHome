package com.doubleclick.marktinhome.Adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.doubleclick.marktinhome.Model.Advertisement;
import com.doubleclick.marktinhome.R;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private ArrayList<Advertisement> advertisements = new ArrayList<>();

    public SliderAdapter(ArrayList<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public int getCount() {
        return advertisements.size();
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
        Glide.with(view).load(advertisements.get(position).getImage()).into(banner);
//        Picasso.get().load(sliderModelList.get(position).getImageAd()).placeholder(R.drawable.parson).into(banner);
        container.addView(view, 0);
        return view;
    }
}

package com.doubleclick.marktinhome.ui.ProductActivity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J&\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0010\u0010f\u001a\u00020]2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u000e\u0010!\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001a\u0010C\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R\u001a\u0010F\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?R\u001a\u0010I\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010=\"\u0004\bK\u0010?R\u000e\u0010L\u001a\u00020MX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u00107\"\u0004\bP\u00109R\u001a\u0010Q\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0015\"\u0004\bS\u0010\u0017R\u000e\u0010T\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"}, d2 = {"Lcom/doubleclick/marktinhome/ui/ProductActivity/productFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "()V", "ToggleItem", "", "TotalRating", "Landroid/widget/TextView;", "addToggalsLinearLayout", "Landroid/widget/LinearLayout;", "banner_slier_view_pager", "Landroidx/viewpager/widget/ViewPager;", "description", "fab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "lastPrice", "list", "", "Llecho/lib/hellocharts/model/SliceValue;", "mins", "Landroid/widget/ImageView;", "getMins", "()Landroid/widget/ImageView;", "setMins", "(Landroid/widget/ImageView;)V", "pieChartView", "Llecho/lib/hellocharts/view/PieChartView;", "getPieChartView", "()Llecho/lib/hellocharts/view/PieChartView;", "setPieChartView", "(Llecho/lib/hellocharts/view/PieChartView;)V", "plus", "getPlus", "setPlus", "price", "product", "Lcom/doubleclick/marktinhome/ui/ProductActivity/productFragmentArgs;", "getProduct", "()Lcom/doubleclick/marktinhome/ui/ProductActivity/productFragmentArgs;", "product$delegate", "Landroidx/navigation/NavArgsLazy;", "productName", "progressBar1", "Landroid/widget/ProgressBar;", "progressBar2", "progressBar3", "progressBar4", "progressBar5", "q", "", "getQ", "()I", "setQ", "(I)V", "quantity", "getQuantity", "()Landroid/widget/TextView;", "setQuantity", "(Landroid/widget/TextView;)V", "r1", "", "getR1", "()F", "setR1", "(F)V", "r2", "getR2", "setR2", "r3", "getR3", "setR3", "r4", "getR4", "setR4", "r5", "getR5", "setR5", "rateViewModel", "Lcom/doubleclick/ViewModel/RateViewModel;", "ratingSeller", "getRatingSeller", "setRatingSeller", "share", "getShare", "setShare", "trarmark", "tvRate1", "tvRate2", "tvRate3", "tvRate4", "tvRate5", "yourRate", "Landroid/widget/RatingBar;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setBannerSliderViewPager", "app_debug"})
public final class productFragment extends com.doubleclick.marktinhome.BaseFragment {
    private com.google.android.material.floatingactionbutton.FloatingActionButton fab;
    private androidx.viewpager.widget.ViewPager banner_slier_view_pager;
    private android.widget.TextView productName;
    private android.widget.TextView trarmark;
    private android.widget.TextView price;
    private android.widget.TextView lastPrice;
    private android.widget.TextView description;
    private android.widget.TextView TotalRating;
    private android.widget.TextView tvRate1;
    private android.widget.TextView tvRate2;
    private android.widget.TextView tvRate3;
    private android.widget.TextView tvRate4;
    private android.widget.TextView tvRate5;
    private android.widget.ProgressBar progressBar1;
    private android.widget.ProgressBar progressBar2;
    private android.widget.ProgressBar progressBar3;
    private android.widget.ProgressBar progressBar4;
    private android.widget.ProgressBar progressBar5;
    private android.widget.RatingBar yourRate;
    private com.doubleclick.ViewModel.RateViewModel rateViewModel;
    private android.widget.LinearLayout addToggalsLinearLayout;
    private float r1 = 0.0F;
    private float r2 = 0.0F;
    private float r3 = 0.0F;
    private float r4 = 0.0F;
    private float r5 = 0.0F;
    public android.widget.ImageView plus;
    public android.widget.ImageView mins;
    public android.widget.TextView quantity;
    private int q = 0;
    public android.widget.ImageView share;
    public lecho.lib.hellocharts.view.PieChartView pieChartView;
    public android.widget.TextView ratingSeller;
    private java.util.List<lecho.lib.hellocharts.model.SliceValue> list;
    private java.lang.String ToggleItem = "";
    private final androidx.navigation.NavArgsLazy product$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public productFragment() {
        super();
    }
    
    public final float getR1() {
        return 0.0F;
    }
    
    public final void setR1(float p0) {
    }
    
    public final float getR2() {
        return 0.0F;
    }
    
    public final void setR2(float p0) {
    }
    
    public final float getR3() {
        return 0.0F;
    }
    
    public final void setR3(float p0) {
    }
    
    public final float getR4() {
        return 0.0F;
    }
    
    public final void setR4(float p0) {
    }
    
    public final float getR5() {
        return 0.0F;
    }
    
    public final void setR5(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getPlus() {
        return null;
    }
    
    public final void setPlus(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getMins() {
        return null;
    }
    
    public final void setMins(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getQuantity() {
        return null;
    }
    
    public final void setQuantity(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    public final int getQ() {
        return 0;
    }
    
    public final void setQ(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getShare() {
        return null;
    }
    
    public final void setShare(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final lecho.lib.hellocharts.view.PieChartView getPieChartView() {
        return null;
    }
    
    public final void setPieChartView(@org.jetbrains.annotations.NotNull()
    lecho.lib.hellocharts.view.PieChartView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getRatingSeller() {
        return null;
    }
    
    public final void setRatingSeller(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    private final com.doubleclick.marktinhome.ui.ProductActivity.productFragmentArgs getProduct() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void setBannerSliderViewPager(@org.jetbrains.annotations.Nullable()
    java.lang.String list) {
    }
}
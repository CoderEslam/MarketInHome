package com.doubleclick.marktinhome.ui.ProductActivity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020XJ\u0012\u0010Z\u001a\u00020X2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J&\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u000e\u0010c\u001a\u00020X2\u0006\u0010d\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010,\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u000e\u0010/\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u000e\u00106\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\u001a\u0010@\u001a\u00020AX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0013\"\u0004\bJ\u0010\u0015R\u001a\u0010K\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001d\"\u0004\bM\u0010\u001fR\u000e\u0010N\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020VX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Lcom/doubleclick/marktinhome/ui/ProductActivity/productFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "()V", "ToggleItem", "", "TotalRating", "Landroid/widget/TextView;", "addToggalsLinearLayout", "Landroid/widget/LinearLayout;", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setAnimationView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "banner_slier_view_pager", "Landroidx/viewpager/widget/ViewPager;", "comments", "getComments", "()Landroid/widget/TextView;", "setComments", "(Landroid/widget/TextView;)V", "description", "fab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "lastPrice", "mins", "Landroid/widget/ImageView;", "getMins", "()Landroid/widget/ImageView;", "setMins", "(Landroid/widget/ImageView;)V", "minsone", "getMinsone", "setMinsone", "pieChartView", "Llecho/lib/hellocharts/view/PieChartView;", "getPieChartView", "()Llecho/lib/hellocharts/view/PieChartView;", "setPieChartView", "(Llecho/lib/hellocharts/view/PieChartView;)V", "plus", "getPlus", "setPlus", "plusone", "getPlusone", "setPlusone", "price", "product", "Lcom/doubleclick/marktinhome/ui/ProductActivity/productFragmentArgs;", "getProduct", "()Lcom/doubleclick/marktinhome/ui/ProductActivity/productFragmentArgs;", "product$delegate", "Landroidx/navigation/NavArgsLazy;", "productName", "qNumber", "", "getQNumber", "()I", "setQNumber", "(I)V", "quantity", "getQuantity", "setQuantity", "radioGroup", "Landroid/widget/RadioGroup;", "getRadioGroup", "()Landroid/widget/RadioGroup;", "setRadioGroup", "(Landroid/widget/RadioGroup;)V", "rateViewModel", "Lcom/doubleclick/ViewModel/RateViewModel;", "ratingSeller", "getRatingSeller", "setRatingSeller", "share", "getShare", "setShare", "trarmark", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "yourRate", "Landroid/widget/RatingBar;", "FinishAnimationView", "", "ShareProduct", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setBannerSliderViewPager", "list", "app_debug"})
public final class productFragment extends com.doubleclick.marktinhome.BaseFragment {
    private com.google.android.material.floatingactionbutton.FloatingActionButton fab;
    private androidx.viewpager.widget.ViewPager banner_slier_view_pager;
    private android.widget.TextView productName;
    private android.widget.TextView trarmark;
    private android.widget.TextView price;
    private android.widget.TextView lastPrice;
    private android.widget.TextView description;
    private android.widget.TextView TotalRating;
    private android.widget.RatingBar yourRate;
    private com.doubleclick.ViewModel.RateViewModel rateViewModel;
    private android.widget.LinearLayout addToggalsLinearLayout;
    public android.widget.ImageView plus;
    public android.widget.ImageView mins;
    public android.widget.TextView quantity;
    private int qNumber = 0;
    public android.widget.ImageView share;
    public lecho.lib.hellocharts.view.PieChartView pieChartView;
    public android.widget.TextView ratingSeller;
    private java.lang.String ToggleItem = "";
    public android.widget.TextView comments;
    public android.widget.RadioGroup radioGroup;
    public com.airbnb.lottie.LottieAnimationView animationView;
    public android.webkit.WebView webView;
    public android.widget.ImageView minsone;
    public android.widget.ImageView plusone;
    private final androidx.navigation.NavArgsLazy product$delegate = null;
    
    public productFragment() {
        super();
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
    
    public final int getQNumber() {
        return 0;
    }
    
    public final void setQNumber(int p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getComments() {
        return null;
    }
    
    public final void setComments(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RadioGroup getRadioGroup() {
        return null;
    }
    
    public final void setRadioGroup(@org.jetbrains.annotations.NotNull()
    android.widget.RadioGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.airbnb.lottie.LottieAnimationView getAnimationView() {
        return null;
    }
    
    public final void setAnimationView(@org.jetbrains.annotations.NotNull()
    com.airbnb.lottie.LottieAnimationView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.webkit.WebView getWebView() {
        return null;
    }
    
    public final void setWebView(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getMinsone() {
        return null;
    }
    
    public final void setMinsone(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getPlusone() {
        return null;
    }
    
    public final void setPlusone(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
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
    
    public final void setBannerSliderViewPager(@org.jetbrains.annotations.NotNull()
    java.lang.String list) {
    }
    
    public final void ShareProduct() {
    }
    
    public final void FinishAnimationView() {
    }
}
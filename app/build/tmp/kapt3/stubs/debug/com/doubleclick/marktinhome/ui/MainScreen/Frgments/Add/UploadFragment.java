package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/UploadFragment;", "Lcom/doubleclick/marktinhome/BaseFragment;", "()V", "Upload", "Landroid/widget/Button;", "baseFragment", "description", "Landroid/widget/EditText;", "keywords", "getKeywords", "()Landroid/widget/EditText;", "setKeywords", "(Landroid/widget/EditText;)V", "marke", "", "getMarke", "()Ljava/lang/String;", "setMarke", "(Ljava/lang/String;)V", "parent_child", "Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/UploadFragmentArgs;", "getParent_child", "()Lcom/doubleclick/marktinhome/ui/MainScreen/Frgments/Add/UploadFragmentArgs;", "parent_child$delegate", "Landroidx/navigation/NavArgsLazy;", "productImage", "Landroid/widget/ImageView;", "productLastPrice", "productName", "productPrice", "trademark", "Landroidx/appcompat/widget/AppCompatSpinner;", "tradmarkViewModel", "Lcom/doubleclick/ViewModel/TradmarkViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "app_debug"})
public final class UploadFragment extends com.doubleclick.marktinhome.BaseFragment {
    public java.lang.String marke;
    private android.widget.ImageView productImage;
    private android.widget.EditText productName;
    private android.widget.EditText productPrice;
    private android.widget.EditText productLastPrice;
    private android.widget.EditText description;
    public android.widget.EditText keywords;
    private androidx.appcompat.widget.AppCompatSpinner trademark;
    private android.widget.Button Upload;
    private com.doubleclick.marktinhome.BaseFragment baseFragment;
    private com.doubleclick.ViewModel.TradmarkViewModel tradmarkViewModel;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy parent_child$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public UploadFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMarke() {
        return null;
    }
    
    public final void setMarke(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getKeywords() {
        return null;
    }
    
    public final void setKeywords(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add.UploadFragmentArgs getParent_child() {
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
    
    @java.lang.Override()
    public void onStart() {
    }
}
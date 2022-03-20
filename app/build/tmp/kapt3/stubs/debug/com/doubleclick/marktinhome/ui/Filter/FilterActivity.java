package com.doubleclick.marktinhome.ui.Filter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/doubleclick/marktinhome/ui/Filter/FilterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/doubleclick/OnProduct;", "()V", "FilterRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getFilterRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setFilterRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "productViewModel", "Lcom/doubleclick/ViewModel/ProductViewModel;", "getProductViewModel", "()Lcom/doubleclick/ViewModel/ProductViewModel;", "setProductViewModel", "(Lcom/doubleclick/ViewModel/ProductViewModel;)V", "type", "getType", "setType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemProduct", "p", "Lcom/doubleclick/marktinhome/Model/Product;", "app_debug"})
public final class FilterActivity extends androidx.appcompat.app.AppCompatActivity implements com.doubleclick.OnProduct {
    public androidx.recyclerview.widget.RecyclerView FilterRecycler;
    public com.doubleclick.ViewModel.ProductViewModel productViewModel;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type = "";
    
    public FilterActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getFilterRecycler() {
        return null;
    }
    
    public final void setFilterRecycler(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.doubleclick.ViewModel.ProductViewModel getProductViewModel() {
        return null;
    }
    
    public final void setProductViewModel(@org.jetbrains.annotations.NotNull()
    com.doubleclick.ViewModel.ProductViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onItemProduct(@org.jetbrains.annotations.Nullable()
    com.doubleclick.marktinhome.Model.Product p) {
    }
}
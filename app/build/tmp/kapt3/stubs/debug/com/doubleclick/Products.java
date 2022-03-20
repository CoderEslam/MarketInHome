package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 3/3/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006H&J(\u0010\u0007\u001a\u00020\u00032\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006H&J(\u0010\b\u001a\u00020\u00032\u001e\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\u0006H&J(\u0010\n\u001a\u00020\u00032\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\u0006H&J \u0010\r\u001a\u00020\u00032\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0004j\b\u0012\u0004\u0012\u00020\u000f`\u0006H&J(\u0010\u0010\u001a\u00020\u00032\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&J(\u0010\u0011\u001a\u00020\u00032\u001e\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&J(\u0010\u0013\u001a\u00020\u00032\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&J(\u0010\u0015\u001a\u00020\u00032\u001e\u0010\u0016\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&J(\u0010\u0017\u001a\u00020\u00032\u001e\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&J(\u0010\u0019\u001a\u00020\u00032\u001e\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&J(\u0010\u001a\u001a\u00020\u00032\u001e\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006H&Jl\u0010\u001b\u001a\u00020\u00032b\u0010\u000e\u001a^\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004\u0018\u00010\u0004\u0018\u00010\u0004j@\u0012:\u00128\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004\u0018\u00010\u0004j\"\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u0001`\u0006\u0018\u0001`\u0006\u0018\u0001`\u0006H&\u00a8\u0006\u001c"}, d2 = {"Lcom/doubleclick/Products;", "", "Childproduct", "", "Ljava/util/ArrayList;", "Lcom/doubleclick/marktinhome/Model/ChildCategory;", "Lkotlin/collections/ArrayList;", "Childrenproduct", "Parentproduct", "Lcom/doubleclick/marktinhome/Model/ParentCategory;", "getClassificationPC", "Product", "Lcom/doubleclick/marktinhome/Model/ClassificationPC;", "getClassificationProductByParent", "products", "Lcom/doubleclick/marktinhome/Model/Product;", "getProduct", "getProductById", "productById", "getProductTopDeals", "topDeals", "getProductWithTrademark", "productWithTrademark", "getQueryByChild", "QueryProducts", "getQueryByParents", "getQueryProducts", "product", "app_debug"})
public abstract interface Products {
    
    public abstract void product(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<java.util.ArrayList<java.util.ArrayList<com.doubleclick.marktinhome.Model.Product>>> products);
    
    public abstract void Parentproduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ParentCategory> Parentproduct);
    
    public abstract void Childproduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ChildCategory> Childproduct);
    
    public abstract void Childrenproduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ChildCategory> Childproduct);
    
    public abstract void getProduct(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> Product);
    
    public abstract void getQueryProducts(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> QueryProducts);
    
    public abstract void getQueryByParents(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> QueryProducts);
    
    public abstract void getQueryByChild(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> QueryProducts);
    
    public abstract void getProductWithTrademark(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> productWithTrademark);
    
    public abstract void getProductTopDeals(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> topDeals);
    
    public abstract void getProductById(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> productById);
    
    public abstract void getClassificationPC(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.ClassificationPC> Product);
    
    public abstract void getClassificationProductByParent(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.doubleclick.marktinhome.Model.Product> products);
}
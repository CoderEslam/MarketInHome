package com.doubleclick.marktinhome.Model;

import com.doubleclick.OnItem;
import com.doubleclick.OnProduct;
import com.doubleclick.Tradmarkinterface;

import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/8/2022
 */
public class HomeModel {

    public static final int TopCategory = 0;
    public static final int Advertisement = 1;
    public static final int TopDeal = 2;
    public static final int Products = 3;
    public static final int Trademarks = 4;
    public static final int RecentSearch = 5;
    private ArrayList<ParentCategory> parentCategories;
    private ArrayList<Advertisement> advertisements;
    private ArrayList<Product> productsTopDaels;

    public ArrayList<Product> getProductsRecentSearch() {
        return productsRecentSearch;
    }

    public void setProductsRecentSearch(ArrayList<Product> productsRecentSearch) {
        this.productsRecentSearch = productsRecentSearch;
    }

    private ArrayList<Product> productsRecentSearch;

    public HomeModel(ArrayList<Product> productsTopDaels, int type, OnProduct onProduct, int fake) {
        this.productsTopDaels = productsTopDaels;
        this.type = type;
        this.onProduct = onProduct;
    }

    public HomeModel(int type, ArrayList<Product> productsRecentSearch, OnProduct onProduct) {
        this.productsRecentSearch = productsRecentSearch;
        this.type = type;
        this.onProduct = onProduct;
    }

    public Tradmarkinterface getTradmarkinterface() {
        return tradmarkinterface;
    }

    public void setTradmarkinterface(Tradmarkinterface tradmarkinterface) {
        this.tradmarkinterface = tradmarkinterface;
    }

    private Tradmarkinterface tradmarkinterface;

    public HomeModel(ArrayList<Trademark> trademarks, int type, Tradmarkinterface tradmarkinterface) {
        this.trademarkArrayList = trademarks;
        this.type = type;
        this.tradmarkinterface = tradmarkinterface;
    }


    public ArrayList<Trademark> getTrademarkArrayList() {
        return trademarkArrayList;
    }

    public void setTrademarkArrayList(ArrayList<Trademark> trademarkArrayList) {
        this.trademarkArrayList = trademarkArrayList;
    }

    private ArrayList<Trademark> trademarkArrayList;

    public HomeModel(ArrayList<com.doubleclick.marktinhome.Model.Advertisement> advertisements, int type) {
        this.advertisements = advertisements;
        this.type = type;
    }

    public OnItem getOnItemPerantTop() {
        return onItemPerantTop;
    }

    public void setOnItemPerantTop(OnItem onItemPerantTop) {
        this.onItemPerantTop = onItemPerantTop;
    }

    public OnProduct getOnProduct() {
        return onProduct;
    }

    public void setOnProduct(OnProduct onProduct) {
        this.onProduct = onProduct;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    private ArrayList<Product> productArrayList;

    private int type;
    private OnItem onItemPerantTop;
    private OnProduct onProduct;


    public HomeModel(ArrayList<ParentCategory> parentCategories, int type, OnItem onItemPerantTop) {
        this.parentCategories = parentCategories;
        this.type = type;
        this.onItemPerantTop = onItemPerantTop;
    }

    public HomeModel(ArrayList<Product> products, int type, OnProduct onProduct) {
        this.productArrayList = products;
        this.type = type;
        this.onProduct = onProduct;
    }

    public static int getTopCategory() {
        return TopCategory;
    }

    public ArrayList<ParentCategory> getParentCategories() {
        return parentCategories;
    }

    public void setParentCategories(ArrayList<ParentCategory> parentCategories) {
        this.parentCategories = parentCategories;
    }

    public static int getAdvertisement() {
        return Advertisement;
    }

    public ArrayList<com.doubleclick.marktinhome.Model.Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(ArrayList<com.doubleclick.marktinhome.Model.Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public static int getTopDeal() {
        return TopDeal;
    }

    public ArrayList<Product> getProductsTopDaels() {
        return productsTopDaels;
    }

    public void setProductsTopDaels(ArrayList<Product> productsTopDaels) {
        this.productsTopDaels = productsTopDaels;
    }


    public static int getTrademarks() {
        return Trademarks;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

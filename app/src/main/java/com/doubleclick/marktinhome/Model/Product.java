package com.doubleclick.marktinhome.Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created By Eslam Ghazy on 3/1/2022
 */
public class Product implements Serializable, Comparable {

    private String productId;
    private double price;
    private String description;
    private long date;
    private String adminId;
    private String productName;
    private double lastPrice;
    private String tradeMark;
    private String parentCategoryName;
    private String childCategoryName;
    private String parentCategoryId;
    private String childCategoryId;
    private int TotalRating;
    private int discount;
    private String keywords;
    private String Images;
    private String Toggals;

    public Product(double price, String productName, String images, String toggals) {
        this.price = price;
        this.description = description;
        this.productName = productName;
        this.lastPrice = lastPrice;
        this.tradeMark = tradeMark;
        Images = images;
        Toggals = toggals;
    }


    public String getToggals() {
        return Toggals;
    }

    public void setToggals(String toggals) {
        Toggals = toggals;
    }



    public float getRatingSeller() {
        return ratingSeller;
    }

    public void setRatingSeller(float ratingSeller) {
        this.ratingSeller = ratingSeller;
    }

    private float ratingSeller;

    public String getImages() {
        return Images;
    }

    public String getOnlyImage(){
        List<String> image = Arrays.asList(getImages().replace("[", "").replace("]", "").replace(" ", "").trim().split(","));
        return image.get(0);
    }

    public void setImages(String images) {
        Images = images;
    }


    public Product() {
    }


    @Override
    public int compareTo(Object o) {
        int rate = ((Product) o).getTotalRating();
        return (this.TotalRating - rate);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public String getChildCategoryName() {
        return childCategoryName;
    }

    public void setChildCategoryName(String childCategoryName) {
        this.childCategoryName = childCategoryName;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getChildCategoryId() {
        return childCategoryId;
    }

    public void setChildCategoryId(String childCategoryId) {
        this.childCategoryId = childCategoryId;
    }


    public int getTotalRating() {
        return TotalRating;
    }

    public void setTotalRating(int totalRating) {
        TotalRating = totalRating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", adminId='" + adminId + '\'' +
                ", productName='" + productName + '\'' +
                ", lastPrice=" + lastPrice +
                ", tradeMark='" + tradeMark + '\'' +
                ", parentCategoryName='" + parentCategoryName + '\'' +
                ", childCategoryName='" + childCategoryName + '\'' +
                ", parentCategoryId='" + parentCategoryId + '\'' +
                ", childCategoryId='" + childCategoryId + '\'' +
                ", Images='" + Images + '\'' +
                ", TotalRating=" + TotalRating +
                ", discount=" + discount +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}

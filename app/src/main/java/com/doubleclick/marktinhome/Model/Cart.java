package com.doubleclick.marktinhome.Model;

/**
 * Created By Eslam Ghazy on 3/1/2022
 */
public class Cart {

    private String ProductId;
    private String price;
    private String Quantity;
    private String lastPrice;
    private String productName;
    private String image;
    private String id;
    private String BuyerId;
    private String SellerId;
    private String TotalPrice;

    public String getSellerId() {
        return SellerId;
    }

    public void setSellerId(String sellerId) {
        SellerId = sellerId;
    }


    public String getBuyerId() {
        return BuyerId;
    }

    public void setBuyerId(String buyerId) {
        BuyerId = buyerId;
    }


    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        TotalPrice = totalPrice;
    }
}

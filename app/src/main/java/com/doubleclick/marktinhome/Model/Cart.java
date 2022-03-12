package com.doubleclick.marktinhome.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created By Eslam Ghazy on 3/1/2022
 */
public class Cart implements Parcelable {

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

    protected Cart(Parcel in) {
        ProductId = in.readString();
        price = in.readString();
        Quantity = in.readString();
        lastPrice = in.readString();
        productName = in.readString();
        image = in.readString();
        id = in.readString();
        BuyerId = in.readString();
        SellerId = in.readString();
        TotalPrice = in.readString();
    }

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    public Cart() {
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ProductId);
        dest.writeString(price);
        dest.writeString(Quantity);
        dest.writeString(lastPrice);
        dest.writeString(productName);
        dest.writeString(image);
        dest.writeString(id);
        dest.writeString(BuyerId);
        dest.writeString(SellerId);
        dest.writeString(TotalPrice);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "ProductId='" + ProductId + '\'' +
                ", price='" + price + '\'' +
                ", Quantity='" + Quantity + '\'' +
                ", lastPrice='" + lastPrice + '\'' +
                ", productName='" + productName + '\'' +
                ", image='" + image + '\'' +
                ", id='" + id + '\'' +
                ", BuyerId='" + BuyerId + '\'' +
                ", SellerId='" + SellerId + '\'' +
                ", TotalPrice='" + TotalPrice + '\'' +
                '}';
    }
}

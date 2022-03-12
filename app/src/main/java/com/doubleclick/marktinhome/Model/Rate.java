package com.doubleclick.marktinhome.Model;

/**
 * Created By Eslam Ghazy on 3/6/2022
 */
public class Rate {


    private String myId;
    private String productId;
    private String push;
    private String rate;


    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPush() {
        return push;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "myId='" + myId + '\'' +
                ", productId='" + productId + '\'' +
                ", push='" + push + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}

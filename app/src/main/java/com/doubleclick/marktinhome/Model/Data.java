package com.doubleclick.marktinhome.Model;

public class Data {

    private String user;
    private int icon;
    private String body;
    private String title;
    private String sent;
    private String image;

    public Data(String user, int icon, String body, String title, String sent) {
        this.user = user;
        this.icon = icon;
        this.body = body;
        this.title = title;
        this.sent = sent;
    }

    public Data() {
    }

    public Data(String user, String body, String title, String sent, String image) {
        this.user = user;
        this.body = body;
        this.title = title;
        this.sent = sent;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

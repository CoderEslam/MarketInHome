package com.doubleclick.marktinhome.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created By Eslam Ghazy on 3/6/2022
 */
public class ClassificationPC implements Serializable {


    public ClassificationPC(ArrayList<ChildCategory> childCategory, String name, String image, boolean isExpendable, String PushId) {
        this.childCategory = childCategory;
        this.name = name;
        this.image = image;
        this.isExpendable = isExpendable;
        this.ParentPushId = PushId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildCategory> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(ArrayList<ChildCategory> childCategory) {
        this.childCategory = childCategory;
    }

    private ArrayList<ChildCategory> childCategory;
    private String name;

    public String getParentPushId() {
        return ParentPushId;
    }

    public void setParentPushId(String parentPushId) {
        ParentPushId = parentPushId;
    }

    private String ParentPushId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public boolean isExpendable() {
        return isExpendable;
    }

    public void setExpendable(boolean expendable) {
        isExpendable = expendable;
    }

    private boolean isExpendable;

    @Override
    public String toString() {
        return "ClassificationPC{" +
                "childCategory=" + childCategory +
                ", name='" + name + '\'' +
                '}';
    }
}

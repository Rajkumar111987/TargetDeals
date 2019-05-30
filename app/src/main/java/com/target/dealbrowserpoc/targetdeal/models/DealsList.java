package com.target.dealbrowserpoc.targetdeal.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DealsList implements Serializable{

    @SerializedName("index")
    public int index;

    @SerializedName("_id")
    public String id;

    @SerializedName("guid")
    public String guid;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("price")
    public String originalPrice;

    @SerializedName("salePrice")
    public String salePrice;

    @SerializedName("_image")
    public int _image;

    @SerializedName("image")
    public String image;

    @SerializedName("aisle")
    public String aisle;

    public DealsList(int index, String id, String title, String description, String originalPrice, String salePrice, int image, String aisle) {
        this.index = index;
        this.id = id;
        this.title = title;
        this.description = description;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this._image = image;
        this.aisle = aisle;
    }
}

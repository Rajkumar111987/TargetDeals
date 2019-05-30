package com.target.dealbrowserpoc.targetdeal.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DealsDetails implements Serializable {

    @SerializedName("data")
    public List<DealsList> data;
}

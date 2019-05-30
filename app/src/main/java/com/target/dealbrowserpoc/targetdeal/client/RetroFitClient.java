package com.target.dealbrowserpoc.targetdeal.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetroFitClient {

    private static Retrofit mRetrofit = null;

    private static final String BASE_URL = "https://target-deals.herokuapp.com/";

    public static Retrofit getRetrofit(){

        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return mRetrofit;


    }
}

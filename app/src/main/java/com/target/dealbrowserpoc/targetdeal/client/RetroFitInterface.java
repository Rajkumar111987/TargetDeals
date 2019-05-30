package com.target.dealbrowserpoc.targetdeal.client;

import com.target.dealbrowserpoc.targetdeal.models.DealsDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroFitInterface {

    @GET("api/deals")
    Call<DealsDetails> getDeals();
}

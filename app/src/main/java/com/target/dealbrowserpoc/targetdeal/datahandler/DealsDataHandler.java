package com.target.dealbrowserpoc.targetdeal.datahandler;

import android.support.annotation.NonNull;
import android.util.Log;

import com.target.dealbrowserpoc.targetdeal.client.RetroFitClient;
import com.target.dealbrowserpoc.targetdeal.client.RetroFitInterface;
import com.target.dealbrowserpoc.targetdeal.models.DealsDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealsDataHandler {

    private static final String TAG = DealsDataHandler.class.getSimpleName();

    private GetDealsListListener listener;

    public interface GetDealsListListener  {
        void onSuccess(DealsDetails response);

        void onError(int errorCode);
    }

    /**
     * Constructor for data handler.
     *
     * @param listener callback listener
     */
    public DealsDataHandler(
            @NonNull GetDealsListListener listener) {
        this.listener = listener;
    }

    public void getDealsList(){

        RetroFitInterface sevice = RetroFitClient.getRetrofit().create(RetroFitInterface.class);
        Call<DealsDetails> call = sevice.getDeals();

        call.enqueue(new Callback<DealsDetails>() {
            @Override
            public void onResponse(Call<DealsDetails> call, Response<DealsDetails> response) {
                Log.d(",","");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DealsDetails> call, Throwable t) {
                Log.d("","");
                listener.onError(1);

            }
        });

    }
}

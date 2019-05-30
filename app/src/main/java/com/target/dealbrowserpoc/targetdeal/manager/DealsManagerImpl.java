package com.target.dealbrowserpoc.targetdeal.manager;

import android.support.annotation.NonNull;

import com.target.dealbrowserpoc.targetdeal.datahandler.DealsDataHandler;
import com.target.dealbrowserpoc.targetdeal.models.DealsDetails;

public class DealsManagerImpl implements DealsManager {


    @Override
    public void getDealsList(@NonNull final GetDealsListener callback) {

        DealsDataHandler dataHandler = new DealsDataHandler(new DealsDataHandler.GetDealsListListener() {
            @Override
            public void onSuccess(DealsDetails response) {
                callback.onReceiveDeals(response);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        dataHandler.getDealsList();

    }
}

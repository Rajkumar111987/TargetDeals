package com.target.dealbrowserpoc.targetdeal.manager;

import android.support.annotation.NonNull;

import com.target.dealbrowserpoc.targetdeal.models.DealsDetails;

public interface DealsManager {

    /**
     * Callback for Get Notification.
     */
    interface GetDealsListener {
        void onReceiveDeals(DealsDetails dealsDetails);

        void onError(Throwable responseStatus);
    }

    /**
     * Get the Notification Preference.
     *
     * @param callback response callback
     */
    void getDealsList(@NonNull GetDealsListener callback);
}

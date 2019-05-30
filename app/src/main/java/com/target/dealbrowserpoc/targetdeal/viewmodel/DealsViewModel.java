package com.target.dealbrowserpoc.targetdeal.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.target.dealbrowserpoc.targetdeal.manager.DealsManager;
import com.target.dealbrowserpoc.targetdeal.manager.DealsManagerImpl;
import com.target.dealbrowserpoc.targetdeal.models.DealsDetails;

public class DealsViewModel extends AndroidViewModel {

    public DealsViewModel (Application application){ super(application);}

    private MutableLiveData<DealsDetails> mDeals;

    public LiveData<DealsDetails> getDealsDetails(){
        mDeals = new MutableLiveData<>();

        DealsManager manager = new DealsManagerImpl();
        manager.getDealsList(new DealsManager.GetDealsListener() {
            @Override
            public void onReceiveDeals(DealsDetails dealsDetails) {
                mDeals.postValue(dealsDetails);
            }

            @Override
            public void onError(Throwable responseStatus) {

            }
        });


        return mDeals;
    }
}

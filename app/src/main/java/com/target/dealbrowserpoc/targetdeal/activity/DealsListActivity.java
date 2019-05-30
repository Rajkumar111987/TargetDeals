package com.target.dealbrowserpoc.targetdeal.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.target.dealbrowserpoc.targetdeal.R;
import com.target.dealbrowserpoc.targetdeal.adapter.DealsAdapter;
import com.target.dealbrowserpoc.targetdeal.models.DealsDetails;
import com.target.dealbrowserpoc.targetdeal.viewmodel.DealsViewModel;

public class DealsListActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private DealsAdapter adapter;
    private DealsViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals_list);
        intialize();
    }

    private void intialize() {

        mViewModel = ViewModelProviders.of(this).get(DealsViewModel.class);
        mRecycler = findViewById(R.id.rvDeals);
        getDealsDetails();
    }

    private void setDeals(DealsDetails dealResponse) {
        adapter = new DealsAdapter(dealResponse.data, this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mRecycler.getChildLayoutPosition(v);
                Intent intent = new Intent(getApplicationContext(),DealsDetailsActivity.class);
                intent.putExtra("Product_Detail",dealResponse.data.get(position));
                startActivity(intent);

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(adapter);
    }

    private void getDealsDetails() {
        final Observer<DealsDetails> DealObserver = DealResponse -> {
            if (DealResponse != null) {
                setDeals(DealResponse);

            }
        };
        mViewModel.getDealsDetails().observe(this, DealObserver);

    }
}

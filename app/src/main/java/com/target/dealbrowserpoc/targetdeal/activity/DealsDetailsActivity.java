package com.target.dealbrowserpoc.targetdeal.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.target.dealbrowserpoc.targetdeal.R;
import com.target.dealbrowserpoc.targetdeal.databinding.DealsDetailsActivityBinding;
import com.target.dealbrowserpoc.targetdeal.models.DealsList;

public class DealsDetailsActivity extends AppCompatActivity {

    private DealsDetailsActivityBinding mDataBinding;
    private DealsList mDeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this,R.layout.deals_details_activity);
        intialize();
    }

    private void intialize() {
        mDeals = (DealsList)getIntent().getSerializableExtra("Product_Detail");
        mDataBinding.setDeals(mDeals);
        Picasso.with(this).load(mDeals.image).into(mDataBinding.ivProductImage);
        setStrike();
    }

    private void setStrike() {
        mDataBinding.tvOrginal.setText(String.format(getString(R.string.orginal_price),mDeals.originalPrice));
        if(!TextUtils.isEmpty(mDeals.salePrice)){
            mDataBinding.tvOrginal.setPaintFlags(mDataBinding.tvOrginal.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
    public void showToast(View view){
        Button button = (Button)view;
        boolean isCart = button.getText().toString().equalsIgnoreCase(getString(R.string.add_to_cart));
        Toast.makeText(this,isCart? "Is Added to the cart" : "Is Added to the List",Toast.LENGTH_SHORT).show();

    }
}

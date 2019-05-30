package com.target.dealbrowserpoc.targetdeal.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.target.dealbrowserpoc.targetdeal.R;
import com.target.dealbrowserpoc.targetdeal.models.DealsList;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.DealsViewHolder>{

    private List<DealsList> mDeals;
    private Context mContext;
    private View.OnClickListener mClickListener;

    public DealsAdapter (List<DealsList> dataList, Context context, View.OnClickListener clickListener){
        this.mDeals = dataList;
        this.mContext = context;
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public DealsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.deals_view,viewGroup,false);
        view.setOnClickListener(mClickListener);
        return new DealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsViewHolder dealsViewHolder, int position) {
        dealsViewHolder.tvName.setText(mDeals.get(position).title);
        dealsViewHolder.tvPrice.setText(TextUtils.isEmpty(mDeals.get(position).salePrice)
                ?mDeals.get(position).originalPrice : mDeals.get(position).salePrice);
        dealsViewHolder.tvAisle.setText(mDeals.get(position).aisle);
        Picasso.with(mContext).setLoggingEnabled(true);

        Picasso picasso = new Picasso.Builder(mContext).listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                exception.printStackTrace();
            }
        }).build();
        picasso.load(mDeals.get(position).image).into(dealsViewHolder.ivProduct);
    }

    @Override
    public int getItemCount() {
        return mDeals.size();
    }

    public Bitmap getProductImage(int image){
        Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(), image);
        return bmp;
    }


    public class DealsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvName,tvPrice,tvAisle;
        ImageView ivProduct;

        DealsViewHolder(View view){
            super(view);

            tvName = view.findViewById(R.id.tvName);
            tvPrice = view.findViewById(R.id.tvPrice);
            tvAisle = view.findViewById(R.id.tvAisle);
            ivProduct = view.findViewById(R.id.ivProduct);
        }

        @Override
        public void onClick(View v) {
            if(mClickListener != null){

            }
        }
    }
}

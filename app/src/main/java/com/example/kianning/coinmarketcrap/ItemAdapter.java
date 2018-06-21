package com.example.kianning.coinmarketcrap;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ryan Hoo on 2/19/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context mContext;
    private ArrayList<Items> mItems;

    public ItemAdapter(Context context , ArrayList<Items> mExampleList) {
        mContext = context;
        mItems = mExampleList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Items currentItem = mItems.get(position);

        String mName = currentItem.getmName();
        String mPrice = currentItem.getmPrice();
        String mRank = currentItem.getmRank();
        String mPriceChange = currentItem.getmChange();
        String mToBtc = currentItem.getmToBtc();

        holder.mName.setText(mName);
        holder.mPrice.setText("Price: $" + mPrice);
        holder.mRank.setText("Rank: " + mRank);
        if (mPriceChange.contains("-")){
            Color.parseColor("#FF0000");
            holder.mChange.setTextColor(Color.parseColor("#FF0000"));
            holder.mChange.setText("Change in 24 hrs: " + mPriceChange);
        }
        else {
            holder.mChange.setTextColor(Color.parseColor("#32CD32"));
            holder.mChange.setText("Change in 24 hrs: +" + mPriceChange);
        }

        holder.mToBtc.setText("Price to BTC: " + mToBtc);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView mName;
        public TextView mPrice;
        public TextView mRank;
        public TextView mChange;
        public TextView mToBtc;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.item_name);
            mPrice = itemView.findViewById(R.id.item_price);
            mRank = itemView.findViewById(R.id.item_rank);
            mChange = itemView.findViewById(R.id.item_price_change);
            mToBtc = itemView.findViewById(R.id.item_price_to_btc);
        }
    }
}

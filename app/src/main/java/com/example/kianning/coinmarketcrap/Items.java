package com.example.kianning.coinmarketcrap;

/**
 * Created by Ryan Hoo on 2/19/2018.
 */

public class Items {

    private String mName;
    private String mPrice;
    private String mRank;
    private String mChange;
    private String mToBtc;

    public Items(String mName, String mPrice, String mRank, String mChange, String mToBtc) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mRank = mRank;
        this.mChange = mChange;
        this.mToBtc = mToBtc;
    }

    //Empty public constructor need to display to adapter
    public Items(){

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmRank() {
        return mRank;
    }

    public void setmRank(String mRank) {
        this.mRank = mRank;
    }

    public String getmChange() {
        return mChange;
    }

    public void setmChange(String mChange) {
        this.mChange = mChange;
    }

    public String getmToBtc() {
        return mToBtc;
    }

    public void setmToBtc(String mToBtc) {
        this.mToBtc = mToBtc;
    }
}

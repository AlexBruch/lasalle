package com.example.pol.s5;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pol on 15/11/2016.
 */


public class ItemsList implements Parcelable {
    private String mName;
    private String mDetails;
    private int mImage;
    private String mPreu;

    public ItemsList(String name, String details, int image, String preu){
        mName=name;
        mDetails=details;
        mImage=image;
        mPreu=preu;
    }

    public String getName() {
        return mName;
    }

    public void setmPreu(String mPreu) {
        this.mPreu = mPreu;
    }

    public String getmPreu() {
        return mPreu;
    }

    public String getDetails() {
        return mDetails;
    }

    public int getImage() {
        return mImage;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }

    protected ItemsList(Parcel in) {
        mName = in.readString();
        mDetails = in.readString();
        mImage = in.readInt();
        mPreu = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDetails);
        dest.writeInt(mImage);
        dest.writeString(mPreu);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ItemsList> CREATOR = new Parcelable.Creator<ItemsList>() {
        @Override
        public ItemsList createFromParcel(Parcel in) {
            return new ItemsList(in);
        }

        @Override
        public ItemsList[] newArray(int size) {
            return new ItemsList[size];
        }
    };
}



/*
public class ItemsList {
    private String mName;
    private String mDetails;
    private int mImage;
    private String mPreu;

    public ItemsList(String name, String details, int image, String preu){
        mName=name;
        mDetails=details;
        mImage=image;
        mPreu=preu;
    }

    public String getName() {
        return mName;
    }

    public void setmPreu(String mPreu) {
        this.mPreu = mPreu;
    }

    public String getmPreu() {
        return mPreu;
    }

    public String getDetails() {
        return mDetails;
    }

    public int getImage() {
        return mImage;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }
}
*/
package com.example.pol.s5;

/**
 * Created by Pol on 15/11/2016.
 */

public class Destino {
    private String mName;
    private String mDetails;
    private int mImage;
    private String mPreu;

    public Destino(String name, String details, int image, String preu){
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

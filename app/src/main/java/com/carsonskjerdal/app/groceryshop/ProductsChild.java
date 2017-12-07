package com.carsonskjerdal.app.groceryshop;


/**
 * Created by Carson on 2017-11-28.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class ProductsChild {


    private String mPrice;
    private boolean mSolved;

    public ProductsChild(String price, boolean solved) {
        mPrice = price;
        mSolved = solved;
    }

    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setSolved(Boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Boolean getSolved() {
        return mSolved;
    }

    public String getQuanity() {

        String quanity;

        return "Quanity: 0";
    }
}

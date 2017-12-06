package com.carsonskjerdal.app.groceryshop;

import org.json.JSONArray;

import java.util.Date;

/**
 * Created by Carson on 2017-11-28.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class ProductsChild {


    private Date mDate;
    private boolean mSolved;

    public ProductsChild(Date date, boolean solved) {
        mDate = date;
        mSolved = solved;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getDate() {
        return mDate;
    }

    public void setSolved(Boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Boolean getSolved() {
        return mSolved;
    }
}

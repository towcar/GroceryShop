package com.carsonskjerdal.app.groceryshop;


import android.util.Log;

/**
 * Created by Carson on 2017-11-22.
 * <p>
 * Feel free to use code just give credit please :)
 */

public final class CartItems {

    private String name;
    private Integer image;
    private String price;
    private String quantity;

    public CartItems(String name, Integer image, String price, String quantity){

        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getImage() {
        return image;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }
}

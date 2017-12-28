package com.carsonskjerdal.app.groceryshop;


/**
 * Created by Carson on 2017-11-22.
 * <p>
 * Feel free to use code just give credit please :)
 */

public final class Groceries  {

    private String name;
    private String image;

    public Groceries(String name, String image){

        this.name = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }



}

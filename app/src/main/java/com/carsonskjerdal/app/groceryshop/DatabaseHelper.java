package com.carsonskjerdal.app.groceryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carson on 2017-12-13.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "groceryDatabase";
    private static final int DATABASE_VERSION = 3;

    // Table Names
    private static final String TABLE_GROCERIES = "groceries";
    private static final String TABLE_PRODUCTS = "products";
    private static final String TABLE_CART = "cart";

    // Grocery Table Columns
    private static final String KEY_GROCERIES_ID = "id";
    private static final String KEY_GROCERIES_NAME = "userName";
    private static final String KEY_GROCERIES_IMAGE = "userImage";

    // User Table Columns
    private static final String KEY_PRODUCTS_ID = "id";
    private static final String KEY_PRODUCTS_NAME = "productsName";
    private static final String KEY_PRODUCTS_IMAGE = "productsImage";
    private static final String KEY_PRODUCTS_GROUP = "productsGroup";
    private static final String KEY_PRODUCTS_PRICE = "productsPrice";

    // Cart Table Columns
    private static final String KEY_CART_ID = "id";
    private static final String KEY_CART_NAME = "cartName";
    private static final String KEY_CART_IMAGE = "cartImage";
    private static final String KEY_CART_PRICE = "cartPrice";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POSTS_TABLE = "CREATE TABLE " + TABLE_GROCERIES +
                "(" +
                KEY_GROCERIES_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                KEY_GROCERIES_NAME + " INTEGER REFERENCES " + TABLE_GROCERIES + "," + // Define a foreign key
                KEY_GROCERIES_IMAGE + " TEXT" +
                ")";

        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS +
                "(" +
                KEY_PRODUCTS_ID + " INTEGER PRIMARY KEY," +
                KEY_PRODUCTS_NAME + " TEXT," +
                KEY_PRODUCTS_IMAGE + " TEXT," +
                KEY_PRODUCTS_GROUP + " TEXT," +
                KEY_PRODUCTS_PRICE + " TEXT" +
                ")";

        String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_CART +
                "(" +
                KEY_CART_ID + " INTEGER PRIMARY KEY," +
                KEY_CART_NAME + " TEXT," +
                KEY_CART_IMAGE + " TEXT," +
                KEY_CART_PRICE + " TEXT" +
                ")";

        db.execSQL(CREATE_POSTS_TABLE);
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_CART_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERIES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
            onCreate(db);
        }
    }


    //Shopping Cart Methods
    public void createCartItem(String name, String image, String price) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //adding values to ContentValues
        //TODO changes the values input on the 2nd argument
        values.put(KEY_CART_NAME, name);
        values.put(KEY_CART_IMAGE, image);
        values.put(KEY_CART_PRICE, price);

        // insert row
        db.insert(TABLE_CART, null, values);


    }
}

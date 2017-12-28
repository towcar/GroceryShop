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
    private static final int DATABASE_VERSION = 16;

    // Table Names
    private static final String TABLE_GROCERIES = "groceries";
    private static final String TABLE_PRODUCTS = "products";
    private static final String TABLE_CART = "cart";

    // Grocery Table Columns
    private static final String KEY_GROCERIES_ID = "id";
    private static final String KEY_GROCERIES_NAME = "groceryName";
    private static final String KEY_GROCERIES_IMAGE = "groceryImage";

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
                KEY_GROCERIES_NAME + " TEXT, " +
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

        addTableData(db);
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


    private void addTableData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        //add Grocery data to its table

        String[][] data = {{"Fish", "fishicon48"}, {"Bread", "breadicon"}, {"Milk", "milkicon"}, {"Apples", "appleicon"},
                {"Oranges", "orangeicon"}, {"Candy", "candyicon"}, {"Soup", "soupicon"}, {"Medicine", "medicineicon"}, {"Pasta", "pastaicon"},
                {"Condiments", "condimenticon"}, {"Soft Drinks", "softdrinkicon"}, {"Beef", "beeficon"}, {"Vegetables", "veggieicon"}, {"Cheese", "cheeseicon"}};

        for (String[] aData : data) {
            values.put(KEY_GROCERIES_NAME, aData[0]);
            values.put(KEY_GROCERIES_IMAGE, aData[1]);

            db.insert(TABLE_GROCERIES, null, values);
        }

        //add Product data to its table
        ContentValues values2 = new ContentValues();
        //ugly example data
        String[][] data2 = {{"Johnnys Fish", "fishicon48", "11.95", "Fish"},  {"Pirate Man Fish", "fishicon48", "15.95", "Fish"},  {"Prime AA Fish", "fishicon48", "11.95", "Fish"},  {"Bland Bread", "0", "3.15", "Bread"}
                ,  {"King's Bread", "0", "6.95", "Bread"},  {"Wonder Bread", "0", "3.95", "Bread"},  {"Moo Man Milk", "0", "4.25", "Milk"},  {"Prairie Cow", "0", "4.45", "Milk"}
                ,  {"American Milk", "0", "11.95", "Milk"},  {"Red Apples", "0", "11.95", "Apples"},  {"Round New Yorks", "0", "11.95", "Apples"},  {"Sour Sam Apples", "0", "11.95", "Apples"}
                ,  {"Not Red Oranges", "0", "0.95", "Oranges"},  {"Chinese", "0", "1.10", "Oranges"},  {"Box Oranges", "0", "18.95", "Oranges"},  {"Sour Keys", "0", "0.25", "Candy"}
                ,  {"Blue Whales", "0", "0.25", "Candy"},  {"Pringles", "0", "1.25", "Candy"},  {"Johnnys Fish", "0", "11.95", "Soup"},  {"Johnnys Fish", "0", "11.95", "Soup"}
                ,  {"Johnnys Fish", "0", "11.95", "Soup"},  {"Johnnys Fish", "0", "11.95", "Medicine"},  {"Johnnys Fish", "0", "11.95", "Medicine"},  {"Johnnys Fish", "0", "11.95", "Medicine"}
                ,  {"Johnnys Fish", "0", "11.95", "Pasta"},  {"Johnnys Fish", "0", "11.95", "Pasta"},  {"Johnnys Fish", "0", "11.95", "Pasta"},  {"Johnnys Fish", "0", "11.95", "Condiments"}
                ,  {"Johnnys Fish", "0", "11.95", "Condiments"},  {"Johnnys Fish", "0", "11.95", "Soft Drinks"},  {"Johnnys Fish", "0", "11.95", "Soft Drinks"},  {"Johnnys Fish", "0", "11.95", "Soft Drinks"}
                ,  {"Johnnys Fish", "0", "11.95", "Beef"},  {"Johnnys Fish", "0", "11.95", "Condiments"},  {"Johnnys Fish", "0", "11.95", "Beef"},  {"Johnnys Fish", "0", "11.95", "Beef"}
                ,  {"Johnnys Fish", "0", "11.95", "Vegetables"},  {"Johnnys Fish", "0", "11.95", "Vegetables"},  {"Johnnys Fish", "0", "11.95", "Vegetables"},  {"Johnnys Fish", "0", "11.95", "Cheese"}
                ,  {"Johnnys Fish", "0", "11.95", "Cheese"},  {"Johnnys Fish", "0", "11.95", "Cheese"}};

        for (String[] aData : data2) {
            values2.put(KEY_PRODUCTS_NAME, aData[0]);
            values2.put(KEY_PRODUCTS_IMAGE, aData[1]);
            values2.put(KEY_PRODUCTS_PRICE, aData[2]);
            values2.put(KEY_PRODUCTS_GROUP, aData[3]);

            db.insert(TABLE_PRODUCTS, null, values2);
        }
    }
}

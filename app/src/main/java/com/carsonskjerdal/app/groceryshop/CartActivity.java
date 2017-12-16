package com.carsonskjerdal.app.groceryshop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    Button checkoutButton;
    List<CartItems> cartProducts;
    CartItems cartItems;

    DatabaseManager dbManager;
    //final SQLiteDatabase mDatabase = dbManager.openDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        dbManager = DatabaseManager.getInstance(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

        //method to build the CartProducts list
        cartProducts = getCartData();

        CartItemAdapter mAdapter = new CartItemAdapter(cartProducts);
        recyclerView.setAdapter(mAdapter);

        checkoutButton = findViewById(R.id.button_checkout);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opens payment window
                Intent myIntent = new Intent(CartActivity.this, CheckoutActivity.class);

                startActivity(myIntent);

                //purchase made closing screen with eta counter?
            }
        });
    }

    private List<CartItems> getCartData() {
        List<CartItems> list = new ArrayList<>();
        Integer image = R.mipmap.ic_launcher_round;
        cartItems = new CartItems("App1", 0, "19.21");

        //opens a cursor containing all the data from our database Table

        //loop through putting the cursor data into object which are then put into a list
        try (Cursor cursor = dbManager.queryAllItems("cart")) {
            while (cursor.moveToNext()) {
                String data = cursor.getString(1);
                Integer data2 = cursor.getInt(2);
                String data3 = cursor.getString(3);

                cartItems = new CartItems(data, data2, data3);

                list.add(cartItems);
            }
            //close the cursor after use.
            cursor.close();
        }

        return list;
    }
}

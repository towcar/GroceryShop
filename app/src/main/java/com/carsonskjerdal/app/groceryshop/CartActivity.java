package com.carsonskjerdal.app.groceryshop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                llm.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //method to build the CartProducts list
        cartProducts = getCartData();

        CartItemAdapter mAdapter = new CartItemAdapter(cartProducts);
        recyclerView.setAdapter(mAdapter);

        TextView textTotal = findViewById(R.id.textViewTotal);
        String total = buildPrice(cartProducts);
        textTotal.setText(total);

        //button for ending the activity and moving to transaction completion
        checkoutButton = findViewById(R.id.button_checkout);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pass the data

                //clear the data after payment is successful

                //opens payment window
                Intent myIntent = new Intent(CartActivity.this, CheckoutActivity.class);

                startActivity(myIntent);

                //purchase made closing screen with eta counter?
            }
        });
    }

    private String buildPrice(List<CartItems> cartProducts) {
        Double total = 0.0;
        CartItems cartItem;
        for(int i = 0; i < cartProducts.size(); i++){
            cartItem = cartProducts.get(i);
            total += Double.parseDouble(cartItem.getPrice());
        }

        return total.toString();
    }

    private List<CartItems> getCartData() {
        List<CartItems> list = new ArrayList<>();
        Integer image = R.mipmap.ic_launcher_round;
        cartItems = new CartItems("App1", 0, "19.21", "1");

        //opens a cursor containing all the data from our database Table

        //loop through putting the cursor data into object which are then put into a list
        try (Cursor cursor = dbManager.queryAllItems("cart")) {
            while (cursor.moveToNext()) {
                String data = cursor.getString(1);
                Integer data2 = cursor.getInt(2);
                String data3 = cursor.getString(3);
                String data4 = cursor.getString(4);

                cartItems = new CartItems(data, data2, data3, data4);

                list.add(cartItems);
            }
            //close the cursor after use.
            cursor.close();
        }

        return list;
    }
}

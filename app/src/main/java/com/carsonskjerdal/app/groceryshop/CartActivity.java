package com.carsonskjerdal.app.groceryshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CartActivity extends AppCompatActivity {

    Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        checkoutButton = findViewById(R.id.button_checkout);






        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opens payment window
                //Intent myIntent = new Intent(CartActivity.this, PurchaseActivity.class);

                //startActivity(myIntent);

                //purchase made closing screen with eta counter?
            }
        });
    }
}

package com.carsonskjerdal.app.groceryshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainHomePageActivity extends BaseActivity {

    //Ui References
    Button shopButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        //assign buttons
        shopButton = findViewById(R.id.shop_button);
        shopButton.setOnClickListener(onClickListener);


    }

    //listens for button clicks to launch activities
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.shop_button:
                    //Launch Shop Activity
                    Intent i = new Intent(MainHomePageActivity.this, ShopActivity.class);
                    startActivity(i);

                    break;
                case R.id.button2:
                    //DO something
                    break;
            }

        }
    };
}

package com.carsonskjerdal.app.groceryshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    //Ui Componenets


    //Adapter
    ProductsExpandableAdapter mAdapter;

    //list
    List<Products> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //cartButton = findViewById(R.id.toolbar_button2);

        //proper list temporarily generated until a database is built
        final List<Products> products = generateProductList();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new ProductsExpandableAdapter(this, products);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                Products expandedProducts = products.get(position);

               /* String toastMsg = getResources().getString("expanded", expandedProducts.getName());
                Toast.makeText(ProductsActivity.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();*/
            }

            @Override
            public void onListItemCollapsed(int position) {
                Products expandedProducts = products.get(position);

               /* String toastMsg = getResources().getString("expanded", expandedProducts.getName());
                Toast.makeText(ProductsActivity.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();*/
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private List<Products> generateProductList() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "31-08-1982";
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String price = "2.45";

        ProductsChild apple1 = new ProductsChild(price, false);

        int image = R.mipmap.ic_launcher;

        Products appleProduct1 = new Products("apple1", image, Arrays.asList(apple1));


        final List<Products> products = Arrays.asList(appleProduct1);

        return products;
    }


    void filter(String text) {
        List<Products> temp = new ArrayList<>();
        for (Products d : list) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            String searchText = text.toLowerCase();
            String recycleText = d.getName().toLowerCase();
            if (recycleText.contains(searchText)) {
                temp.add(d);

            }
        }
        //update recyclerview
        //productsExpandableAdapter.updateList(temp);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_complete:
                // complete workout
                Integer int1 = 0;
                //Adds new workout to Adapter
                Intent myIntent = new Intent(ProductsActivity.this,
                        CartActivity.class);
                startActivityForResult(myIntent, int1);
                return true;

            /*case R.id.action_complete:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;*/

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}

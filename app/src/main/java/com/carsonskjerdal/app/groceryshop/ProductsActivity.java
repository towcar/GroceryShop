package com.carsonskjerdal.app.groceryshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.SearchView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    //Ui Componenets
    RecyclerView recyclerView;
    SearchView searchView;

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

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "31-08-1982";
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ProductsChild beef = new ProductsChild(date, false);
        ProductsChild cheese = new ProductsChild(date, true);
        ProductsChild salsa = new ProductsChild(date, true);
        ProductsChild tortilla = new ProductsChild(date, true);
        ProductsChild ketchup = new ProductsChild(date, true);
        ProductsChild bun = new ProductsChild(date, true);

        int image = R.mipmap.ic_launcher;

        Products taco = new Products("taco", image, Arrays.asList(beef, salsa, bun));
        Products quesadilla = new Products("quesadilla", image, Arrays.asList(ketchup, tortilla, cheese));
        Products burger = new Products("burger", image, Arrays.asList(bun, ketchup, salsa));
        final List<Products> products = Arrays.asList(taco, quesadilla, burger);

        //proper list temporarily generated until a database is built
        final List<Products> products2 = generateProductList();

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

        ProductsChild beef = new ProductsChild(date, false);
        ProductsChild cheese = new ProductsChild(date, true);
        ProductsChild salsa = new ProductsChild(date, true);
        ProductsChild tortilla = new ProductsChild(date, true);
        ProductsChild ketchup = new ProductsChild(date, true);
        ProductsChild bun = new ProductsChild(date, true);

        int image = R.mipmap.ic_launcher;

        Products taco = new Products("taco", image, Arrays.asList(beef, salsa, bun));
        Products quesadilla = new Products("quesadilla", image, Arrays.asList(ketchup, tortilla, cheese));
        Products burger = new Products("burger", image, Arrays.asList(bun, ketchup, salsa));

        final List<Products> products = Arrays.asList(taco, quesadilla, burger);

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
}

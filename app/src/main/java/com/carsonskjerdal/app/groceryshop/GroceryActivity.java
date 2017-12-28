package com.carsonskjerdal.app.groceryshop;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class GroceryActivity extends AppCompatActivity {

    //Ui Componenets
    RecyclerView recyclerView;
    SearchView searchView;
    ImageButton cartButton;

    //Adapter
    GroceryAdapter myAdapter;

    //list
    List<Groceries> list;

    //Database
    DatabaseManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        dbManager = DatabaseManager.getInstance(this);

        //Search Bar
        searchView = findViewById(R.id.search_view);

        //Turn iconified to false:
        searchView.setIconified(false);
        //The above line will expand it to fit the area as well as throw up the keyboard

        //To remove the keyboard, but make sure you keep the expanded version:
        searchView.clearFocus();

        list = buildList();

        //Setup Recycler & Adapter
        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                llm.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        myAdapter = new GroceryAdapter(list);

        recyclerView.setAdapter(myAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do your search
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //update recycler view to display the results
                filter(newText);
                return true;
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // launch InsectDetailsActivity passing information over.
                        Intent intent = new Intent(view.getContext(), ProductsActivity.class);

                        //passing data over to next activity
                        Groceries grocery = list.get(position);
                        String nameToPass = grocery.getName();

                        intent.putExtra("resultName", nameToPass);

                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // in case LongClick is to later be implemented
                    }
                })
        );



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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
                Intent myIntent = new Intent(GroceryActivity.this,
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



   private List<Groceries> buildList() {
       List<Groceries> list = new ArrayList<>();
       Groceries groceries;

       //opens a cursor containing all the data from our database Table

       //loop through putting the cursor data into object which are then put into a list
       try (Cursor cursor = dbManager.queryAllItems("groceries")) {
           while (cursor.moveToNext()) {
               String data = cursor.getString(1);
               String data2 = cursor.getString(2);

               groceries = new Groceries(data, data2);

               list.add(groceries);
           }
           //close the cursor after use.
           cursor.close();
       }

       return list;
    }

    void filter(String text) {
        List<Groceries> temp = new ArrayList<>();
        for (Groceries d : list) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            String searchText = text.toLowerCase();
            String recycleText = d.getName().toLowerCase();
            if (recycleText.contains(searchText)) {
                temp.add(d);

            }

            //update recyclerview
            myAdapter.updateList(temp);


        }
    }
}


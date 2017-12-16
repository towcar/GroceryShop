package com.carsonskjerdal.app.groceryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Carson on 2017-11-28.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class ProductsChildViewHolder extends ChildViewHolder {

    public TextView mDateText;
    public Button mAddButton;
    public TextView mQuanityText;
    public SeekBar mSeekBar;
    View view;
    // variable to hold context
    private Context context;

    public ProductsChildViewHolder(final View itemView) {
        super(itemView);

        final DatabaseManager dbManager = DatabaseManager.getInstance(itemView.getContext());
        final SQLiteDatabase mDatabase = dbManager.openDatabase();


        mDateText = itemView.findViewById(R.id.child_list_item_crime_date_text_view);
        mAddButton = itemView.findViewById(R.id.add_button);


        view = itemView.findViewById(R.id.seekBar);

        mQuanityText = view.findViewById(R.id.textViewCustom);
        mSeekBar = view.findViewById(R.id.seekBarCustom);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mQuanityText.setText("Quantity: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add the item to the shopping cart.
                //give you the position of the parentLayout
                int position = getAdapterPosition() - 1;
                View view2 = itemView.getRootView();
                RecyclerView rv = view2.findViewById(R.id.recycler_view);
                ProductsExpandableAdapter mAdapter = (ProductsExpandableAdapter) rv.getAdapter();
                List list = mAdapter.getParentItemList();
                //the current product you are on
                Products products = (Products) list.get(position);

                Log.e("list output","" + products.getName());

                String priceTag = (String) mDateText.getText();

                //toast
                String toastMsg = mDateText.getText() + " Added To Cart";
                Toast.makeText(view.getContext(),
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();

                // Add items to cart table to the database
                ContentValues values = new ContentValues();
                values.put("cartName", products.getName());
                values.put("cartImage", products.getImage());
                values.put("cartPrice", priceTag);
                mDatabase.insert("cart",null,values);
                Log.e("values","" + values);
            }
        });
    }

}
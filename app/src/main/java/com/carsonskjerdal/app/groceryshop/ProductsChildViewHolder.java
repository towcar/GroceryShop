package com.carsonskjerdal.app.groceryshop;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


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

    public ProductsChildViewHolder(View itemView) {
        super(itemView);

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
    }

}
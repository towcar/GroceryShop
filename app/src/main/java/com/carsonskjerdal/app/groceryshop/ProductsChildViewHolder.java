package com.carsonskjerdal.app.groceryshop;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * Created by Carson on 2017-11-28.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class ProductsChildViewHolder extends ChildViewHolder {

    public TextView mDateText;
    public CheckBox mCrimeSolvedCheckBox;

    public ProductsChildViewHolder(View itemView) {
        super(itemView);

        mDateText = itemView.findViewById(R.id.child_list_item_crime_date_text_view);
        mCrimeSolvedCheckBox = itemView.findViewById(R.id.child_list_item_crime_solved_check_box);
    }

}
package com.carsonskjerdal.app.groceryshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;

/**
 * Created by Carson on 2017-11-28.
 * <p>
 * Feel free to use code just give credit please :)
 */

public class ProductsExpandableAdapter extends ExpandableRecyclerAdapter<ProductsParentViewHolder, ProductsChildViewHolder> {

    LayoutInflater mInflater;

    public ProductsExpandableAdapter(Context context, List<Products> parentItemList) {
        super(parentItemList);

        mInflater = LayoutInflater.from(context);
    }

    //creates the main layout in the recycler view.
    @Override
    public ProductsParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.product_item_layout, viewGroup, false);
        return new ProductsParentViewHolder(view);
    }

    //creates the child layout
    @Override
    public ProductsChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.product_item_layout_child, viewGroup, false);
        return new ProductsChildViewHolder(view);
    }


    //binds daya with the main parent layout
    @Override
    public void onBindParentViewHolder(ProductsParentViewHolder productViewHolder, int position, ParentListItem parentListItem) {
        Products products = (Products) parentListItem;
        productViewHolder.bind(products);
    }

    //binds data with the child layout
    @Override
    public void onBindChildViewHolder(ProductsChildViewHolder productsChildViewHolder, int i, Object childObject) {
        ProductsChild productsChild = (ProductsChild) childObject;
        productsChildViewHolder.mDateText.setText(productsChild.getPrice());

    }


}

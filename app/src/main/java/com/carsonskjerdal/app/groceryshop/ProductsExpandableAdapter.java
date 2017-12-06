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

    @Override
    public ProductsParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.product_item_layout, viewGroup, false);
        return new ProductsParentViewHolder(view);
    }

    @Override
    public ProductsChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.product_item_layout_child, viewGroup, false);
        return new ProductsChildViewHolder(view);
    }

    /*@Override
    public void onBindParentViewHolder(ProductsParentViewHolder productsParentViewHolder, int i, Object parentObject) {
        Products products = (Products) parentObject;
        productsParentViewHolder.mTitleTextView.setText(products.getName());
    }*/

    @Override
    public void onBindParentViewHolder(ProductsParentViewHolder productViewHolder, int position, ParentListItem parentListItem) {
        Products products = (Products) parentListItem;
        productViewHolder.bind(products);
    }

    @Override
    public void onBindChildViewHolder(ProductsChildViewHolder productsChildViewHolder, int i, Object childObject) {
        ProductsChild productsChild = (ProductsChild) childObject;
        productsChildViewHolder.mDateText.setText(productsChild.getDate().toString());
        productsChildViewHolder.mCrimeSolvedCheckBox.setChecked(productsChild.getSolved());
    }


}

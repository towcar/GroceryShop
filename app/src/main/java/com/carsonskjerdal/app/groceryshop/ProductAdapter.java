package com.carsonskjerdal.app.groceryshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Carson on 2017-11-22.
 *
 * RecyclerView adapter extended with project-specific required methods
 *
 * This may all be null and useless now after upgrading my adapter with the ExpandabaleRecyclerAdapter
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Products> productList;
    List<ProductHolder> displayedList;
    private LayoutInflater mInflater;

    public ProductAdapter(Context context, List<Products> list) {
        productList = list;
        mInflater = LayoutInflater.from(context);

    }

    /* ViewHolder for each insect item */
    public class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView image;


        ProductHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }



        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_layout, parent, false);


        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Products product = productList.get(position);

        //Sets Text
        holder.name.setText(product.getName());
        holder.image.setImageResource(product.getImage());

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    public void updateList(List<Products> newList){
        productList = newList;
        notifyDataSetChanged();
    }


}

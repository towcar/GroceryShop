package com.carsonskjerdal.app.groceryshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartHolder> {

    private List<CartItems> cartList;
    private LayoutInflater mInflater;

    public CartItemAdapter(List<CartItems> list) {
        cartList = list;
        //mInflater = LayoutInflater.from(context);

    }

    /* ViewHolder for each insect item */
    public class CartHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView image;
        TextView price;


        CartHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.price);
        }



        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public CartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_layout, parent, false);


        return new CartHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartHolder holder, int position) {
        CartItems cartItem = cartList.get(position);

        //Sets Text
        holder.name.setText(cartItem.getName());
        holder.image.setImageResource(cartItem.getImage());
        holder.price.setText(cartItem.getPrice());
    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }


    public void updateList(List<CartItems> newList){
        cartList = newList;
        notifyDataSetChanged();
    }


}

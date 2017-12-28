package com.carsonskjerdal.app.groceryshop;

import android.content.res.Resources;
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
 * RecyclerView adapter extended with project-specific required methods.
 */

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryHolder> {

    private List<Groceries> groceryList;
    List<GroceryHolder> displayedList;

    public GroceryAdapter(List<Groceries> list) {
        groceryList = list;


    }

    /* ViewHolder for each insect item */
    public class GroceryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView image;


        GroceryHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }



        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public GroceryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grocery_item_layout, parent, false);


        return new GroceryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GroceryHolder holder, int position) {
        Groceries grocery = groceryList.get(position);

        //Sets Text
        holder.name.setText(grocery.getName());

        //sets image
        Log.e("adapter","image " + grocery.getImage());
        String uri = grocery.getImage();
        Resources res = holder.image.getContext().getResources();
        holder.image.setImageResource(res.getIdentifier(uri, "drawable", BuildConfig.APPLICATION_ID));
        //holder.image.setImageResource(grocery.getImage());

    }


    @Override
    public int getItemCount() {
        return groceryList.size();
    }


    public void updateList(List<Groceries> newList){
        groceryList = newList;
        notifyDataSetChanged();
    }


}

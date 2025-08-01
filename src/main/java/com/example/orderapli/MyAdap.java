package com.example.orderapli;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdap extends RecyclerView.Adapter<MyViewHold> {
    Context context;
    List<Item> items;

    public MyAdap(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    public void updateItems(List<Item> newItems) {
        this.items = newItems;
        notifyDataSetChanged(); // Refresh the RecyclerView
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHold(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHold holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.priceView.setText(items.get(position).getPrice());
        holder.imageView.setImageResource(items.get(position).getImage());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Clicked: " + items.get(position).getName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, ProductActivity.class);
            intent.putExtra("name", items.get(position).getName());
            intent.putExtra("price", items.get(position).getPrice());
            intent.putExtra("image", items.get(position).getImage());
            intent.putExtra("desc", items.get(position).getDesc());
            intent.putExtra("offers", items.get(position).getOffers());
            intent.putExtra("rating", items.get(position).getRating());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
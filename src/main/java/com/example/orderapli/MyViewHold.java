package com.example.orderapli;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHold extends RecyclerView.ViewHolder {
    public TextView nameView, priceView;
    public ImageView imageView;

    public MyViewHold(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        imageView = itemView.findViewById(R.id.imageview);
    }
}
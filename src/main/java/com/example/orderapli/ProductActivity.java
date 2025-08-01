package com.example.orderapli;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mac1);

        ImageView prodImag = findViewById(R.id.product_image);
        TextView prodTit = findViewById(R.id.product_title);
        TextView prodPri = findViewById(R.id.product_price);
        TextView prodoff = findViewById(R.id.off_text);
        RatingBar ratingBar = findViewById(R.id.product_rating);
        TextView ratingText = findViewById(R.id.rating_text);

        // Get data from intent
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        int image = getIntent().getIntExtra("image", 0);
        String offers = getIntent().getStringExtra("offers");
        float rating = getIntent().getFloatExtra("rating", 0);

        // Set the data
        prodTit.setText(name);
        prodPri.setText(price);
        prodoff.setText(offers);
        prodImag.setImageResource(image);
        ratingBar.setRating(rating);
        ratingText.setText(String.format("%.1f/5", rating));

        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());
    }
}
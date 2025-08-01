package com.example.orderapli;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdap adapter;
    private List<Item> items = new ArrayList<>();
    private List<Item> filteredItems = new ArrayList<>();
    private EditText searchEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main1);

        recyclerView = findViewById(R.id.recyclerview);
        searchEditText = findViewById(R.id.search_edittext);
        searchButton = findViewById(R.id.search_button);

        initializeItems();
        adapter = new MyAdap(this, items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Search button click listener
        searchButton.setOnClickListener(v -> {
            String searchText = searchEditText.getText().toString().trim().toLowerCase();
            filterItems(searchText);
        });

        // Optional: Add search as you type functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                // Uncomment if you want search-as-you-type
                // filterItems(s.toString().trim().toLowerCase());
            }
        });
    }

    private void initializeItems() {
        items.clear();

        items.add(new Item(
                "MacBook air 1",
                "₹92,990",
                R.drawable.macmaca,
                "Apple M1 chip with 8-core CPU\n13.3-inch Retina display\nUp to 18 hours battery life\nFanless design for silent operation",
                "Get 5% back with Amazon Pay ICICI Bank credit card for Prime members",4.5f
        ));

        items.add(new Item(
                "lenova thin edge",
                "₹1,09,900",
                R.drawable.mac2,
                "Apple M2 chip with 8-core CPU\n13.6-inch Liquid Retina display\nUp to 18 hours battery life\nMagSafe charging\n1080p FaceTime HD camera",
                "No Cost EMI available on all credit cards\nExtra ₹5,000 off on exchange",4f
        ));
        items.add(new Item(
                "dell amoled display",
                "₹1,09,900",
                R.drawable.mac2,
                "Apple M2 chip with 8-core CPU\n13.6-inch Liquid Retina display\nUp to 18 hours battery life\nMagSafe charging\n1080p FaceTime HD camera",
                "No Cost EMI available on all credit cards\nExtra ₹5,000 off on exchange",4f
        ));

        items.add(new Item(
                "hp laptop 512gb,",
                "₹1,99,900",
                R.drawable.mac4,
                "Apple M3 Pro chip (12-core CPU, 18-core GPU)\n14.2-inch Liquid Retina XDR display\nUp to 18 hours battery life\n6-speaker sound system\n1080p FaceTime HD camera",
                "Free AirPods (3rd generation) worth ₹19,900\n1-year Apple Care+ included",3.9f
        ));

        items.add(new Item(
                "MacBook air2",
                "₹3,49,900",
                R.drawable.mac2,
                "Apple M3 Max chip (16-core CPU, 40-core GPU)\n16.2-inch Liquid Retina XDR display\nUp to 22 hours battery life\nAdvanced thermal system\nStudio-quality mics",
                "Special financing: Pay in 12 months at 0% interest\nFree engraving available",3.9f
        ));

        items.add(new Item(
                "omen hp 1tb",
                "₹1,39,900",
                R.drawable.mac11,
                "Apple M2 chip with 8-core CPU\n15.3-inch Liquid Retina display\nUp to 18 hours battery life\nSix-speaker sound system\nMagSafe charging",
                "Instant ₹7,000 discount for HDFC card users\nFree Magic Mouse worth ₹8,900",4.7f
        ));

        items.add(new Item(
                "samasung s56",
                "₹1,39,900",
                R.drawable.mac1,
                "Apple M2 chip (8-core CPU, 10-core GPU)\n13.3-inch Retina display\nTouch Bar\nUp to 20 hours battery life\nActive cooling system",
                "Save ₹10,000 with education discount\nFree 3-month Adobe Creative Cloud subscription",4.5f
        ));

        items.add(new Item(
                "one pluss biggee",
                "₹1,09,990",
                R.drawable.mac2,
                "Apple M1 chip with 8-core CPU\n13.3-inch Retina display\nUp to 18 hours battery life\nFanless design\nBacklit Magic Keyboard",
                "Limited time: Free Apple TV+ for 6 months\nExtra 10% off for corporate buyers",4.3f
        ));
        items.add(new Item(
                "MacBook Air M2 (Midnight, 256 GB) (8 GB RAM)",
                "₹1,09,900",
                R.drawable.mac2,
                "Apple M2 chip with 8-core CPU\n13.6-inch Liquid Retina display\nUp to 18 hours battery life\nMagSafe charging\n1080p FaceTime HD camera",
                "No Cost EMI available on all credit cards\nExtra ₹5,000 off on exchange",4f
        ));

        items.add(new Item(
                "lenova 512gb,",
                "₹1,99,900",
                R.drawable.mac4,
                "Apple M3 Pro chip (12-core CPU, 18-core GPU)\n14.2-inch Liquid Retina XDR display\nUp to 18 hours battery life\n6-speaker sound system\n1080p FaceTime HD camera",
                "Free AirPods (3rd generation) worth ₹19,900\n1-year Apple Care+ included",3.9f
        ));

        items.add(new Item(
                "MacBook Pro 16-inch M3 Max (Silver, 1 TB) (36 GB RAM)",
                "₹3,49,900",
                R.drawable.mac2,
                "Apple M3 Max chip (16-core CPU, 40-core GPU)\n16.2-inch Liquid Retina XDR display\nUp to 22 hours battery life\nAdvanced thermal system\nStudio-quality mics",
                "Special financing: Pay in 12 months at 0% interest\nFree engraving available",3.9f
        ));

        items.add(new Item(
                "MacBook Air 15-inch M2 (Starlight, 512 GB) (16 GB RAM)",
                "₹1,39,900",
                R.drawable.mac11,
                "Apple M2 chip with 8-core CPU\n15.3-inch Liquid Retina display\nUp to 18 hours battery life\nSix-speaker sound system\nMagSafe charging",
                "Instant ₹7,000 discount for HDFC card users\nFree Magic Mouse worth ₹8,900",4.7f
        ));

        items.add(new Item(
                "MacBook Pro 13-inch M2 (Space Gray, 512 GB) (16 GB RAM)",
                "₹1,39,900",
                R.drawable.mac1,
                "Apple M2 chip (8-core CPU, 10-core GPU)\n13.3-inch Retina display\nTouch Bar\nUp to 20 hours battery life\nActive cooling system",
                "Save ₹10,000 with education discount\nFree 3-month Adobe Creative Cloud subscription",4.5f
        ));

        items.add(new Item(
                "MacBook Air M1 (Gold, 512 GB) (16 GB RAM)",
                "₹1,09,990",
                R.drawable.mac2,
                "Apple M1 chip with 8-core CPU\n13.3-inch Retina display\nUp to 18 hours battery life\nFanless design\nBacklit Magic Keyboard",
                "Limited time: Free Apple TV+ for 6 months\nExtra 10% off for corporate buyers",4.3f
        ));

        items.add(new Item(
                "i phone pluss",
                "₹2,49,900",
                R.drawable.macmaca,
                "Apple M2 Pro chip (12-core CPU, 19-core GPU)\n14.2-inch Liquid Retina XDR display\nProMotion 120Hz\nUp to 17 hours battery life\nHDMI & SD card slot",
                "Business special: Save ₹15,000 on bulk orders\nFree 1TB external SSD worth ₹12,000",4f
        ));

        items.add(new Item(
                "xomiaa tv ultra 4k hd",
                "₹1,49,900",
                R.drawable.mac4,
                "Apple M2 chip (8-core CPU, 10-core GPU)\n13.6-inch Liquid Retina display\nUp to 18 hours battery life\nMagSafe charging\n4K video support",
                "Exchange bonus: Get ₹12,000 extra for old MacBooks\nFree 2-year extended warranty",3.7f
        ));







    }

    private void filterItems(String searchText) {
        filteredItems.clear();


        if (searchText.isEmpty()) {
            filteredItems.addAll(items);
        } else {
            for (Item item : items) {
                if (!item.getName().toLowerCase().contains(searchText)) {
                    filteredItems.add(item);
                }
            }
        }




        adapter.updateItems(filteredItems);


        if (filteredItems.isEmpty() && !searchText.isEmpty()) {
            Toast.makeText(this, "No products found matching your search", Toast.LENGTH_SHORT).show();
        }
    }
}
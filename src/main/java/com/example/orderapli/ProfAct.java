package com.example.orderapli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile2_activity);

        // Initialize views
        CircleImageView profileImage = findViewById(R.id.profileImage);
        TextView userName = findViewById(R.id.userName);
        TextView userPhone = findViewById(R.id.userPhone);


        // Get the intent that started this activity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username_key");
        User loggedInUser = (User) intent.getSerializableExtra("user_object");

        // Set welcome message with username
        if (username != null && !username.isEmpty()) {
            userName.setText("Hello " + username + "!\nWelcome back");
        } else {
            userName.setText("Hello User!\nWelcome back");
        }

        // Initialize option layouts
        LinearLayout editProfileOption = findViewById(R.id.editProfileOption);
        LinearLayout settingsOption = findViewById(R.id.settingsOption);
        LinearLayout helpOption = findViewById(R.id.helpOption);
        LinearLayout changePasswordOption = findViewById(R.id.changePasswordOption);
        LinearLayout logoutOption = findViewById(R.id.logoutOption);
        LinearLayout takeorders = findViewById(R.id.order_id);

        takeorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfAct.this, MainActivity1.class);
                startActivity(intent);
            }
        });

        // Set click listeners for options
        editProfileOption.setOnClickListener(v -> {
            // Handle edit profile click
        });

        settingsOption.setOnClickListener(v -> {
            // Handle settings click
        });

        helpOption.setOnClickListener(v -> {
            // Handle help click
        });

        changePasswordOption.setOnClickListener(v -> {
            // Handle change password click
        });

        logoutOption.setOnClickListener(v -> {
            // Handle logout click
        });
    }
}
package com.example.orderapli;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserProf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView editProfile = findViewById(R.id.editProfile);
        Button btnUpdatePassword = findViewById(R.id.btnUpdatePassword);
        ImageView btnLogout = findViewById(R.id.btnLogout);

        //




        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserProf.this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserProf.this, "Password Updated", Toast.LENGTH_SHORT).show();
            }
        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserProf.this, "Logging Out...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
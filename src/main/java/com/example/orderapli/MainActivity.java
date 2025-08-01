package com.example.orderapli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                // Validation checks
                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

//
//                if (pass.matches(".*\\d.*")) {
//                    Toast.makeText(MainActivity.this, "Password should not contain numbers", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                // Check if password matches username (case-insensitive)
                if (pass.equals(".*\\d.*")) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this, "Password must match the username", Toast.LENGTH_SHORT).show();

                    return;
                }

                // If all validations pass
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Log.d("button","clicked");


                // Create User object
                User loggedInUser = new User(user, pass);

                // Navigate to Profile Activity
                Intent intent = new Intent(MainActivity.this, ProfAct.class);

                // Pass data both ways for demonstration
                intent.putExtra("username_key", user); // Direct value
                intent.putExtra("user_object", loggedInUser); // Serialized object

                startActivity(intent);
            }
        });
    }
}
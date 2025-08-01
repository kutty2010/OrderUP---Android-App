package com.example.orderapli;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Demo extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity);

        Button btnm, btnd, btne, btns;
        btnm = findViewById(R.id.btncall);
        btnd = findViewById(R.id.dailButton);
        btne = findViewById(R.id.btnemail);
        btns = findViewById(R.id.btnshare);

        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inm = new Intent(Intent.ACTION_SENDTO);
                inm.setData(Uri.parse("smsto:" + Uri.encode("569456122512")));
                inm.putExtra("sms_body", "please pick my call");// Replace with the actual phone number
                startActivity(inm);// Replace with the actual phone number
            }
        });

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ind = new Intent(Intent.ACTION_DIAL);
                ind.setData(Uri.parse("tel:1234567890")); // Replace with the actual phone number
                startActivity(ind);
            }
        });

        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ine = new Intent(Intent.ACTION_SEND);
                ine.setType("message/rfc822");
                ine.putExtra(Intent.EXTRA_EMAIL, new String[]{"aaekarthik@gmail.com", "karmee56@gmail.com"}); // Replace with the actual email addresses
                ine.putExtra(Intent.EXTRA_SUBJECT, "issue resolution");
                ine.putExtra(Intent.EXTRA_TEXT, "Please resolve my issue as soon as possible");
                startActivity(Intent.createChooser(ine, "email via"));
            }

        });

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ins = new Intent(Intent.ACTION_SEND);
                ins.setType("text/plain");
                ins.putExtra(Intent.EXTRA_TEXT, "This is a demo message to share");
                startActivity(Intent.createChooser(ins, "Share via"));
            }
        });
    }
}

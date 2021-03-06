package com.example.motoserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    private Button quickBookBtn;
    ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        quickBookBtn = (Button)findViewById(R.id.quickBookingBtn);

        quickBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Description.this,BikeDetails.class);
                startActivity(intent);
            }
        });

        ImageView menu = findViewById(R.id.menuIconDescription);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Description.this,MenuActivity.class));
            }
        });
    }
}
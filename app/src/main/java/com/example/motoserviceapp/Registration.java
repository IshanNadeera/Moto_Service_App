package com.example.motoserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class Registration extends AppCompatActivity {

    EditText name,Email,phone,userName,Password,date;
    Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText)findViewById(R.id.NameInput);
        Email = (EditText)findViewById(R.id.EmailInput);
        phone = (EditText)findViewById(R.id.InputPhone);
        userName = (EditText)findViewById(R.id.userNameInput);
        Password = (EditText)findViewById(R.id.passwordInput);
        buttonSave = (Button) findViewById(R.id.RegistrationBtn);


        Button btn = findViewById(R.id.RegistrationSignInBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this,LogIn.class));
            }
        });



    }
}
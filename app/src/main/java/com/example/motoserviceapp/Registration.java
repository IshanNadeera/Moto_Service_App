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

    private TextView Name,Email,phone,userName,Password;
    private EditText NameInput,EmailInput,InputPhone,userNameInput,passwordInput;

    private FirebaseAuth mAuth;
    private Object Registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button btn = findViewById(R.id.RegistrationSignInBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this,LogIn.class));
            }
        });



    }
}
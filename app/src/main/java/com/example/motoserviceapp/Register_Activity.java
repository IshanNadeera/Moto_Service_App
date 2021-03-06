package com.example.motoserviceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Register_Activity extends AppCompatActivity {

    private EditText mEmail,mPass;
    private Button regBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = (EditText)findViewById(R.id.RegEmailEditText);
        mPass = (EditText)findViewById(R.id.RegPasswordEditText);
        regBtn = (Button)findViewById(R.id.registerBtn);

        mAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        TextView btn = findViewById(R.id.signInText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_Activity.this,Login_Activity.class));
            }
        });
    }

    private void createUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                new SweetAlertDialog(Register_Activity.this,SweetAlertDialog.SUCCESS_TYPE)
                                        .setTitleText("Message")
                                        .setContentText("Account Created")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                Intent intent = new Intent(Register_Activity.this,Registration_Details.class);
                                                startActivity(intent);

                                            }
                                        })
                                        .show();
                            }
                        })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                new SweetAlertDialog(Register_Activity.this,SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Message")
                                        .setContentText("Registration Error")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                Intent intent = new Intent(Register_Activity.this,Register_Activity.class);
                                                startActivity(intent);

                                            }
                                        })
                                        .show();
                            }
                        });
            }
            else{
                mPass.setError("Empty Fields Not Allowed");
            }
        }
        else if(email.isEmpty()){
            mEmail.setError("Empty Fields Not Allowed");
        }
        else{
            mEmail.setError("Please Enter Valid Email");
        }

    }
}
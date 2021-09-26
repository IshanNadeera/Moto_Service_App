package com.example.motoserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MakeBooking extends AppCompatActivity {

    EditText bikeNo,ownerName,ownerNic,phone,serviceType,other;
    Button bookingBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_booking);
        bikeNo = (EditText) findViewById(R.id.bikeNo);
        ownerName= (EditText) findViewById(R.id.ownerName);
        ownerNic = (EditText) findViewById(R.id.ownerNic);
        phone = (EditText) findViewById(R.id.phone);
        serviceType = (EditText) findViewById(R.id.serviceType);
        other = (EditText) findViewById(R.id.other);
        bookingBtnSave = (Button) findViewById(R.id.bookingBtnSave );

        bookingBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertBookingData();
            }

        });
    }

    private void insertBookingData() {

        Map<String, Object> map = new HashMap<>();
        map.put("bikeNo", bikeNo.getText().toString());
        map.put("ownerName", ownerName.getText().toString());
        map.put("ownerNic", ownerNic.getText().toString());
        map.put("phone", phone.getText().toString());
        map.put("serviceType", serviceType.getText().toString());
        map.put("other", other.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("booking_details").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        new SweetAlertDialog(MakeBooking.this,SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Message")
                                .setContentText("Data Inserted Successfully")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(MakeBooking.this,Service_Details_Tab.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure( Exception e) {
                        new SweetAlertDialog(MakeBooking.this,SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Message")
                                .setContentText("Error While Insertion")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(MakeBooking.this,MakeBooking.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();
                    }
                });
    }

}
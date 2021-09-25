package com.example.motoserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class View_Approved_Bookings extends AppCompatActivity {

    RecyclerView recyclerView;
    ApprovedBookingAdapter approvedBookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_approved_bookings);

        recyclerView = (RecyclerView)findViewById(R.id.approvedBookingsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ApprovedBookingModel> options =
                new FirebaseRecyclerOptions.Builder<ApprovedBookingModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("approved_services"), ApprovedBookingModel.class)
                        .build();

        approvedBookingAdapter = new ApprovedBookingAdapter(options);
        recyclerView.setAdapter(approvedBookingAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        approvedBookingAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        approvedBookingAdapter.stopListening();
    }
}
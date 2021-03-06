package com.example.motoserviceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTab1 extends Fragment {

    RecyclerView recyclerView;
    BikeAdapter bikeAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTab1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTab1 newInstance(String param1, String param2) {
        FragmentTab1 fragment = new FragmentTab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.bikeRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        FirebaseRecyclerOptions<BikeModel> options =
                new FirebaseRecyclerOptions.Builder<BikeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("bike_details"), BikeModel.class)
                        .build();

        bikeAdapter = new BikeAdapter(options);
        recyclerView.setAdapter(bikeAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        bikeAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        bikeAdapter.stopListening();
    }

}
package com.example.motoserviceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ApprovedBookingAdapter extends FirebaseRecyclerAdapter<ApprovedBookingModel,ApprovedBookingAdapter.myApprovedViewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ApprovedBookingAdapter(@NonNull FirebaseRecyclerOptions<ApprovedBookingModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myApprovedViewholder holder, int position, @NonNull ApprovedBookingModel model) {
        holder.bikeNo.setText(model.BikeNo);
        holder.bookId.setText(model.BookingId);
    }

    @NonNull
    @Override
    public myApprovedViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.approved_items,parent,false);
        return new myApprovedViewholder(view);
    }

    class myApprovedViewholder extends RecyclerView.ViewHolder{

        TextView bikeNo,bookId;

        public myApprovedViewholder(@NonNull View itemView){
            super(itemView);

            bikeNo = (TextView)itemView.findViewById(R.id.approvedBikeNoText);
            bookId = (TextView)itemView.findViewById(R.id.approvedBookingIdText);
        }
    }
}

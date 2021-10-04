package com.example.motoserviceapp;

public class ProgressModel {

    String BikeNo,BookingId;

    ProgressModel(){

    }

    public ProgressModel(String bikeNo, String bookingId) {
        this.BikeNo = bikeNo;
        this.BookingId = bookingId;
    }

    public String getBikeNo() {
        return BikeNo;
    }

    public void setBikeNo(String bikeNo) {
        BikeNo = bikeNo;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
}


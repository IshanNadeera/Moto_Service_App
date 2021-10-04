package com.example.motoserviceapp;

public class ApprovedBookingModel {

    String BikeNo,BookingId;

    ApprovedBookingModel(){

    }

    public ApprovedBookingModel(String bikeNo, String bookingId) {
        BikeNo = bikeNo;
        BookingId = bookingId;
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

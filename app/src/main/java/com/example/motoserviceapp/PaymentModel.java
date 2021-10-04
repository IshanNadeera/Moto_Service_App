package com.example.motoserviceapp;

public class PaymentModel {

    String BikeNo,BookingId,Date,OwnerName,FullAmount;
    PaymentModel(){

    }

    public PaymentModel(String bikeNo, String bookingId, String date, String ownerName, String fullAmount) {
        BikeNo = bikeNo;
        BookingId = bookingId;
        Date = date;
        OwnerName = ownerName;
        FullAmount = fullAmount;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getFullAmount() {
        return FullAmount;
    }

    public void setFullAmount(String fullAmount) {
        FullAmount = fullAmount;
    }
}
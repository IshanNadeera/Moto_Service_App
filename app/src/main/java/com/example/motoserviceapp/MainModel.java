package com.example.motoserviceapp;

public class MainModel {

    String BikeNo,BookingId,Date,Problem,TotalCost;

    MainModel(){

    }

    public MainModel(String bikeNo, String bookingId, String date, String problem, String totalCost) {
        BikeNo = bikeNo;
        BookingId = bookingId;
        Date = date;
        Problem = problem;
        TotalCost = totalCost;

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

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public String getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(String totalCost) {
        TotalCost = totalCost;
    }

}
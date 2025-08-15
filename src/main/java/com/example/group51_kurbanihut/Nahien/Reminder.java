package com.example.group51_kurbanihut.Nahien;

import java.util.ArrayList;

public class Reminder {
    private String buyerId,status;

    public static ArrayList<Reminder> reminderList= new ArrayList<>();

    public Reminder(String buyerId, String status) {
        this.buyerId = buyerId;
        this.status = status;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "buyerId='" + buyerId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

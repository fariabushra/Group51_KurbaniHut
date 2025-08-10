package com.example.group51_kurbanihut.Redeta;

import java.time.LocalDate;
import java.util.ArrayList;

public class ViewDeliveryModel {
    private String name,location,deliveryStatus,cattleID;
    private LocalDate date;

    public static ArrayList<ViewDeliveryModel> DeliveryList = new ArrayList<>();
    public ViewDeliveryModel() {
    }

    public ViewDeliveryModel(String name, String location, String deliveryStatus, String cattleID, LocalDate date) {
        this.name = name;
        this.location = location;
        this.deliveryStatus = deliveryStatus;
        this.cattleID = cattleID;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getCattleID() {
        return cattleID;
    }

    public void setCattleID(String cattleID) {
        this.cattleID = cattleID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ViewDeliveryModel{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", cattleID='" + cattleID + '\'' +
                ", date=" + date +
                '}';
    }
}

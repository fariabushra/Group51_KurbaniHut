package com.example.group51_kurbanihut.Redeta;

import java.time.LocalDate;

public class SendAlertModel {
    private String name,location,alertType;
    private LocalDate date;

    public SendAlertModel() {
    }

    public SendAlertModel(String name, String location, String alertType, LocalDate date) {
        this.name = name;
        this.location = location;
        this.alertType = alertType;
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

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SendAlertModel{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", alertType='" + alertType + '\'' +
                ", date=" + date +
                '}';
    }
}

package com.example.group51_kurbanihut.Redeta;

import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReportModel {
        private String location,incidentType,description,time;


    public IncidentReportModel(String location, String time, String description, String incidentType) {
        this.location = location;
        this.time = time;
        this.description = description;
        this.incidentType = incidentType;
    }

    public static ArrayList<ViewDeliveryModel> IncidentList = new ArrayList<>();
    public IncidentReportModel() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "IncidentReportModel{" +
                "location='" + location + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}


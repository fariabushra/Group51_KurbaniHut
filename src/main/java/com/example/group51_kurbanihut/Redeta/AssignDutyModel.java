package com.example.group51_kurbanihut.Redeta;

import java.util.ArrayList;

public class AssignDutyModel {
    private String officerName;
    private String assignedZone;

    public static ArrayList<AssignDutyModel> AssignedDutyList = new ArrayList<>();

    public AssignDutyModel() {
    }

    public AssignDutyModel(String officerName, String assignedZone) {
        this.officerName = officerName;
        this.assignedZone = assignedZone;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getAssignedZone() {
        return assignedZone;
    }

    public void setAssignedZone(String assignedZone) {
        this.assignedZone = assignedZone;
    }

    @Override
    public String toString() {
        return "AssignDutyModel{" +
                "officerName='" + officerName + '\'' +
                ", assignedZone='" + assignedZone + '\'' +
                '}';
    }
}

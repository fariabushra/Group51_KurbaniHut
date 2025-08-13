package com.example.group51_kurbanihut.Redeta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccessLogsModel {

    private String name;
    private String entryTime;
    private String location;

    public AccessLogsModel() {
    }

    public AccessLogsModel(String name, String location, String entryTime) {
        this.name = name;
        this.location = location;
        this.entryTime = entryTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AccessLogsModel{" +
                "name='" + name + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}


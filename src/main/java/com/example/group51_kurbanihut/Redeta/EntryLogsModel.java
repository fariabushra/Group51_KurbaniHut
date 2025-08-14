package com.example.group51_kurbanihut.Redeta;

import java.time.LocalDate;

public class EntryLogsModel {
    private String name, role;
    private LocalDate date;

    public EntryLogsModel(String name, String role, LocalDate date) {
        this.name = name;
        this.role = role;
        this.date = date;
    }

    public EntryLogsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EntryLogsModel{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", date=" + date +
                '}';
    }
}
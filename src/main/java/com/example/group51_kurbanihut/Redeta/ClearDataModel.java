package com.example.group51_kurbanihut.Redeta;

public class ClearDataModel {
    private String name,id,role;

    public ClearDataModel() {
    }

    public ClearDataModel(String name, String id, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ClearDataModel{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

package com.example.group51_kurbanihut.Redeta;

public class UpdateDeliveryStatusModel {
    private String name, status;

    public UpdateDeliveryStatusModel(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public UpdateDeliveryStatusModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateDeliveryStatusModel{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
package com.example.group51_kurbanihut.Redeta;

public class ContactCustomerModel {
    private String name,message;

    public ContactCustomerModel(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public ContactCustomerModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactCustomerModel{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

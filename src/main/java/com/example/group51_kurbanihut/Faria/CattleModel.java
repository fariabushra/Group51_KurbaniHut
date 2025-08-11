package com.example.group51_kurbanihut.Faria;

import java.util.ArrayList;

public class CattleModel {
    private String cattleID, age, colour, weight, height, healthStatus;
    private double price;
    public static ArrayList<CattleModel> cattleList = new ArrayList<> ();


    public CattleModel() {
    }

    public CattleModel(String cattleID, String age, String colour, String weight, String height, double price, String healthStatus) {
        this.cattleID = cattleID;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
        this.height = height;
        this.price = price;
        this.healthStatus = healthStatus;
    }

    public String getCattleID() {
        return cattleID;
    }

    public void setCattleID(String cattleID) {
        this.cattleID = cattleID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "CattleModel{" +
                "cattleID='" + cattleID + '\'' +
                ", age='" + age + '\'' +
                ", colour='" + colour + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", price='" + price + '\'' +
                ", healthStatus='" + healthStatus + '\'' +
                '}';
    }
}

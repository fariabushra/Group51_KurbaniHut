package com.example.group51_kurbanihut.Nahien;

import java.util.ArrayList;

import static com.example.group51_kurbanihut.Faria.CattleModel.cattleList;

public class Cattle {
    private String id;
    private String name;
    private String type;
    private double price;
    private double weight;
    private int age;
    private String status;

    private static ArrayList<Cattle> cattleList = new ArrayList<Cattle>();

    public Cattle(String id, String name, String type, double price, double weight, int age, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.age = age;
        this.status = status;

        cattleList.add(this);
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cattle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}

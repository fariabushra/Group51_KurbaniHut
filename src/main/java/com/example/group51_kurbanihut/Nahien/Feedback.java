package com.example.group51_kurbanihut.Nahien;

import java.util.ArrayList;

public class Feedback {
    private String id;
    private String massage;

    public static ArrayList<Feedback> feedbackList = new ArrayList<>();
    public static ArrayList<Feedback> solveList = new ArrayList<>();

    public Feedback(String id, String massage) {
        this.id = id;
        this.massage = massage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", massage='" + massage + '\'' +
                '}';
    }
}


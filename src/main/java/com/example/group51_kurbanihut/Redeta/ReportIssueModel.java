package com.example.group51_kurbanihut.Redeta;

public class ReportIssueModel {
    private String name, issue, cattleID;

    public ReportIssueModel() {
    }

    public ReportIssueModel(String name, String issue, String cattleID) {
        this.name = name;
        this.issue = issue;
        this.cattleID = cattleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getCattleID() {
        return cattleID;
    }

    public void setCattleID(String cattleID) {
        this.cattleID = cattleID;
    }

    @Override
    public String toString() {
        return "ReportIssueModel{" +
                "name='" + name + '\'' +
                ", issue='" + issue + '\'' +
                ", cattleID='" + cattleID + '\'' +
                '}';
    }
}
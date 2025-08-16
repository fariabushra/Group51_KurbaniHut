package com.example.group51_kurbanihut.Redeta;

public class UserPermissionModel {
    private String name,accessLevel;

    public UserPermissionModel() {
    }

    public UserPermissionModel(String name, String accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "UserPermissionModel{" +
                "name='" + name + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}

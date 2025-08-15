package com.example.group51_kurbanihut.Redeta;

public class UserAccessPermission {
    private String name,accessLevel;

    public UserAccessPermission() {
    }

    public UserAccessPermission(String name, String accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserAccessPermission{" +
                "name='" + name + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}

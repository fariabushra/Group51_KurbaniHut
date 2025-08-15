package com.example.group51_kurbanihut.Redeta;

public class ViewInstructionModel {
    private String name,address,instruction;

    public ViewInstructionModel() {
    }

    public ViewInstructionModel(String name, String address, String instruction) {
        this.name = name;
        this.address = address;
        this.instruction = instruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "ViewInstructionModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}

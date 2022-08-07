package com.example.sailerapplication;


public class Boat {
    private int id;
    private String name;
    private String Status;
    private String owner;
    private int length;
    private String owner_name;


    public Boat(int id , String name , String Status , String owner, int length ,  String owner_name) {
        this.id = id;
        this.name = name;
        this.Status = Status;
        this.owner = owner;
        this.length = length;
        this.owner_name = owner_name;
    }

    /**
     * Getters and Setters of Boat class
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
}

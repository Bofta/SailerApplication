package com.example.sailerapplication;


public class Boat {
    private int id;
    private String name;
    private String Status;
    private String owner;

    /**
     *  False by default
     *  True if paid the appropriate value of check in period in the SGP(Servizio_Gestione_Pagamenti).
     */
    public boolean Quota_imbarcazione_boat_status = false;


    public Boat(int id , String name , String Status , String owner) {
        this.id = id;
        this.name = name;
        this.Status = Status;
        this.owner = owner;
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
}

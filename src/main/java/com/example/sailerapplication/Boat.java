package com.example.sailerapplication;


public class Boat {
    private int id;
    private String mbname;

    /**
     *  False by default
     *  True if paid the appropriate value of check in period in the SGP(Servizio_Gestione_Pagamenti).
     */
    public boolean Quota_imbarcazione_boat_status = false;


    public Boat(int id , String mbname) {
        this.id = id;
        this.mbname = mbname;
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


    public String getMbname() {
        return mbname;
    }

    public void setMbname(String mbname) {
        this.mbname = mbname;
    }
}

package SAILCLUB;


public class Boat {
    public int Boat_ID;
    public String Boat_name;
    private Socio Boat_owner;
    // False by default
    // True if payed the appropriate value of imbarcation in the SGP(Servizio_Gestione_Pagamenti).
    public boolean Quota_imbarcazione_boat_Status = false;


    // Default constructor with no paramaters

    public Boat(){
        Boat_ID = Integer.parseInt(null);
        Boat_name = "";
        Boat_owner = null;
    }


    // Constructor with paramaters

    public Boat(int ID , String Boat_name , Socio Boat_owner){
        this.Boat_ID = ID;
        this.Boat_name = Boat_name;
        this.Boat_owner = Boat_owner;
    }

    // Getters and Setters of Boat class

    public String getBoat_Name(){
        return Boat_name;
    }

    public void setBoat_Name(String Newname) {
        this.Boat_name = Newname;
    }

    public int getBoat_ID(){
        return Boat_ID;
    }

    public void setBoat_ID(int NewBoatID) {
        this.Boat_ID = NewBoatID;
    }

    public Socio getBoat_owner() {
        return Boat_owner;
    }

    public void setBoat_owner(Socio boat_owner) {
        this.Boat_owner = boat_owner;
    }
}

package SAILCLUB;

import java.util.List;

/**
 *    Personale del circolo ovvero admins che rappresentano l'autorità amministrativa del circolo velico.
 *    Collegando al server con le loro credenziali possono organizzare e gestire le informazioni sui soci, sulle imbarcazioni e sulle gare.
 */

public class Personale_Circolo {
    // Class attributes "Username" and "Password" visibility field set to private due to "Sensible information" that can compromise user data privacy.
    public String name;
    public String surname;
    private String Personale_Circolo_Username;
    private String Personale_Circolo_Password;


    public List<Boat> boats;
    public List<Socio> socios;
    public List<Personale_Circolo> admins;
    public List<Gara> Gare;
    Personale_Circolo Admin;
    public int socioNumber;
    public int boatNumber;

    // Default constructor with no parameters

    public Personale_Circolo(){
        name = "";
        surname = "";
        Personale_Circolo_Username = "default";
        Personale_Circolo_Username = "default";
    }



    // Constructor with parameters

    public Personale_Circolo(String name , String surname , String Personale_Circolo_Username , String Personale_Circolo_Password) {
        this.name = name;
        this.surname = surname;
        this.Personale_Circolo_Username = Personale_Circolo_Username;
        this.Personale_Circolo_Password = Personale_Circolo_Password;

    }

    // Getters and Setters of Personale_Circolo class

    public String getName(){
        return name;
    }

    public void setName(String Newname) {
        this.name = Newname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Newsurname){
        this.surname = Newsurname;
    }

    public String getPersonale_Circolo_Username() {
        return Personale_Circolo_Username;
    }

    public void setPersonale_Circolo_Username(String NewPersonale_Circolo_Username){
        this.Personale_Circolo_Username = NewPersonale_Circolo_Username;
    }

    public String getPersonale_Circolo_Password() {
        return Personale_Circolo_Password;
    }

    public void setPersonale_Circolo_Password(String Personale_Circolo_Password) {
        Personale_Circolo_Password = Personale_Circolo_Password;
    }


    /**
     * Aggiunge un Socio alla lista di socios. L'ID attribuito a ciascun socio è progressivo (socioNumber+1), e ciò è gestito dal listener del submit button nella classe GUI.java.
     *
     * @param admin : il amministratore da che gestirà l'agguinta del socio alla lista dei soci del club.
     * @param socio : il socio da aggiungere
     */
    public final void AddSocio(Personale_Circolo admin, Socio socio){
        if (admin.equals(Admin)) {
            boolean usedUsername = false;
            for (int i = 0; i < socios.size(); i++) {
                if (socios.get(i).getSocio_Username().equals(socio.getSocio_Username())) {
                    usedUsername = true;
                    System.out.println("Username "+ socio.getSocio_Username() + " already exists in the list of socios");
                    break;
                }
            }

            if(!usedUsername){
                socios.add(socioNumber, socio);
                socioNumber++;
                System.out.println("User "+ socio.getSocio_Username() + " has been added successfully to the list of socios by admin : " + admin.name + " " + admin.surname);
            }
        }
    }


    /**
     * Toglie un Socio dalla lista di soci da parte di un admin(Personale_circolo).
     *
     * @param admin : il amministratore da che gestirà la rimozione del socio dalla lista dei soci del club.
     * @param socio : il socio da aggiungere
     */
    public final void RemoveSocio(Personale_Circolo admin, Socio socio){
        if (admin.equals(Admin)) {
            boolean usedUsername = false;
            for (int i = 0; i < socios.size(); i++) {
                if (socios.get(i).getSocio_Username().equals(socio.getSocio_Username())) {
                    usedUsername = true;
                    socios.remove(i);
                    System.out.println("User "+ socio.getSocio_Username() + " has been removed successfully from the list of soci by admin : " + admin.name + " " + admin.surname);
                    break;
                }
            }

            if(!usedUsername){
                System.out.println("User "+ socio.getSocio_Username() + " dosen't exist in the list of soci.");
            }
        }
    }


    /**
     * Funzione chiamabile da Admin per la rimozione di una barca presente nel "database", e quindi nella lista delle barce del club . Il controllo sullo username 'Admin' è a carico di GUI.java
     *
     * @param admin : il amministratore/Personale del circolo che aggiungerà la barca
     * @param boat : il boat/barca da aggiungere
     */
    public final void AddBoat(Personale_Circolo admin , Boat boat){
        if (admin.equals(Admin)) {
            boolean existingBoat = false;
            for(int i =0 ; i < boats.size(); i++){
                if(boats.get(i).Boat_ID == (boat.Boat_ID) && boats.get(i).Boat_name.equals(boat.Boat_name) && boats.get(i).equals(boat.getBoat_owner())){
                    existingBoat = true;
                    System.out.println("Boat "+ boat.Boat_name + " already exists the list of boats.");
                    break;
                }
            }
            if(!existingBoat){
                boats.add(boatNumber, boat);
                boatNumber++;
                System.out.println("Boat "+ boat.Boat_name + " has been added successfully to the list of club boats by admin : " + admin.name + " " + admin.surname);
            }
        }
    }


    /**
     * Toglie un Socio dalla lista di soci da parte di un admin(Personale_circolo).
     *
     * @param admin : il amministratore da che gestirà la rimozione del socio dalla lista dei soci del club.
     * @param boat : la barca da togliere della lista
     */
    public final void RemoveBoat(Personale_Circolo admin, Boat boat){
        if (admin.equals(Admin)) {
            boolean ExistentBoat = false;
            for (int i = 0; i < boats.size(); i++) {
                if (boats.get(i).Boat_name.equals(boat.Boat_name)) {
                    ExistentBoat = true;
                    boats.remove(i);
                    System.out.println("Boat "+ boat.Boat_name + " has been removed successfully from the list of boats of the club by admin : " + admin.name + " " + admin.surname);
                    break;
                }
            }

            if(!ExistentBoat){
                System.out.println("Boat "+ boat.Boat_name + " doesn't exist in the list of boats of the club.");
            }
        }
    }


    /**
     * Utilizzata per debug.
     * @deprecated
     */
    public final void PrintSociosInfo(Personale_Circolo admin){
        if (admin.equals(Admin)) {
            System.out.println("Sail club members : \n");
            for(int i = 0; i < socioNumber; i++){
                System.out.println(socios.get(i).name);
            }
        }
    }


    /**
     * Utilizzata per debug.
     * @deprecated
     */
    public final void PrintBoatsInfo(Personale_Circolo admin){
        if (admin.equals(Admin)) {
            System.out.println("Sail club boats : \n");
            for(int i = 0; i < boatNumber; i++){
                System.out.println("ID : " + boats.get(i).getBoat_ID() + " NAME : " +  boats.get(i).getBoat_Name());
            }
        }
    }


    /**
     * Getter per il numero di membri nel club. Utile per la creazione dell'ID progressivo
     *
     * @return Il numero di membri registrati
     */
    public final int getSociosNumber(){
        return socios.size();
    }

    /**
     * Getter per il numero di admin del club.
     *
     * @return Il numero di admin registrati
     */

    public final int getAdminsNumber(){
        return admins.size();
    }

    /**
     * Getter per il numero di barche nel club
     *
     */
    public final int getBoatsNumber() {
        return boats.size();
    }


    /**
     * Funzione che valida o nega il login di un utente
     * Se i credenziali del utente esistono per davvero ovvero
     * se username e password coincidono con una coppia nel "database" o no
     *
     * @param client : il cliente in cui si accaderà il processo di verificazione .
     *
     */

    /**
     * Funzione che valida o nega il login di un admin(personale_circolo)
     * Se i credenziali del admin esistono per davvero ovvero
     * se username e password coincidono con una coppia nel "database" o no
     *
     * @param admin : il cliente in cui si accaderà il processo di verificazione.
     *
     */

    public final void Admin_LoginCheck(Personale_Circolo admin){
        System.out.println("Initiating check ...");
        for(int i = 0; i < getAdminsNumber(); i++){
            if(admins.get(i).getPersonale_Circolo_Password().equals(admin.getPersonale_Circolo_Username()) && admins.get(i).getPersonale_Circolo_Password().equals(admin.getPersonale_Circolo_Password()))
                System.out.println("Check Output -> Valid :" + admins.get(i).getPersonale_Circolo_Username()   +  " exist in the club admins database .");
        }
    }


    public final void Socio_LoginCheck(Socio client){
        System.out.println("Initiating check ...");
        for(int i = 0; i < getSociosNumber(); i++){
            if(socios.get(i).getSocio_Username().equals(client.getSocio_Username()) && socios.get(i).getSocio_Password().equals(client.getSocio_Password()))
                System.out.println("Check Output -> Valid :" + socios.get(i).getSocio_Username()   +  " exist in the club members database .");
        }
    }


}

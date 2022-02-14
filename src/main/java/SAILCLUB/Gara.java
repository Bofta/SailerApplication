package SAILCLUB;

import java.util.*;

public class Gara {
    public String name;
    public int Prize;
    final public double tasse_iscrizione_gara=100;
    public ArrayList<Socio> List_Of_Participants = new ArrayList<>();
    public ArrayList<Boat> List_Of_Participants_Boats = new ArrayList<>();


    //  Constructor with parameters for Gara(Competition)

    public Gara(String name ,  int Prize) {
        this.name = name;
        this.Prize = Prize;
    }

    // Una funzione che permette di iscrivere qualunque socio che ha intenzione di competere alla Gara che viene chiamata nei parametri.
    public void SignUp_Gara(Gara this, Socio participant, Boat participant_boat){
        System.out.println("Do you want to participate in this " + this + "Gara? Y/n");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        if (str.equals("y")) {
            // If the boat is really a property of the participant -> a statement to verify if the socio is really the owner of the boat
            if (participant_boat.getBoat_owner().equals(participant)) {
                System.out.println("Your current credit card balance :" + participant.getCarta_Credito_Socio()+"€");
                System.out.println("Credit card balance after paying inscription fees " + participant.setCarta_Credito_Socio(participant.getCarta_Credito_Socio() - tasse_iscrizione_gara));
                List_Of_Participants_Boats.add(participant_boat);
                List_Of_Participants.add(participant);
                System.out.println(participant_boat.getBoat_Name() + " ship of " + participant.name + " " + participant.surname + " has been added to the list of participant boats of the "+ this.name + " competition.");
                System.out.println("Your have completed successfully your inscription , Best of luck!");
            }
        }

        else{
            System.out.println("You have chosen not to participate in this competitions \nBest of luck in the upcoming events.");
        }
    }

}

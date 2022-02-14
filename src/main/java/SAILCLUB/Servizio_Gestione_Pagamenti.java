package SAILCLUB;

import java.util.*;

public class Servizio_Gestione_Pagamenti {
    public final int quota_associazione_annuale_club=1000; // quota di associazione che ha una durata annuale fissa => 1000€





    // Funzione che calcola la quota da pagare in base alla lunghezza delle imbarcazioni -> Basta solo inserire la durata della imbarcazione e restituisce il valore totale da pagare .
    public void Payment_Quota_Imbarcazioni(double durata_imbarcazione, Boat local_boat , Socio client) {
        if (local_boat.Quota_imbarcazione_boat_Status ==false) {
            double imbarcation_fee = durata_imbarcazione * 2.7; // 2.7 = 1000 / 365 = 2.7 -> Tassa giornaliera * numeri di giorni = total cost for the period that the ship has been stored .
            System.out.println("Credit card balance = " + client.getCarta_Credito_Socio() +"€");
            System.out.println("Your ship storage cost = " + imbarcation_fee +"€"+ "\nProcced to payment? Y/n?");
            Scanner sc= new Scanner(System.in);
            String user_input= sc.nextLine(); //reads string.
            if (user_input.equals("y")){
                local_boat.Quota_imbarcazione_boat_Status = true;
                System.out.println("Your payment of "+imbarcation_fee + "€ for imbarcation fee of ship " + local_boat.getBoat_Name() + " ID=" + local_boat.getBoat_ID() + " was successful!" );
                System.out.println("New credit card balance after payment= " + client.setCarta_Credito_Socio(client.getCarta_Credito_Socio() - imbarcation_fee) + "€" );
            }
            else if (user_input.equals("n")) {
                local_boat.Quota_imbarcazione_boat_Status = false;
                System.out.println("Imbarcation fee of total = " + imbarcation_fee + "€ for ship "+ local_boat.getBoat_Name() + ", ID = " + local_boat.getBoat_ID() + " is yet to be payed.");
            }

        }
    }

    // Funzione che verifica e fa il pagamento di la quota annuale per il "membership" al sail club se non è gia rinnovato.

    public void Payment_annual_membership(Socio client , Servizio_Gestione_Pagamenti SGP ) {
        System.out.println(client.Quota_Associazione_Annuale_Status);
        if (client.Quota_Associazione_Annuale_Status==false) {
            System.out.print("Your annual membership is out of date!\nProcced to renew it? Y/n?\n");
            Scanner sc= new Scanner(System.in);
            String user_input= sc.nextLine(); //reads string.
            if (user_input.equals("y")){
                System.out.println("Credit card balance = " + client.getCarta_Credito_Socio() +"€");
                System.out.println("New credit card balance after payment = " + client.setCarta_Credito_Socio(client.getCarta_Credito_Socio() - 1000));
                System.out.println("Your sail club membership has been renewed successfully\nWelcome again sailer!");
            }
            else if (user_input.equals("n")) {
                System.out.println(quota_associazione_annuale_club+"€ have to be payed to renew the annual membership and enjoy our club services once again!");
            }
        }
    }

}

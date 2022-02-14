package SAILCLUB;

public class Socio {
    // Class attributes "Username" , "Password" , "Balance" , "Fiscal code" and "Boats_Owned"  visibility field set to private due to "Sensible information" that can compromise user data privacy.

        public String name;
        public String surname;
        private String adress;
        private String fiscal_code;
        private double Carta_Credito_Socio; // The budget of the socio whom which will be able to pay fees , iscriversi alle gare , etc ...
        private int Boats_owned; // numero di imbarcazioni se ci sono piu di 1
        public boolean  Quota_Associazione_Annuale_Status = false; // True if payedd the fixed value of club membership (1000€) in the SGP(Servizio_Gestione_Pagamenti).
        private String Socio_Username;
        private String Socio_Password;


    // Default constructor with no paramaters

        public Socio(){
            name = "";
            surname = "";
            adress = "";
            fiscal_code = "";
            Boats_owned = 0;
            Carta_Credito_Socio = 0;
            Socio_Username = "default";
            Socio_Password = "default";
        }
        // Constructor with paramaters

        public Socio(String name , String surname , String adress , String fiscal_code ,double Carta_Credito_Socio,  int Boats_owned ,String Socio_Username , String Socio_Password) {
            this.name = name;
            this.surname = surname;
            this.adress = adress;
            this.fiscal_code = fiscal_code;
            this.Boats_owned = Boats_owned;
            this.Carta_Credito_Socio = Carta_Credito_Socio;
            this.Socio_Username = Socio_Username;
            this.Socio_Password = Socio_Password;
        }


        // Getters and Setters of Socio class

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

        public String getAdress(){
            return adress;
        }

        public void setAdress(String NewAdress) {
            this.adress = NewAdress;
        }

        public String getFiscal_code(){
            return fiscal_code;
        }

        public void setFiscal_code(String Newfiscal_code){
            this.fiscal_code = Newfiscal_code;
        }

        public int getBoats_owned(){
            return Boats_owned;
        }

        public void setBoats_owned(int Newboatsowned) {
            this.Boats_owned = Newboatsowned;
        }

        public String getSocio_Username(){
            return Socio_Username;
        }

        public String getSocio_Password(){
            return Socio_Password;
        }

        public void setSocio_Password(String NewSocioPassoword) {
            this.Socio_Password = NewSocioPassoword;
        }

        public double getCarta_Credito_Socio() {
            return Carta_Credito_Socio;
        }

        public double setCarta_Credito_Socio(double NewCarta_Credito_Socio) {
                this.Carta_Credito_Socio = NewCarta_Credito_Socio;
            return NewCarta_Credito_Socio;
        }

        // A function that permits the owner to add a boat as his property

        public void AddBoat_As_Proprety(Socio this , Boat boat){
            boat.setBoat_owner(this);
        }

        // A function that permits the owner to remove a boat from his property
        public void RemoveBoat_From_Proprety(Boat boat){
            boat.setBoat_owner(null);
        }


}

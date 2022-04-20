package com.example.sailerapplication;


public class Socio extends Person {

        private String name;
        private String surname;
        private String address;
        private String fiscal_code;
        public Boat[]boats_owned;
        private double CCB; // Acronym for Credit Card Balance.
        public boolean  Quota_Associazione_Annuale_Status = false; // True if paid the fixed value of club membership (1000€) in the SGP(Servizio_Gestione_Pagamenti).


        /**
         *  Default constructor with no parameters
         */



        // Constructor with parameters
        public Socio(String name, String surname, String fiscal_code, String address) {
            this.name = name;
            this.surname = surname;
            this.fiscal_code = fiscal_code;
            this.address = address;
        }



    // Getters and Setters of Socio class

        public String getAddress(){
            return address;
        }

        public void setAddress(String NewAdress) {
            this.address = NewAdress;
        }

        public String getFiscal_code(){
            return fiscal_code;
        }

        public void setFiscal_code(String Newfiscal_code){
            this.fiscal_code = Newfiscal_code;
        }

        public double getCCB() {
            return CCB;
        }

        public double setCCB(double NewCCB) {
                this.CCB = NewCCB;
            return NewCCB;
        }

        public Boat[] getBoats_owned() {
            return boats_owned;
        }

        public void setBoats_owned(Boat[] boats_owned) {
            this.boats_owned = boats_owned;
        }

        /**
         * method that permits the owner to add a boat to his property*
         * @param array
         * @param elementToAppend
         *
         */
        public static Boat[] appendBoat_to_property (Boat[] array, Boat elementToAppend)
        {
            Boat [] newArray = new Boat[array.length+1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = elementToAppend;
            return newArray;
        }

        /**
         * method that permits the owner of the boat to remove it from his property
         * @param array
         * @param elementToDelete
         */
        public static Boat[] popBoat_from_property(Boat[]array, Boat elementToDelete)
        {
            Boat [] newArray = new Boat[array.length-1];
            int j = 0;
            for (int i=0; i<array.length;i++){
                if (!array[i].equals(elementToDelete)){
                    newArray[j] = array[i];
                    j++;
                }
            }
            return newArray;
        }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

package com.example.sailerapplication;

/**
 * Admin is a subclass of person. It has some privileges more than Person.
 *
 *  @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 *  @author      Omar <@studenti.unipr.it>
 *
 */
public class Personale_Circolo extends Person
{
    /**
     * Empty Personale_Circolo Constructor.
     */
    public Personale_Circolo() {
    }

    /**
     * Parametrized Personale_Circolo Constructor.
     */
    public Personale_Circolo(String name, String surname) {
        super(name, surname);
    }

}
package com.example.sailerapplication;


/**
 * Person is in charge of saving a person object with its properties.
 * Each person has a name, a surname, an username and a password.
 *
 * TODO: Fix the bugs
 *
 * @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 * @author      Omar <@studenti.unipr.it>

 */
public class Person
{
    private String name;
    private String surname;


    /**
     * Empty constructor for the object
     *
     */
    public Person() {
    }

    /**
     * This constructor generates a Person object.
     *
     * @param  name     the person name
     * @param  surname  the person surname
     *
     * @return void
     *
     */
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }
    /**
     * This method gets the Person's name.
     *
     * @return String the Person's name.
     *
     */
    public String getName() {
        return this.name;
    }
    /**
     * This method sets the Person's name.
     *
     * @param name for the Person.
     *
     * @return void
     *
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gets the Person's surname.
     *
     * @return String the Person's surname.
     *
     */
    public String getSurname() {
        return this.surname;
    }
    /**
     * This method sets the Person's surname.
     *
     * @param surname for the Person.
     *
     * @return void
     *
     */



    /**
     * This method's return value is a complete description for a Person object.
     *
     * @return String the description
     *
     */
    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", surname='" + getSurname() + "'" +
                "}";
    }
}

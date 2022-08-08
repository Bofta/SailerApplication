package com.example.sailerapplication;


/**
 * Person is in charge of saving a person object with its properties.
 * Each person has a name, a surname, an username and a password.
 *
 * TODO: Fix the bugs
 *
 * @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>

 */
public class Person
{
    private String sname;
    private String surname;
    private String username;
    private String password;


    /**
     * Empty constructor for the object
     *
     */
    public Person() {
    }

    /**
     * This constructor generates a Person object.
     *
     * @param  sname     the person name
     * @param  surname  the person surname
     *
     * @return void
     *
     */
    public Person(String sname, String surname) {
        this.sname = sname;
        this.surname = surname;

    }
    /**
     * This method gets the Person's name.
     *
     * @return String the Person's name.
     *
     */
    public String getName() {
        return this.sname;
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
        this.sname = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

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
     * @param  name     the person name
     * @param  surname  the person surname
     * @param  username    the person username
     * @param  password the person password
     *
     * @return void
     *
     */
    public Person(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
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
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * This method gets the Person's username.
     *
     * @return String the Person's username.
     *
     */
    public String getUsername() {
        return this.username;
    }
    /**
     * This method sets the Person's username.
     *
     * @param username for the Person.
     *
     * @return void
     *
     * @since 1.0
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * This method gets the Person's password.
     *
     * @return String the Person's password.
     *
     * @since 1.0
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * This method sets the Person's password.
     *
     * @param password for the Person.
     *
     * @return void
     *
     * @since 1.0
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method subscribes a Person to an activity.
     * This method is a wrapper for the Club's subscription behavior.
     *
     * @param club              the member's club .
     * @param desiredActivity   the desired member activity in whom wants to subscribe.
     *
     * @return void
     *
     */
    public void subscribeToActivity(Club club, Activity desiredActivity)
    {
        club.subscribeToActivity(this, desiredActivity);
    }
    /**
     * This method deletes a Person to an activity.
     * This method is a wrapper for the Club's unsubscribe method.
     *
     * @param  club					 the club of the member
     * @param  unsubscribingActivity the activity to unsubscribe from
     *
     * @return void
     *
     * @since 1.0
     */
    public void unsubscribeFromActivity(Club club, Activity unsubscribingActivity)
    {
        club.unSubscribeFromActivity(this, unsubscribingActivity);
    }
    /**
     * Method that verifies the equality of two people.
     *
     * @param  o the object we want to compare to
     *
     * @return boolean true if the object are equal, false if they're not.
     *
     * @since 1.0
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return (name == person.name) && (surname == person.surname) && (username == person.username) && (password == person.password);
    }
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
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }
}

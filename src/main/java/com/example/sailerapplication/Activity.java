package com.example.sailerapplication;

import java.util.Arrays;

/**
 * Activity is in charge of saving a activity object with its properties.
 * Every activity has a name and an array of person registered for the activity.
 *
 *  @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 *  @author      Omar <@studenti.unipr.it>
 */

public class Activity {
    private String name;
    private Person[] registered;
    /**
     * This constructor generates an Activity object.
     * Since Activity will not be used as a class itself, we set it to protected.
     *
     * @return Activity the activity object
     *
     * @param cname
     */

    protected Activity(String cname) {
    }
    /**
     * This method gets the Activity name.
     *
     * @return String the Activity name
     *
     */
    public String getName() {
        return this.name;
    }
    /**
     * This method sets the Activity name.
     *
     * @param name the activity name
     *
     * @return void
     *
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gets the Activities registered subscriptions.
     *
     * @return Person []
     *
     */
    public Person[] getRegistered() {
        return this.registered;
    }
    /**
     * This method sets the Activities registered subscriptions.
     *
     * @param "person" [] the new subscribers
     *
     * @return void
     *
     */
    public void setRegistered(Person[] registered) {
        this.registered = registered;
    }
    /**
     * This method adds a new subscriber to the activity.
     *
     * @param person is the subscriber
     *
     * @return void
     *
     */

    public void addPerson(Person person) {
        this.registered = Arrays.copyOf(this.registered, this.registered.length + 1);
        this.registered[this.registered.length - 1] = person;
    }

    /**
     * This method deletes a subscriber.
     *
     * @param "Person" toDelete the subscriber we want to delete
     *
     * @return void
     *
     */
    public void popPerson(Person toDelete) {
        boolean foundPerson = false;
        for (int i = 0; i < this.registered.length; i++) {
            if (foundPerson)
                this.registered[i - 1] = this.registered[i];
            if (this.registered[i].equals(toDelete))
                foundPerson = true;
        }
        this.registered[this.registered.length - 1] = null;
    }
    /**
     * This method compares two Activities
     *
     * @param "Object" object we want to compare
     *
     * @return boolean if the objects are equal or not
     *
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) o;
        return (name == activity.name) && java.util.Arrays.equals(registered, activity.registered);
    }
    /**
     * This method returns a string describing the activity
     *
     * @return String the string
     *
     */
    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", registered no.='" + getRegistered().length + "'" + "}";
    }

}

package com.example.sailerapplication;

/**
 * Club is in charge of saving a Club object with his properties.
 * Each Club has a name, a list of Person and a list of Activity.
 *
 * @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 * @author      Omar <omar.@studenti.unipr.it>
 *
 */
public class Club
{
    private String name;
    private Person [] people;
    private Activity[] activities;
    private Boat[] boats;
    /**
     * This constructor generates a Club object without the initialization of the parameters.
     *
     */
    public Club()
    {
        this.name = "";
        this.people = new Person [0];
        this.activities = new Activity [0];
        this.boats = new Boat [0];
    }
    /**
     * This constructor creates a Club object and set the club's name to the String name.
     *
     * @param  name
     *
     */
    public Club(final String name)
    {
        this.name = name;
        this.activities = new Activity[0];
        this.people = new Person[0];
        this.boats = new Boat[0];
    }
    /**
     * This constructor creates a Club object and set the club's name, people and activities.
     * Activity and people are setting with System.arraycopy function.
     *
     * @param name
     * @param activities
     * @param people
     * @param boats
     *
     */
    public Club(final String name, final Activity []activities, final Person []people , final Boat []boats)
    {
        this.name = name;
        this.activities = new Activity[activities.length];
        this.people = new Person[people.length];
        this.boats = new Boat[boats.length];
        System.arraycopy(activities, 0, this.activities, 0, activities.length);
        System.arraycopy(people, 0, this.people, 0, people.length);
        System.arraycopy(boats, 0, this.boats, 0, boats.length);
    }
    /**
     * This method returns the Club's name.
     *
     * @return String the club's name
     *
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * This method sets the Club's name.
     *
     * @param name the club's new name
     *
     * @return void
     *
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * This method returns an array of Person that are subscribed to the Club.
     *
     * @return Person[] the subscribed people
     *
     */
    public Person[] getPeople()
    {
        Person []returnedValue = new Person[this.people.length];
        System.arraycopy(this.people, 0, returnedValue, 0, this.people.length);
        return returnedValue;
    }
    /**
     * This method sets the array of Person that are subscribed to the Club.
     *
     * @param inputPeople the new people array
     *
     * @return void
     *
     */
    public void setPeople(Person []inputPeople)
    {
        Person [] newArray = new Person[inputPeople.length];
        System.arraycopy(inputPeople, 0, newArray, 0, inputPeople.length);
        this.people = newArray;
    }


    /**
     * This method returns an array of Boat that are registered to the Club.
     *
     * @return Boat[] the registered boats
     *
     */
    public Boat[] getBoats()
    {
        Boat []returnedValue = new Boat[this.boats.length];
        System.arraycopy(this.boats, 0, returnedValue, 0, this.boats.length);
        return returnedValue;
    }

    /**
     * This method sets the array of Boat that are registered to the Club.
     *
     * @param inputBoat the new boat array
     *
     * @return void
     *
     */
    public void setBoats(Boat[] inputBoat)
    {
        Boat [] newArray = new Boat[inputBoat.length];
        System.arraycopy(inputBoat, 0, newArray, 0, inputBoat.length);
        this.boats = newArray;
    }

    /**
     * This method returns an array of Activities that are present in the Club.
     *
     * @return Activity[] the activities
     *
     */
    public Activity[] getActivities()
    {
        Activity []returnedValue = new Activity[this.activities.length];
        System.arraycopy(this.activities, 0, returnedValue, 0, this.activities.length);
        return returnedValue;
    }
    /**
     * This method sets the array of Activities that are present in the Club.
     *
     * @param inputActivities the new activities
     *
     * @return void
     *
     */
    public void setActivities(Activity []inputActivities)
    {
        Activity [] newActivities = new Activity[inputActivities.length];
        System.arraycopy(inputActivities, 0, newActivities, 0, inputActivities.length);
        this.activities = newActivities;
    }
    /**
     * This method adds a member to the Club. It only works if the authorizer
     * is a Club's Admin and the person isn't already subscribed. If true it appends
     * the Person toSubscribe to the Club's array of subscribers.
     *
     * @param authorizer  is the admin
     * @param toSubscribe is the new person to subscribe to the club.
     *
     * @return void
     *
     */
    public void addMember(Personale_Circolo authorizer, Person toSubscribe)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        // Checks if the member is already subscribed
        if (Helpers.elementExists(this.people, toSubscribe)) {
            return;
        }
        this.setPeople(Helpers.appendPerson(this.getPeople(), toSubscribe));
    }
    /**
     * This method removes a member from the Club. It only works if the authorizer
     * is a Club's Admin and the person is a club member. If true it removes the Person
     * toDelete from the Club's array of subscribers.
     *
     * @param authorizer the authorizing admin
     * @param toDelete   the person to delete
     *
     * @return void
     *
     */
    public void removeMember(Personale_Circolo authorizer, Person toDelete)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        if (!Helpers.elementExists(this.people, toDelete)) {
            return;
        }
        this.setPeople(Helpers.popPerson(this.getPeople(), toDelete));
    }

    /**
     * This method adds a boat to the Club. It only works if the authorizer
     * is a Club's Admin and the boat isn't already registered as someone's property. If true it appends
     * the boat toRegister to the Club's array of boats.
     *
     * @param authorizer  is the admin
     * @param toRegister is the new person to subscribe to the club.
     *
     * @return void
     *
     */
    public void addBoat(Personale_Circolo authorizer, Boat toRegister)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        // Checks if the member is already subscribed
        if (Helpers.elementExists(this.boats, toRegister)) {
            return;
        }
        this.setBoats(Helpers.appendBoat(this.getBoats(), toRegister));
    }

    /**
     * This method removes a boat from the Club. It only works if the authorizer
     * is a Club's Admin and the boat is registered in the club property. If true it removes the Boat
     * toDelete from the Club's array of boats.
     *
     * @param authorizer the authorizing admin
     * @param toDelete   the boat to delete
     *
     * @return void
     *
     */
    public void removeBoat(Personale_Circolo authorizer, Boat toDelete)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        if (!Helpers.elementExists(this.boats, toDelete)) {
            return;
        }
        this.setBoats(Helpers.popBoat(this.getBoats(), toDelete));
    }
    /**
     * This method adds an activity to the Club. It only works if the authorizer
     * is a Club's Admin and the activity doesn't already exist. If true it appends
     * the Activity toAdd to the Club's array of Activities.
     *
     * @param authorizer the authorizing admin
     * @param toAdd	  the activity to add
     *
     * @return void
     *
     */
    public void addActivity(Personale_Circolo authorizer, Activity toAdd)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        // Check if the activity already exists
        if (Helpers.elementExists(this.activities, toAdd)) {
            return;
        }
        this.setActivities(Helpers.appendActivity(this.getActivities(), toAdd));
    }
    /**
     * This method removes an Activity from the Club. It only works if the authorizer
     * is a Club's Admin and the activity is present. If true it remove the Activity
     * toDelete from the Club's array of Activity.
     *
     * @param authorizer the authorizing admin
     * @param toDelete	  the activity we want to delete
     *
     * @return void
     *
     */
    public void removeActivity(Personale_Circolo authorizer, Activity toDelete)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        if (!Helpers.elementExists(this.activities, toDelete)) {
            return;
        }
        this.setActivities(Helpers.popActivity(this.getActivities(), toDelete));
    }
    /**
     * This method replaces a Club's Activity with a new Activity. It only works if the
     * authorizer is a Club's Admin and if true it remove the Activity oldActivity from
     * the Club and add the Activity newActivity to the Club.
     *
     * @param authorizer  the authorizing personale_circolo
     * @param oldActivity the old activity
     * @param newActivity the activity to replace with
     *
     * @return void
     *
     */
    public void editActivity(Personale_Circolo authorizer, Activity oldActivity, Activity newActivity)
    {
        // Check if the authorizer is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        if (!Helpers.elementExists(this.activities, oldActivity)){
            return;
        }
        // If the new activity is already saved, we're just going to delete the old one
        if (Helpers.elementExists(this.activities, newActivity)) {
            this.removeActivity(authorizer, oldActivity);
            return;
        }
        this.removeActivity(authorizer, oldActivity);
        this.addActivity(authorizer, newActivity);
    }
    /**
     * This method replaces a Club's subscriber with a new Person. It only works
     * if the authorizer is a Club's Admin and if the Person oldPerson is in the Club's array of Person.
     * If true it remove the Person oldPerson from the Club and add the Person newPerson to the Club
     *
     * @param authorizer the authorizing admin
     * @param oldPerson  the person to replace
     * @param newPerson  the person to replace with
     *
     * @return void
     *
     */
    public void editPerson(Personale_Circolo authorizer, Person oldPerson, Person newPerson)
    {
        // Check if the admin is an admin of this specific club
        if (!Helpers.elementExists(this.people, authorizer)) {
            return;
        }
        if (!Helpers.elementExists(this.people, oldPerson)){
            return;
        }
        // If the new person is already saved, we're just gonna delete the old one
        if (Helpers.elementExists(this.people, newPerson)) {
            this.removeMember(authorizer, oldPerson);
            return;
        }
        this.removeMember(authorizer, oldPerson);
        this.addMember(authorizer, newPerson);
    }

    /**
     * This method's return value is a complete description for a Club object.
     * It shows the Club's name and all of the Club's subscribers and activities.
     *
     * @return String the description
     *
     */
    @Override
    public String toString() {
        String result = "CLUB: "+ this.getName() +"\nMembers:\n";
        for (Person member: this.people){
            result += (member.toString()+"\n");
        }
        result += "\nActivities:\n";
        for (Activity activity: this.activities){
            result += (activity.toString() + "\n");
        }
        return result;
    }
}

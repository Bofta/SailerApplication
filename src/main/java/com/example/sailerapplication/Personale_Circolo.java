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
    public Personale_Circolo(String name, String surname, String username, String password) {
        super(name, surname, username, password);
    }


    /**
     * This method is a wrapper for the Club's addMember method.
     *
     * @param club
     * @param newMember
     *
     * @return void
     *
     */
    public void addMemberToClub (Club club, Person newMember)
    {
        club.addMember(this, newMember);
    }

    /**
     * This method is a wrapper for the Club's removeMember method.
     *
     * @param club
     * @param deleteMember
     *
     * @return void
     *
     */
    public void removeMemberFromClub (Club club, Person deleteMember)
    {
        club.removeMember(this, deleteMember);
    }

    /**
     * This method is a wrapper for the Club's editPerson method.
     *
     * @param club
     * @param oldPerson
     * @param newPerson
     *
     * @return void
     *
     */
    public void editMemberOfClub (Club club, Person oldPerson, Person newPerson)
    {
        club.editPerson(this, oldPerson, newPerson);
    }



    /**
     * This method is a wrapper for the Club's addBoat method.
     *
     * @param club
     * @param newBoat
     *
     * @return void
     *
     */
    public void addBoatToClub (Club club, Boat newBoat)
    {
        club.addBoat(this, newBoat);
    }

    /**
     * This method is a wrapper for the Club's removeBoat method.
     *
     * @param club
     * @param deleteBoat
     *
     * @return void
     *
     */
    public void removeBoatFromClub (Club club, Boat deleteBoat)
    {
        club.removeBoat(this, deleteBoat);
    }

    /**
     * This method is a wrapper for the Club's addActivity method.
     *
     * @param club
     * @param newActivity
     *
     * @return void
     *
     */
    public void addActivityToClub (Club club, Activity newActivity)
    {
        club.addActivity(this, newActivity);
    }

    /**
     * This method is a wrapper for the Club's removeActivity method.
     *
     * @param club
     * @param deleteActivity
     *
     * @return void
     *
     * @since 1.0
     */
    public void removeActivityFromClub (Club club, Activity deleteActivity)
    {
        club.removeActivity(this, deleteActivity);
    }
    /**
     * This method is a wrapper to the Club's editActivity method.
     *
     * @param club
     * @param oldActivity
     * @param newActivity
     *
     * @return void
     *
     * @since 1.0
     */
    public void editActivityOfClub (Club club, Activity oldActivity, Activity newActivity)
    {
        club.editActivity(this, oldActivity, newActivity);
    }
}
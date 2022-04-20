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
    private int prize;
    /*
    private Person[] registered;
    */

    /**
     * This constructor generates an Activity object.
     * Since Activity will not be used as a class itself, we set it to protected.
     *
     * @return Activity the activity object
     * @param name
     * @param prize
     */

    public Activity(String name, int prize) {
        this.name = name;
        this.prize = prize;
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


    /**
     * This method gets the Activity Prize.
     *
     * @return String the Activity Prize
     *
     */
    public int getPrize(){return this.prize;}


    /**
     * This method sets the Activities prize.
     *
     * @param prize the new prize amount
     *
     * @return void
     *
     */
    public void setPrize(int prize){
        this.prize = prize;
    }



}

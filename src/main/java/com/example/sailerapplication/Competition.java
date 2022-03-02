package com.example.sailerapplication;

/**
 * Race is an Activity subclass which is in charge of saving a race with its properties.
 * Every race has two type of constructors.
 *
 * @author      Simone Montali <simone.montali1@studenti.unipr.it>
 * @author      Filippo Botti <filippo.botti2@studenti.unipr.it>
 *
 * @version     1.0
 * @since       1.0
 */
public class Competition extends Activity
{

    /**
     * This constructor generates an Activity object.
     * Since Activity will not be used as a class itself, we set it to protected.
     *
     * @param cname
     * @return Activity the activity object
     */
    protected Competition(String cname) {
        super(cname);
    }
    /**
     * Empty constructor for a Race object
     *
     * @since 1.0
     * @param cname
     */

    /**
     * This constructor generates a competition from its name
     * and its subscribed people.
     *
     * @param name       the competition name
     * @param registered the registered competitors
     *
     * @since 1.0
     */

   /**
    public Competition(String name, Person[] registered) {
        this.setName(name);
        this.setRegistered(registered);
    }
    */

    /**
     * This specific constructor is used intentionally to make the client-server connections work to avoid bugs
     * This constructor generates a competition by its name and prize.
     * There will be no subscribers.
     *
     * @param name      the name of the competition
     *
     * @since 1.0
     */

}
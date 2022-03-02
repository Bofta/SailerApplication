package com.example.sailerapplication;

/**
 * Helpers contains helper methods to use with the software's arrays.
 *
 * @author      Simone Montali <simone.montali1@studenti.unipr.it>
 * @author      Filippo Botti <filippo.botti2@studenti.unipr.it>
 *
 * @version     1.0
 * @since       1.0
 */
public class Helpers
{
    /**
     * This method appends a Person object to an array
     *
     * Note: using generic types here would be great but we cannot create generic arrays
     *
     * @param array           the array to extend
     * @param elementToAppend the element we want to append
     *
     * @return Person[] the extended array
     *
     */
    public static Person[] appendPerson (Person[] array, Person elementToAppend)
    {
        Person [] newArray = new Person[array.length+1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = elementToAppend;
        return newArray;
    }

    /**
     * This method appends a Boat object to an array
     *
     * Note: using generic types here would be great, but we cannot create generic arrays
     *
     * @param array           the array to extend
     * @param elementToAppend the element we want to append
     *
     * @return Boat[] the extended array
     *
     */
    public static Boat[] appendBoat (Boat[] array, Boat elementToAppend)
    {
        Boat [] newArray = new Boat[array.length+1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = elementToAppend;
        return newArray;
    }

    /**
     * This method appends an Activity object to an array
     *
     * Note: using generic types here would be great but we cannot create generic arrays
     *
     * @param array           the array to extend
     * @param elementToAppend the element we want to append
     *
     * @return Activity[] the extended array
     *
     * @since 1.0
     */
    public static Activity[] appendActivity (Activity[] array, Activity elementToAppend)
    {
        Activity [] newArray = new Activity[array.length+1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = elementToAppend;
        return newArray;
    }
    /**
     * This method pops a Person object from an array
     *
     * Note: using generic types here would be great but we cannot create generic arrays
     *
     * @param array           the array to extend
     * @param elementToDelete the element we want to delete
     *
     * @return Person[] the shortened array
     *
     * @since 1.0
     */
    public static Person[] popPerson(Person[]array, Person elementToDelete)
    {
        Person [] newArray = new Person[array.length-1];
        int j = 0;
        for (int i=0; i<array.length;i++){
            if (!array[i].equals(elementToDelete)){
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }

    /**
     * This method pops a Boat object from an array
     *
     * Note: using generic types here would be great, but we cannot create generic arrays
     *
     * @param array           the array to extend
     * @param elementToDelete the element we want to delete
     *
     * @return Boat[] the shortened array
     *
     * @since 1.0
     */
    public static Boat[] popBoat(Boat[]array, Boat elementToDelete)
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

    /**
     * This method pops an Activity object from an array
     *
     * Note: using generic types here would be great but we cannot create generic arrays
     *
     * @param array           the array to extend
     * @param elementToDelete the element we want to delete
     *
     * @return Activity[] the shortened array
     *
     * @since 1.0
     */
    public static Activity[] popActivity (Activity[] array, Activity elementToDelete)
    {
        Activity [] newArray = new Activity[array.length-1];
        int j = 0;
        for (int i=0; i<array.length;i++){
            if (!array[i].equals(elementToDelete)){
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }
    /**
     * This method checks if an element exists in an array
     *
     * @param array         the array to extend
     * @param elementToFind the element we want to find
     *
     * @return boolean whether the element was found or not
     *
     * @since 1.0
     */
    public static <T> boolean elementExists (T[] array, T elementToFind)
    {
        boolean result = false;
        for (T indexable: array){
            if (elementToFind.equals(indexable))
                result = true;
        }
        return result;
    }
}
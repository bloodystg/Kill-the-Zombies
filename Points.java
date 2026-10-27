/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videogame;

/**
 *
 * @author Jian
 */
public class Points implements Comparable<Points> {

    private String zombieActions;
    private int points;

    /**
     * Constructor to initialize zombieActions with data and the points
     * reference
     *
     * @param zombieActions the initial value for zombieActions
     * @param points the initial reference for the points
     */
    public Points(String zombieActions, int points) {
        this.zombieActions = zombieActions;
        this.points = points;
    }

    /**
     * getZombieActions method returns value from the zombieActions field
     *
     * @return return value from the zombieActions field
     */
    public String getZombieActions() {
        return zombieActions;
    }

    /**
     * getPoints method returns value from the Points field
     *
     * @return value from the Points field
     */
    public int getPoints() {
        return points;
    }

    /**
     * assigns new zombieActions for zombieActions field
     *
     * @param zombieActions the new value to assign to zombieActions field
     */
    public void setZombieActions(String zombieActions) {
        this.zombieActions = zombieActions;
    }

    /**
     * assigns new Points for the Points field
     *
     * @param points the new Points reference to assign to the next field
     */
    public void setPoints(int points) {
        this.points = points;
    }

    public boolean equals(Object obj) {
            Points otherPoints = (Points) obj;  // cast the Object to a Points

            return zombieActions.equalsIgnoreCase(otherPoints.getZombieActions())
                    && points == otherPoints.getPoints();
        }
        /**
         * The compareTo method compares this Points to another Object . if this
         * Points is before other points, return a value < 0.
         * if this points is after other points, return a value > 0. if this
         * points is equal to other points, return 0.
         *
         * @param anotherPoints The object to test for equality.
         * @return int with result of comparison.
         */
    
    public int compareTo(Points anotherPoints) {

        int returnResult;

        if (getPoints() < anotherPoints.getPoints()) {
            returnResult = -1;
        } else if (getPoints() > anotherPoints.getPoints()) {
            returnResult = 1;
        } else {
            returnResult = zombieActions.compareToIgnoreCase(anotherPoints.getZombieActions());
        }
        return returnResult;
    }
}

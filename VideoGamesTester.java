/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogame;

/**
 *
 * @author Jian
 */
public class VideoGamesTester {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("\nVideoGames Tester\n");
		
        String ZombieActions = "ZombieActions";
        int Points = 23;
        String updatedZombieActions = "ZombieHitByCar";
        int updatedPoints = 600;

        int returnValue = 0;

        Points myVideoGame = new Points(ZombieActions, Points);        
        
        System.out.print("Initially: [ " + myVideoGame.getZombieActions() + " - " + myVideoGame.getPoints() + " ]\t");
        try {

            if (myVideoGame.getZombieActions().equalsIgnoreCase(ZombieActions)) {
                System.out.print("Action: "+ZombieActions+" Good\t");
            } else {
                System.out.println("Action: " + myVideoGame.getZombieActions() + "   \t\t\t<==== ISSUE");
                returnValue++;
            }
        } catch (NullPointerException e) {
            System.out.println("\nAction:     Exception: " + e.getMessage() + "   \t\t\t<==== ISSUE");
            returnValue++;
        }
         if (myVideoGame.getPoints() == Points) {
            System.out.println("Points: "+Points+" Good");
        } else {
            System.out.println("\npoints: " + myVideoGame.getPoints() + "   \t\t\t<==== ISSUE");
            returnValue++;
        }
         myVideoGame.setZombieActions(updatedZombieActions);
         myVideoGame.setPoints(updatedPoints);
          try {

            if (myVideoGame.getZombieActions().equalsIgnoreCase(updatedZombieActions)) {
                System.out.print("Action: "+updatedZombieActions+" Good\t");
            } else {
                System.out.println("Action: " + myVideoGame.getZombieActions() + "   \t\t\t<==== ISSUE");
                returnValue++;
            }
        } catch (NullPointerException e) {
            System.out.println("\nAction:     Exception: " + e.getMessage() + "   \t\t\t<==== ISSUE");
            returnValue++;
        }
         if (myVideoGame.getPoints() == updatedPoints) {
            System.out.println("Points: "+updatedPoints+" Good");
        } else {
            System.out.println("\npoints: " + myVideoGame.getPoints() + "   \t\t\t<==== ISSUE");
            returnValue++;
        }
}
}
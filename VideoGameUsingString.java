/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogame;

import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class VideoGameUsingString {

    /**
     * The main method is the program's starting point.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // declare variables

        String usersChoice, actionEntered;	// for menu choice and for the points entered by the user
        int pointsEntered;
        Scanner input = new Scanner(System.in); // Scanner object to get data from the user

        // create bag with a capacity of 5
        OrderedSinglyLinkedList<Points> pointsList = new OrderedSinglyLinkedList<>();

        /* ^^^ if this was project 2, the Linked List would be declared here
           see TestSinglyLinkedListV4 for the declaraton of the pointsList */
        System.out.println("Welcome to Project 2!");

        do {

            // if this was project 2, the following would be the menu of the choices
            // display menu
            System.out.print("\nEnter choice (A=Add, R=Remove, F=Find, D=Display, Q=Quit): ");
            usersChoice = input.nextLine(); // get users choice

            /* 
                
             */
            if (usersChoice.equalsIgnoreCase("Q")) {

                System.out.println("\nBye bye!\n");

            } else if (usersChoice.equalsIgnoreCase("A")) {

                System.out.print("\nEnter zombie action to add: ");
                actionEntered = input.nextLine();

                System.out.print("\nEnter points to add: ");
                String sourceString1 = input.nextLine();

                try {
                    pointsEntered = Integer.parseInt(sourceString1);
                    Points points = new Points(actionEntered, pointsEntered);
                    pointsList.add(points);
                    System.out.println("\nAdded successfully!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Points must be a number. ");
                }
                /* */
            } else if (usersChoice.equalsIgnoreCase("F")) {

                System.out.print("\nEnter zombie action to find: ");
                actionEntered = input.nextLine();
                System.out.print("\nEnter points to find: ");
                String findInput = input.nextLine();
                try {
                    pointsEntered = Integer.parseInt(findInput);
                    Points p = new Points(actionEntered, pointsEntered);
                    if (pointsList.exists(p)) {
                        System.out.print("\n" + actionEntered + " exists! and it is there: "
                                + pointsList.countOccurrences(p) + " time(s)\n");

                    } else {
                        System.out.print("\n" + actionEntered + " does not exist! it is there: "
                                + pointsList.countOccurrences(p) + " time(s)\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Points must be a number. ");
                }
                /* if this was project 2, see bottom of file for logic for find and remove */
            } else if (usersChoice.equalsIgnoreCase("R")) {
                System.out.print("\nEnter zombie action to remove: ");
                actionEntered = input.nextLine();
                System.out.print("\nEnter points to remove: ");
                String removeInput = input.nextLine();

                try {
                    pointsEntered = Integer.parseInt(removeInput);
                    Points p = new Points(actionEntered, pointsEntered);
                    if (pointsList.exists(p)) {
                        System.out.print("\n" + actionEntered + " removed!");

                    } else {
                        System.out.print("\n" + actionEntered + " has not been removed!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Points must be a number. ");
                }
                /* For Prog Lab Ch 03, see the bottom of file for logic for remove and peek at find, above */
 /* if this was project 2, see bottom of file for logic for remove )*/
            } else if (usersChoice.equalsIgnoreCase("D")) {
                displayLinkedListPointsAndSize(pointsList, "\npointsList");

            } else {
                System.out.println("\nyou entered an invalid choice");
            }
        } while (!(usersChoice.equalsIgnoreCase("Q")));
    } // end main method

    /**
     * the displayBag method displays the StringBag
     *
     * @param heading a String to display before the bag
     * @param aBag the StringBag to display
     */
    public static void displayLinkedListPointsAndSize(OrderedSinglyLinkedList<Points> listToDisplay,
            String label) {
        System.out.println(label + ":\n[");

        if (listToDisplay.size() == 0) {
            System.out.print("--Empty--");
        }
        Lister<Points> pointsLister = listToDisplay.iterator();
        while (pointsLister.hasNext()) {
            Points displayPoints = pointsLister.next();
            System.out.print(" { Points " + displayPoints.getPoints()
                    + " " + displayPoints.getZombieActions());
            if (pointsLister.hasNext()) {
                System.out.print(",");
            }
            System.out.println();
        }

        System.out.print("]\tSize: " + listToDisplay.size() + "  ");

    }
}

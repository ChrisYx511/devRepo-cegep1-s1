package dev.chrisyx511.cs1.finalProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle any given menu, creating the different pages of the application
 */
public class Menu {
    // 3 main components of each page
    String titleString;
    String body;
    String options;
    /** Constructor to create new menu, <code>options</code> is optional
     * @param titleString title of the menu
     * @param body body of the menu
     * @param options options of the menu, in <code>String</code> form
     * */
    Menu(String titleString, String body, String options) {
        this.titleString = titleString;
        this.body = body;
        this.options = options;
    }
    /** Constructor to create new menu, <code>options</code> is optional
     * @param titleString title of the menu
     * @param body body of the menu
     * */
    Menu(String titleString, String body) {
        this.titleString = titleString;
        this.body = body;
    }

    /**
     * Functional interface allowing methods to store methods as a MenuAction.action();
     */
    @FunctionalInterface
    public interface MenuAction {
        void action();
    }
    /**
     * Functional interface allowing methods to store methods as a MenuAction.action();
     */
    @FunctionalInterface
    public interface RefreshAction {
        void action();
    }

    /**
     * List of MenuAction interfaces, containing methods that can be executed later
     */
    public ArrayList<MenuAction> menuActions = new ArrayList<>();

    /**
     * Draw Menu using System.out.println()
     */
    public void draw() {
        System.out.println(this.titleString);
        System.out.println(this.body);
        System.out.println(this.options);
    }

    /**
     * Draws the menu and accept user inputted action, executing the action associated
     * with the number.
     * @param maxMenuOption the max integer that the user can input to make a choice, <code>maxMenuOption</code>
     *                      must always be the exit option. Note that menu options count from 1.
     */
    public void handleMenuOption(int maxMenuOption) {
        // Declare scanner and user menu option
        final Scanner in = new Scanner(System.in);
        int mainMenuSelection = 1;
        while (mainMenuSelection != maxMenuOption) {
            // Draw menu and options
            this.draw();
            System.out.print("Option: ");
            // Accept user input mainMenuSelection
            mainMenuSelection = in.nextInt();
            in.nextLine();
            // Check if menu options are valid
            if (mainMenuSelection > maxMenuOption || mainMenuSelection <= 0) {
                System.out.println("Invalid input");
                continue;
            } else if (mainMenuSelection == maxMenuOption) {
                continue;
            }
            // Execute the MenuAction corresponding with the user choice
            menuActions.get(mainMenuSelection - 1).action();
        }
    }

    /**
     * Draws the menu and accept user inputted action, executing the action associated
     * with the number AND refreshing the body on every iteration.
     * @param maxMenuOption the max integer that the user can input to make a choice, <code>maxMenuOption</code>
     *                      must always be the exit option. Note that menu options count from 1.
     * @param refresh the action associated with the refresh, usually updating <code>this.body</code>
     */
    public void handleMenuOption(int maxMenuOption, RefreshAction refresh) {
        // Declare scanner and user menu option
        final Scanner in = new Scanner(System.in);
        int mainMenuSelection = 1;
        while (mainMenuSelection != maxMenuOption) {
            refresh.action();
            // Draw menu and options
            this.draw();
            System.out.print("Option: ");
            // Accept user input mainMenuSelection
            mainMenuSelection = in.nextInt();
            in.nextLine();
            // Check if menu options are valid
            if (mainMenuSelection > maxMenuOption || mainMenuSelection <= 0) {
                System.out.println("Invalid input");
                continue;
            } else if (mainMenuSelection == maxMenuOption) {
                continue;
            }
            // Execute the MenuAction corresponding with the user choice
            menuActions.get(mainMenuSelection - 1).action();
        }
    }

}


/*
 * Game.java - Emree Jensen
 * 1st Individual Assignment - Text Based Adventure Game
 * 
 * Main.java - Entry Point for the Game
*/

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        try {
            // Create a new player object, which initializes the game map and sets the starting room
            Player player = new Player();
            // Create a scanner to read user input for navigation commands
            Scanner scanner = new Scanner(System.in);

            // Main game loop that continues until the player exits
            while (true) {
            	// Print a blank line for spacing and display the player's current location            	
            	System.out.println();
                System.out.println("Alice wanders into the " + player.getCurrentRoomName() + "...");
                System.out.println(player.getCurrentRoomDescription());
                System.out.println(); // Extra space for readability

                // Prompt the user to choose a direction or to exit the game
                System.out.println("Where will Alice's adventures lead her next?");
                System.out.println("North (N), East (E), South (S), or West (W)");
                System.out.println("Choose a direction or Type 'exit' to leave Wonderland: ");
                String input = scanner.nextLine().trim(); // Read and clean user input

                // Check if the user wants to exit the game
                if (input.equalsIgnoreCase("exit")) {
                	System.out.println();
                    System.out.println("Alice drifts out of Wonderland and returns to the real world...");
                    System.out.println("(Exiting Game)");
                    break; // Exit the main loop, ending the game
                }

                try {
                    // Attempt to move the player in the direction they specified
                    player.move(input);
                } catch (InvalidRoomException e) {
                    // Catch and display any errors related to invalid movements
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            // Catch and print any unexpected errors during the game's execution
            e.printStackTrace();
        }
    }
} // End Game Class
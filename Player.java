/*
 * Player.java - Emree Jensen
 * 1st Individual Assignment - Text Based Adventure Game
 * 
 * Represents the player and manages their current location and movement through the game.
 * The Player interacts with Room and GameMap to navigate the world.
 * 
*/


/*
 * Class Example Notes:
 * The Player class has reference to the Room object and to the Map Object.
 * The player has knownledge of its current location and always start at Room 1
 * The player is able to move between rooms using the North, East, South, and West naviagtion command
 * 
 * The moveTo(String roomId) sets the current room that the player in as visited + it returns...
 * The returned Room object will be set as the current location of the player as the player tries to...
*/

import java.io.FileNotFoundException;

public class Player {
    // The player's current location in the game
    private Room currentRoom;
    // Reference to the game's map for navigating rooms
    private GameMap map;

    /*
     * Constructor for the Player class.
     * 
     * Initializes the game map and sets the player's starting location to Room 1.
     * 
     * @throws InvalidRoomException if Room 1 does not exist in the map.
     * @throws FileNotFoundException if the map file cannot be loaded.
     */
    public Player() throws InvalidRoomException, FileNotFoundException {
        map = new GameMap(); // Load the game map
        currentRoom = map.getRoom("1"); // Start the player in Room 1
    }

    /*
     * Gets the name of the player's current room.
     * 
     * @return the name of the current room.
     */
    public String getCurrentRoomName() {
        return currentRoom.getName();
    }

    /*
     * Gets the description of the player's current room.
     * 
     * @return the description of the current room.
     */
    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    /*
     * Checks if the current room has been visited before.
     * 
     * @return true if the room has been visited, false otherwise.
     */
    public boolean isCurrentRoomVisited() {
        return currentRoom.isVisited();
    }

    /*
     * Marks the current room as visited.
     */
    public void markCurrentRoomVisited() {
        currentRoom.setVisited(true);
    }

    /*
     * Moves the player in the specified direction.
     * 
     * @param direction The direction to move (North, East, South, or West).
     * @throws InvalidRoomException if the next room is invalid or does not exist.
     */
    public void move(String direction) throws InvalidRoomException {
        // Variable to store the ID of the next room
        String nextRoomID = null;

        // Determine the direction and set the nextRoomID based on current room's exits
        switch (direction.toLowerCase()) {
            case "north":
            case "n":
                nextRoomID = currentRoom.getNorthRoomID();
                break;
            case "east":
            case "e":
                nextRoomID = currentRoom.getEastRoomID();
                break;
            case "south":
            case "s":
                nextRoomID = currentRoom.getSouthRoomID();
                break;
            case "west":
            case "w":
                nextRoomID = currentRoom.getWestRoomID();
                break;
            default:
                // Handle invalid input
            	System.out.println();
                System.out.println("Invalid direction. Please enter North, East, South, West, or exit.");
                return; // Stop further execution
        }

        // Check if the direction leads to a valid room
        if (nextRoomID == null || nextRoomID.equals("0")) {
        	System.out.println();
            System.out.println("Oh dear! Alice wandered off the map and vanished into butterflies!");
            System.out.println("To guide her back, please enter North (N), East (E), South (S), or West (W).");
            return; // Stop and return to allow the user to try again
        }

        // Move to the next room by retrieving it from the map
        currentRoom = map.getRoom(nextRoomID);
        
        // Check if this is the first time visiting the new room
        if (!currentRoom.isVisited()) {
            currentRoom.setVisited(true); // Mark the room as visited
        } else {
            // Notify the player if the room has been visited before
        	System.out.println();
            System.out.println("This looks awfully familiar...");
        }
    }
} // End Player Class
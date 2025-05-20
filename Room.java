/*
 * Room.java - Emree Jensen
 * 1st Individual Assignment - Text Based Adventure Game
 * 
 * Represents a room in the game with attributes such as ID, name, description, 
 * whether it has been visited, and connections to other rooms in four directions.
 * 
*/

/*
 * Class Example Notes:
 * The goal from the room class is to keep track of the room object
 * each room has the following attricutes:
 * 		Unique room ID
 * 		Boolean variable to track visited rooms
 * 		Room Description
 * 		North RoomID
 * 		East RoomID
 * 		South RoomID
 * 		West RoomID
 * 
 * The Room class is de-coupled from the rest of the system.
*/

import java.util.HashMap;

public class Room {
    // Attributes to describe the room and its connections
    private String roomID; // Unique identifier for the room
    private String name; // Name of the room
    private boolean isVisited; // Tracks if the room has been visited
    private String description; // Detailed description of the room
    private String northRoomID; // ID of the room to the north
    private String eastRoomID; // ID of the room to the east
    private String southRoomID; // ID of the room to the south
    private String westRoomID; // ID of the room to the west
    private HashMap<String, String> exits; // Alternative: map directions to room IDs

    /*
     * Constructor for the Room class.
     * 
     * Initializes the room with its attributes and connections.
     * 
     * @param roomID      Unique identifier for the room.
     * @param name        Name of the room.
     * @param isVisited   Whether the room has been visited.
     * @param description Description of the room.
     * @param northRoomID Room ID for the north connection.
     * @param eastRoomID  Room ID for the east connection.
     * @param southRoomID Room ID for the south connection.
     * @param westRoomID  Room ID for the west connection.
     */
    public Room(String roomID, String name, boolean isVisited, String description, 
            String northRoomID, String eastRoomID, String southRoomID, String westRoomID) {
	    this.roomID = roomID;
	    this.name = name;
	    this.isVisited = isVisited;
	    this.description = description;
	    this.northRoomID = northRoomID;
	    this.eastRoomID = eastRoomID;
	    this.southRoomID = southRoomID;
	    this.westRoomID = westRoomID;
    }

    /*
     * Getters
     * 	- Room's unique ID
     *	- Room's name
     *	- Room's Description
     *	- North Connection
     *	- East Connection
     *	- South Connection
     * 	- West Connection
     */
    public String getRoomID() {
        return roomID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getNorthRoomID() {
        return northRoomID;
    }

    public String getEastRoomID() {
        return eastRoomID;
    }

    public String getSouthRoomID() {
        return southRoomID;
    }

    public String getWestRoomID() {
        return westRoomID;
    }

    // Checks if the room has been visited
    public boolean isVisited() {
        return isVisited;
    }

    // Marks the room as visited
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    // Getter for exits (alternative way to track connections)
    public HashMap<String, String> getExits() {
        return exits;
    }

    /*
     * Adds an exit to the room.
     * 
     * @param direction The direction of the exit (e.g., "North").
     * @param roomID    The ID of the room in that direction.
     */
    public void addExit(String direction, String roomID) {
        exits.put(direction, roomID);
    }
}
/*
 * GameMap.java - Emree Jensen
 * 1st Individual Assignment - Text Based Adventure Game
 * 
 * The GameMap class is responsible for managing the game's map, which is a collection of Room objects.
 *
 * Main Responsibilities:
 *  1) Load room data from a text file (Map.txt) and store it as an ArrayList of Room objects.
 *  2) Retrieve specific Room objects based on their unique room IDs.
 *
 * Key Features:
 * - The map is represented as an ArrayList of Room objects.
 * - Each Room has connections to other Rooms in four directions: North, East, South, and West.
 * - The map data, including room connections, is parsed from an external file (Map.txt).
 * 
*/


/* Class Example Notes:
 * The Map class has an Array List of the rooms' objects
 * 
 * The Map class has two methods:
 * 		1) readRooms (String fileName): Responsible for parsing the game text file into an array list of... 
 * 		2) getRoom(String roomId): Returns a Room object based on the given room ID
 * 
 * Map is an array list of rooms:
 * 		_____________________________________
 * 		|__0__|__1__|__2__|__3__|__4__|__5__|
 * 		   |	 |	   |	 |	   |	 |
 * 		Room1  Room2 Room3  Room4 Room5 Room6
 * 		ID1	    ID2   ID3    ID4   ID5   ID6
 * N	0		 0     1      2     3     4
 * E	2		 0     4      0     6     0
 * S	3		 4     5      6     0     0
 * W	0		 3     0      3     0     5
 * 
 * The Map class references only the Room class.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameMap {
    // Stores the list of Room objects that make up the game's map
    private ArrayList<Room> rooms;

    // Constructor initializes the map by loading rooms from a file
    public GameMap() throws FileNotFoundException {
        rooms = new ArrayList<>(); // Initialize the rooms list
        readRooms("Map.txt"); // Load rooms from the text file
    }
    
    /*
     * Retrieves a Room object based on its unique room ID.
     * 
     * @param roomID - The unique identifier for the room.
     * @return Room - The Room object with the given ID.
     * @throws InvalidRoomException - If the room ID is not found in the map.
     */
    public Room getRoom(String roomID) throws InvalidRoomException {
        for (Room room : rooms) {
            if (roomID.equals(room.getRoomID())) {
                return room; // Return the room if the ID matches
            }
        }
        // Throw an exception if no matching room is found
        throw new InvalidRoomException("Room not found: " + roomID);
    }

    /*
     * Reads the room data from a text file and creates Room objects.
     * 
     * @param fileName - The name of the file containing the map data.
     * @throws FileNotFoundException - If the file cannot be found.
     */
    private void readRooms(String fileName) throws FileNotFoundException {
        // Open the file for reading
    	Scanner scanner = new Scanner(new File(fileName));

        // Process each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read the next line
            String[] parts = line.split("~"); // Split the line into components using "~" as a delimiter

            String roomID = parts[0]; 							// Unique room ID
            boolean isVisited = Boolean.parseBoolean(parts[1]); // Whether the room has been visited
            String roomName = parts[2]; 						// Name of the room
            String description = parts[3]; 						// Room description
            String[] connections = parts[4].split(","); 		// Connections to other rooms (N, E, S, W)

            // Parse connections
            String north = connections[0]; 	// Room ID to the North
            String east = connections[1]; 	// Room ID to the East
            String south = connections[2]; 	// Room ID to the South
            String west = connections[3]; 	// Room ID to the West

            // Create a new Room object with the parsed data
            Room room = new Room(roomID, roomName, isVisited, description, north, east, south, west);

            // Add the room to the list of rooms
            rooms.add(room);
        }

        // Close the file to free resources
        scanner.close();
    }
} // End GameMap Class

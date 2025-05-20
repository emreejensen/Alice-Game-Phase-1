Welcome to Alice's Adventures: A Text-Based Adventure Game!

This game immerses you in a whimsical text-based adventure inspired by 
American McGee's Alice Madness Returns, and, more generally, Lewis Carroll's Alice in Wonderland. 



Key Features
	- Dynamic Navigation: Moves Alice through rooms using directional commands (North, East, South, West)
	- Room Visitation Tracking: Keeps track of whether a room has been visited
	- Error Handling: Prevents invalid moves with feedback



How To Play
	-> Launch the program.
	-> Enter a direction (North, East, South, West) or use abbreviations (N, E, S, W) to navigate.
	-> Things will look "awfully familiar" if a room is entered 2+ more times.
	-> Read & follow the error messages if Alice wanders to the end of the map (wrong direction).
	-> Type exit to end the game at any time.



How It Works
	The program reads in a text file "Map.txt" and constructs a map based on the input.
	
	-> Open the file "Map.txt"
	
	Here, you will notice that each line is split into 4 parts:
		<roomID>			Identification string given to each room
		<isVisited>			Boolean value indicating whether a room has been visited or not
		<roomDescription>	String value that signifies the room's description
		<roomConnections>	List of 4 string values signifying the 4 direction points of each room
							Direction order is North, East, South, West (N, E, S, W)



Classes & Logic
	1) Game
			Main Class & Entry Point
				Continuously Loops to Perform Key Features (Prompt, Description, Exit)
			
	2) Player
			Alice's Current Location, Movement, and Rooms Visited
				move(String direction): Alice's Movement Logic
				getCurrentRoomName() and getCurrentRoomDescription(): Get Room Details for Display
			
	3) GameMap
			Map Structure and All Rooms + Relationships
				readRooms(String fileName): Loads and parses room data from a text file
				getRoom(String roomID): Retrieves room by ID and throws an exception if needed
	
	4) Room
			Individual Rooms + Attributes and Room Connections
				roomID: 											Unique identifier for each room
				description: 										Descriptive context for the room
				northRoomID, eastRoomID, southRoomID, westRoomID: 	Connections to adjacent rooms
				isVisited: 											Tracks room visitation history
				
				getRoomID(), getDescription(), isVisited(): 		Retrieve room details
				setVisited(boolean isVisited): 						Updates the visited status
		
	5) InvalidRoomException
			Custom exception thrown with error message when attempting to access an invalid room.



Wonderland Default Map 
Version 1 (roomID) for Map.txt
 _ _ _ _
|   |   |
|_1_|_2_|
|   |   |
|_3_|_4_|
|   |   |
|_5_|_6_|
|   |
|_7_|

Version 2 (name) for Map.txt
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
|   								 |				   |
|_Houndsditch_Home_for_Wayward_Youth_|_Hatter's_Domain_|
|   								 |   			   |
|_ _ _ _ _ _Deluded_Depths_ _ _ _ _ _|_ _Queensland_ _ |
|   								 |   			   |
|_ _ _ _ _ _ _Dollhouse_ _ _ _ _ _ _ | _Infernal_Train_|
|   								 |
|_ _ _ _ _ _ _ _Asylum_ _ _ _ _ _ _ _|



Thank You & Enjoy Playing Alice's Adventures!
Emree Jensen

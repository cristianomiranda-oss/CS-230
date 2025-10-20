package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author Cristiano Miranda
 *
 */
public class Team extends Entity {
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	public Player addPlayer(String name) {
		// local player instance
		Player player = null;
		
//		Instantiates an iterator for the players list.
		Iterator<Player> it = players.iterator();
		
		// Loops through until the last player is reached
		while (it.hasNext()) {
//			Initializes a new var to reference the current player object.
			Player currentPlayer = it.next();
//			Checks if the currentPlayer's name is the same as the one passed in.
			if (currentPlayer.getName().equals(name)) {
				// Assigns the currentPlayer to the local player var
				player = currentPlayer;
			}
		}
		
//		Checks that no associated player was found
		if (player == null) {
			// Obtains and stores the singular GameService Object
			GameService service = GameService.getInstance();
			// Obtains the next unique playerId 
			long newPlayerId = service.getNextPlayerId();
			
			// Instantiates a new Player object
			player = new Player(newPlayerId, name);
			// Appends the new player object to the list
			players.add(player);
		}
		
		// Returns the player object
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}

package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author Cristiano Miranda
 *
 */
public class Game extends Entity {
	private List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	public Team addTeam(String name) {
		// local team instance
		Team team = null;
		
		// Instantiates an iterator for the teams list.
		Iterator<Team> it = teams.iterator();
		
		// Loops through until the last team is reached
		while(it.hasNext()) {
			// Initializes a new var to reference the current team
			Team currentTeam = it.next();
			// Checks if the currentTeam's name is the same as the one passed in
			if (currentTeam.getName().equals(name)) {
				// Assigns the currentTeam to the local team var 
				team = currentTeam;
			}
		}
		
		// Checks that no associated team was found
		if (team == null) {
			// Obtains and stores the singular GameService Object
			GameService service = GameService.getInstance();
			// Obtains the next unique playerId 
			long newTeamId = service.getNextTeamId();
			
			// Instantiates a new Team object
			team = new Team(newTeamId, name);
			// Appends the new team object to the list
			teams.add(team);
		}
		
		// Returns that team object
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}

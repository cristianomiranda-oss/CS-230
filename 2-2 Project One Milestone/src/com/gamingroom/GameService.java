package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author Cristiano Miranda
 */
public class GameService {

	/**
	 * The singleton pattern is utilized to ensure that only a singular instance of an object is instantiated, to ensure that the same object is accessed
	 * throughout the project. In doing this, it allows for a singular access point towards the methods and attributes within the object, allowing them to 
	 * be shared and connected through the entire project. Additionally, this ensures that the object is consistent throughout all parts of the project and that the data within it
	 * is the same regardless of where it is accessed in the project. In this case, the nextGameId static long variable is a good example of how the singleton pattern's
	 * persistent data characteristic is useful. Through this characteristic, regardless of where the addGame method is called upon the GameService object, attempting to add a game
	 * to the list will utilize the current value of the nextGameId and then iterate the value by one and store it for use later use, allowing the id value to be unique for any added game.
	 */
	
//	Instantiates a singular GamerService Object
	private static GameService instance = new GameService();
	
	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	
//	Constructor for the GameService class
		// its private to prevent instantiating the object outside of the class
	private GameService() {}
	
	/**
	 * Returns the singular instance of the GameService class
	 * 
	 * @return the GameService object
	 */
	public static GameService getInstance() {
		return instance;
	}

	/**
	 * The iterator pattern is utilized to iterate through the games ArrayList, as it allows for retrieval and traversal of the list through simple methods. Even though us developers
	 * might not be aware of the exact structure of the list and fully understand each method used to access elements, we can still utilize it as all we need to know is how to work with and use the simpler to understand methods.
	 * In this project, using the iterator pattern allows us to traverse the games ArrayList and encapsulates the code into a separate class, which also allows us to reuse the same
	 * class in multiple places, like in the addGame method and both getGame methods. 
	 * Through this, rather than having to implement the logic to traverse the ArrayList repeatedly, we can instead call the class and instantiate an iterator object that houses the methods and attributes needed to traverse
	 *  the game ArrayList and access the elements within it. Additionally, this class will also allow us to traverse other lists in the project using the same logic, even if these ArrayLists house a different type of data.
	 */
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
//		Instantiates an iterator for the games list.
		Iterator<Game> it = games.iterator();
		
//		Loops through the games list until the last game is reached
		while (it.hasNext()) {
//			Initializes a new variable to reference the current game object in the list
			Game currentGame = it.next();
//			Checks if the next game in the list has a name matching the passed in string
			if (currentGame.getName().equals(name)) {
				// Assigns the game variable to the matching game object
				game = currentGame;
			}
		}
		

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

//		Instantiates an iterator for the games list.
		Iterator<Game> it = games.iterator();
		
//		Loops through the games list until the last game is reached
		while (it.hasNext()) {
//			Initializes a new variable to reference the current game object in the list
			Game currentGame = it.next();
//			Checks if the next game in the list has a name matching the passed in string
			if (currentGame.getId() == id) {
				// Assigns the game variable to the matching game object
				game = currentGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		
//		Instantiates an iterator for the games list.
		Iterator<Game> it = games.iterator();
		
//		Loops through the games list until the last game is reached
		while (it.hasNext()) {
//			Initializes a new variable to reference the current game object in the list
			Game currentGame = it.next();
//			Checks if the next game in the list has a name matching the passed in string
			if (currentGame.getName().equals(name)) {
				// Assigns the game variable to the matching game object
				game = currentGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}

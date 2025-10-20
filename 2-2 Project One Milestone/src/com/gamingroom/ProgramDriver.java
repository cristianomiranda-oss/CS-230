package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author Cristiano Miranda
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
//		Obtains and stores the singular GameService Object
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// Attempts to initialize with some duplicate game data
		Game game3 = service.addGame("Game #1");
		System.out.println(game3);
		
		// gets the current game associated to the passed in string
		Game associatedNameGame = service.getGame("Game #2");
		System.out.println(associatedNameGame);
		
//		Initializes a long id value 
		long gameID = 1;
		// gets the current game associated to the passed in long value
		Game associatedIdGame = service.getGame(gameID);
		System.out.println(associatedIdGame);
				
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}

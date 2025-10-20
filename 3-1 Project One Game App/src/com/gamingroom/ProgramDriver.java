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
		
		System.out.println("\nAbout to test initializing game instances...");
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		System.out.println("\nAbout to test initializing duplicate game instances...");
		// Attempts to initialize with some duplicate game data
		Game duplicateGame = service.addGame("Game #1");
		System.out.println(duplicateGame);
		
		System.out.println("\nAbout to test getting game instances...");
		// gets the current game associated to the passed in string
		Game associatedNameGame = service.getGame("Game #2");
		System.out.println(associatedNameGame);
		
		//	Initializes a long id value 
		long gameID = 1;
		// gets the current game associated to the passed in long value
		Game associatedIdGame = service.getGame(gameID);
		System.out.println(associatedIdGame);
		
		System.out.println("\nAbout to test initializing team instances...");
		// Adds new teams to first game
		Team game1Team1 = game1.addTeam("Testers");
		Team game1Team2 = game1.addTeam("Developers");
		System.out.println(game1Team1);
		System.out.println(game1Team2);
		
		// Adds new teams to second game
		Team game2Team1 = game2.addTeam("Product Manager");
		Team game2Team2 = game2.addTeam("Owner");
		System.out.println(game2Team1);
		System.out.println(game2Team2);
		
		System.out.println("\nAbout to test initializing duplicate team instances...");
		Team game2Team3 = game2.addTeam("Product Manager");
		System.out.println(game2Team3);
		
		System.out.println("\nAbout to test initializing player instances...");
		// Adds players to first team for first game
		Player game1Team1plyr1 = game1Team1.addPlayer("Dave");
		Player game1Team1plyr2 = game1Team1.addPlayer("Mark");
		System.out.println(game1Team1plyr1);
		System.out.println(game1Team1plyr2);
		
		// Adds players to first team for second game
		Player game2Team1plyr1 = game2Team1.addPlayer("Sara");
		Player game2Team1plyr2 = game2Team1.addPlayer("Ali");
		System.out.println(game2Team1plyr1);
		System.out.println(game2Team1plyr2);
		
		System.out.println("\nAbout to test initializing duplicate player instances...");
		Player game1Team1plyr3 = game2Team1.addPlayer("Sara");
		System.out.println(game1Team1plyr3);
		
		
				
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}

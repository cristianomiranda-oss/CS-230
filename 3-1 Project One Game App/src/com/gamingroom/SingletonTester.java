package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author Cristiano Miranda
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
//		Obtains and stores the singular GameService Object
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (long i = 1; i <= service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}

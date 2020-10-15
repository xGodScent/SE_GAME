// package
package SEpackage;

// imports
import java.awt.Graphics;
import java.io.IOException;





// GameEngine class
public class GameEngine {

	// [OTHER TYPE METHODS]
	// main method
	public static void main(String[] args) {
		
		log("Heating up game engine... (OwO) ");
		
		// load in game
		LOAD_GAME.start();
		
		// create game window
		
		
		
		
		
		// remove this later
		log("Im Out! \\(°Ω°)/ ");
		System.exit(0); 
		
	}
	
	// LOG (to console) method
	public static void log(String toConsole) {
		
		System.out.println("[CONSOLE:~$] : " + toConsole + ";");

	}
	
	
	// -------------------------------------------------------------------------------------------------------------------------!
	
	// [VARIABLES]
	public static int lives = 3;
	public static int kills = 0;
	public static int time = 0;
	public static int xpos;
	public static int ypos;
	
	// 0 = hasnt started
	// 1 = in progress
	// 2 = died
	// 3 = Finished
	public int gameState = 0;
	
	static String user = Main.user;
	static int slot = Main.slot;
	static int[] requestedData;
	
	public int ticks;
	public int fps;
	public int tps;
	
	public String temp;

	
	 
	// [GAME]
	
	
	// renders everything on screen (players, enemies etc)
	public void render(Graphics g) {
		
		// render loop
		
		
	}
	
	
	
	
	// updates loop (updates variables etc & player positions)
	public void update() {
		
		// update loop
		
		
	}
	
	
	
	
	// [THREADS]
	static Thread SAVE_GAME = new Thread() {
		public void run() {
		
			log("Ran SAVE_GAME thread");
			
			int[] data = {xpos, ypos, lives, kills, time};
			try {
				
				requestSave.toFile(data, user, slot);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			log("Finished SAVE_GAME thread");
			
		}
		
	};
	
	static Thread LOAD_GAME = new Thread() {
		public void run() {
			
			log("Ran LOAD_GAME thread");
		
			requestedData = requestLoad.getFromFile(user, slot);
			
			log("Finished LOAD_GAME thread");
			
		}
		
	};
	
	
} // GameEngine class

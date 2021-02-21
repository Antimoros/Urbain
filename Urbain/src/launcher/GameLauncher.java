package launcher;

public class GameLauncher {
	public static void main(String[] args) {

		StarterUrbain starterUrbain = new StarterUrbain();

		Thread gameThread = new Thread(starterUrbain);
		gameThread.start();
	}
	
}

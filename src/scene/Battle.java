package scene;

import helper.Color;

public class Battle {
	Color c = new Color();
	
	public Battle() {
		// TODO Auto-generated constructor stub
	}
	
	void monsterTurn() {
		String ascii = c.RED + "   _____                          __                 ___________                   \r\n"
				+ "  /     \\   ____   ____   _______/  |_  ___________  \\__    ___/_ _________  ____  \r\n"
				+ " /  \\ /  \\ /  _ \\ /    \\ /  ___/\\   __\\/ __ \\_  __ \\   |    | |  |  \\_  __ \\/    \\ \r\n"
				+ "/    Y    (  <_> )   |  \\\\___ \\  |  | \\  ___/|  | \\/   |    | |  |  /|  | \\/   |  \\\r\n"
				+ "\\____|__  /\\____/|___|  /____  > |__|  \\___  >__|      |____| |____/ |__|  |___|  /\r\n"
				+ "        \\/            \\/     \\/            \\/                                   \\/ " + c.RESET;
		
		System.out.println(ascii);
	}

	void userTurn() {
		String ascii = "   _____   __    __                 __   .__                \r\n"
				+ "  /  _  \\_/  |__/  |______    ____ |  | _|__| ____    ____  \r\n"
				+ " /  /_\\  \\   __\\   __\\__  \\ _/ ___\\|  |/ /  |/    \\  / ___\\ \r\n"
				+ "/    |    \\  |  |  |  / __ \\\\  \\___|    <|  |   |  \\/ /_/  >\r\n"
				+ "\\____|__  /__|  |__| (____  /\\___  >__|_ \\__|___|  /\\___  / \r\n"
				+ "        \\/                \\/     \\/     \\/       \\//_____/  ";
		
		System.out.print(ascii);
	
	}
	
	public void menuBattle() {
//		userTurn();
		monsterTurn();
	}
}

package main;

import helper.Helper;
public class Menus implements Helper{
	public Menus() {
	}
	
	public void enter() {
		System.out.print("Please press enter to continue");
		s.nextLine();
	}
	
	public void cls() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	void guide() {
		
	}
	
	public void game() {
		f.clr();
		
		String play = "__________.____       _____ _____.___.\r\n"
				+ "\\______   \\    |     /  _  \\\\__  |   |\r\n"
				+ " |     ___/    |    /  /_\\  \\/   |   |\r\n"
				+ " |    |   |    |___/    |    \\____   |\r\n"
				+ " |____|   |_______ \\____|__  / ______|\r\n"
				+ "                  \\/       \\/\\/       ";	
		
		System.out.println(c.PURPLE + play + c.RESET);
		
		int choice;
		do {
			System.out.println("1. Start Game");
			System.out.println("2. Game Guide");
			System.out.println("3. Exit Game");
			System.out.print("Choice >> ");
			choice = s.nextInt(); s.nextLine();
		} while (choice < 1 || choice > 3);
	
		switch(choice) {
		case 1:
			map.printCamera(choice, choice);
			while(!endGame) app.move();
		case 2:
			guide();
			break;
		case 3: 
			break;
		}
	}
	
}

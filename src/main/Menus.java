package main;

import helper.Helper;
import helper.Outputs;
import helper.Save;
public class Menus implements Helper, Outputs{
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

package helper;

import handler.Load;
import handler.Save;
import prettifier.Outputs;
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
		System.out.println(c.BRIGHT_BLUE + gameGuide + c.RESET);
		System.out.println();
		
		System.out.println(c.GREEN + "Character Information" + c.RESET);
		System.out.println();
		System.out.println("Coin > O");
		System.out.println("Grass > v | V");
		System.out.println("Character > X");
		System.out.println("Wall > #");
		System.out.println();
		
		System.out.println(c.GREEN + "Keybind Information" +c.RESET);
		System.out.println();
		
		System.out.println("w|a|s|d > move player");
		System.out.println("i       > player inventory");
		System.out.println("z       > shopping");
		System.out.println("e       > exit game and save");
		System.out.println("k       > save");
		
		System.out.println();
		
		System.out.println(c.GREEN + "Cheat Code" +c.RESET);
		System.out.println("kolinngemeng    > add 1000 coin");
		System.out.println("marcobotak    > full HP");
		System.out.println("vincentzigzag    > full mana");
		System.out.println("stiphentapiardi   > random teleport");

		f.enter(true);
		game();
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

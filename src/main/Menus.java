package main;

import java.util.Scanner;

public class Menus {
	public static Scanner s = new Scanner(System.in);
	
	public Menus() {
	}
	
	void enter() {
		System.out.print("Please press enter to continue");
		s.nextLine();
	}
	
	
	void game() {
		int choice;
		System.out.println("1. Start Game");
		System.out.println("2. Game Guide");
		System.out.println("3. Exit Game");
		System.out.print("Choice >> ");
		choice = s.nextInt(); s.nextLine();
	
		switch(choice) {
		case 1:
			
		}
	}
	
	void landingPage() {
		int choice;
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.print("Choice >> ");
		choice = s.nextInt(); s.nextLine();
	
		switch(choice) {
		case 1:
			game();
			break;
		default: 
			landingPage();
			break;
		}
	}
}

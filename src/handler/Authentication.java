package handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import helper.Helper;
import prettifier.Outputs;

public class Authentication implements Helper, Outputs{

	public Authentication() {
//		welcome();
		currPlayer.setAll(30, 30, 300, 80);
		authMenu();
//		menu.game();
	}

	public void welcome() {
		System.out.println(c.YELLOW + welcome + c.RESET);
		f.enter(true);
		f.simulateProgress(100);
		System.out.println();
		f.clr();
	}
	
	public void authMenu() {
		f.clr();
		
		System.out.println();
		System.out.println(c.YELLOW + authMenu + c.RESET);
		System.out.println();
		
		int choice = 0;
		do {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print(">> ");
			choice = s.nextInt(); s.nextLine();
		} while (choice < 1 || choice > 3);
		
		switch(choice) {
		case 1: 
			login();
			break;
		case 2:
			register();
			break;
		case 3:
			System.out.println("Good bye !");
			break;
		}
	}
	
	void register() {
		f.clr();
		
		System.out.println();
		System.out.println(c.BRIGHT_GREEN + registerStr + c.RESET);
		System.out.println();
		String email, password;
		System.out.println(c.YELLOW + "Input 'EXIT' to cancel" + c.RESET);
		
		System.out.print("Input Email >> ");
		email = s.nextLine();
		if(email.equals("EXIT")) authMenu();
		
		System.out.print("Input Password >> ");
		password = s.nextLine();
		if(password.equals("EXIT")) authMenu();
		
		if(!userHandler.loginChecker(email, password)) {
			String value = email + "#" + password + "#80#300.00#30.00#WRHBND";
			
			f.writeFile(value, "credential.txt", true);
			f.clr();
			System.out.println(c.GREEN + success + c.RESET);
			f.sleeping(2000);
			authMenu();
			return;
		} else {
			System.out.println(c.RED + userExist + c.RESET);
			f.sleeping(2000);
			register();
			return;
		}
	}
	
	void login() {
		f.clr();
		
		System.out.println();
		System.out.println(c.BRIGHT_GREEN + loginStr + c.RESET);
		System.out.println();

		String email = "";
		String password = "";
		System.out.println(c.YELLOW + "Input 'EXIT' to cancel" + c.RESET);
		
		System.out.print("Input Email >> ");
		email = s.nextLine();
		if(email.equals("EXIT")) authMenu();
		
		System.out.print("Input Password >> ");
		password = s.nextLine();
		if(password.equals("EXIT")) authMenu();
		
		if(userHandler.loginChecker(email, password)) {
			f.clr();
			System.out.println();
			System.out.println(c.BRIGHT_GREEN + success + c.RESET);
			System.out.println();
			f.sleeping(2000);
			menu.game();
			return;
		} else {
			f.clr();
			System.out.println();
			System.out.println(c.RED + invalid + c.RESET);
			System.out.println();
			f.sleeping(2000);
			login();
			return;
		}
		
	}
	
}

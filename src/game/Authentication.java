package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import helper.Helper;

public class Authentication implements Helper{

	public Authentication() {
		welcome();
		authMenu();

	}

	public void welcome() {
		String welcome = "________   _____________________      __  ____  ___ ________    _____           ________  \r\n"
				+ "\\______ \\  \\_____  \\__    ___/  \\    /  \\ \\   \\/  / \\_____  \\  /  |  |          \\_____  \\ \r\n"
				+ " |    |  \\  /   |   \\|    |  \\   \\/\\/   /  \\     /   /  ____/ /   |  |_  ______  /  ____/ \r\n"
				+ " |    `   \\/    |    \\    |   \\        /   /     \\  /       \\/    ^   / /_____/ /       \\ \r\n"
				+ "/_______  /\\_______  /____|    \\__/\\  /   /___/\\  \\ \\_______ \\____   |          \\_______ \\\r\n"
				+ "        \\/         \\/               \\/          \\_/         \\/    |__|                  \\/";
	
		System.out.println(c.YELLOW + welcome + c.RESET);
		f.loading();
		f.enter(true);
	}
	
	public void authMenu() {
		String authMenu = "   _____          __  .__         _____                       \r\n"
				+ "  /  _  \\  __ ___/  |_|  |__     /     \\   ____   ____  __ __ \r\n"
				+ " /  /_\\  \\|  |  \\   __\\  |  \\   /  \\ /  \\_/ __ \\ /    \\|  |  \\\r\n"
				+ "/    |    \\  |  /|  | |   Y  \\ /    Y    \\  ___/|   |  \\  |  /\r\n"
				+ "\\____|__  /____/ |__| |___|  / \\____|__  /\\___  >___|  /____/ \r\n"
				+ "        \\/                 \\/          \\/     \\/     \\/       ";
		
		System.out.println(c.YELLOW + authMenu + c.RESET);
		
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
		}
	}
	
	void register() {
		
	}
	
	void login() {
		String email, password;
		System.out.println(c.YELLOW + "Input 'EXIT' to cancel" + c.RESET);
		
		System.out.print("Input Email >> ");
		email = s.nextLine();
		if(email.equals("EXIT")) authMenu();
		
		System.out.print("Input Password >> ");
		password = s.nextLine();
		if(password.equals("EXIT")) authMenu();
		
		if(userHandler.loginChecker("aa@mail.com", "123")) {
			menu.game();
			return;
		} else {
			System.out.println(c.RED + "Invalid Credentials !" + c.RESET);
			login();
			return;
		}
		
	}
	
}

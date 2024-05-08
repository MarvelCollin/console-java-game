package scene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import helper.Helper;
import item.Defensive;
import item.Offensive;
import item.Spell;
import main.Menus;
import monster.Agility;
import monster.Intelligence;
import monster.Strength;
import parent.Item;

public class Shop implements Helper{
	ArrayList<Defensive> defensive = new ArrayList<Defensive>();
	ArrayList<Offensive> offensive = new ArrayList<Offensive>();
	ArrayList<Spell> spell = new ArrayList<Spell>();
	Menus menu;
	
	public Shop() {
	    init();
	    menu();
	    
	}

	void menu() {
		menu.cls();
		String shopAscii = "  _________.__                       _____                       \r\n"
				+ " /   _____/|  |__   ____ ______     /     \\   ____   ____  __ __ \r\n"
				+ " \\_____  \\ |  |  \\ /  _ \\\\____ \\   /  \\ /  \\_/ __ \\ /    \\|  |  \\\r\n"
				+ " /        \\|   Y  (  <_> )  |_> > /    Y    \\  ___/|   |  \\  |  /\r\n"
				+ "/_______  /|___|  /\\____/|   __/  \\____|__  /\\___  >___|  /____/ \r\n"
				+ "        \\/      \\/       |__|             \\/     \\/     \\/       ";
		
		int choice = 0;
		
		System.out.println(c.CYAN + shopAscii + c.RESET);
		
		System.out.println("1. Buy Offensive Item");
		System.out.println("2. Buy Defensive Item");
		System.out.println("3. Buy Spells Item");
		System.out.println("4. Exit");
		choice = s.nextInt(); s.nextLine();
		
		switch(choice) {
		case 1: 
			printList("Offensive", offensive);
			break;
		case 2: 
			printList("Defensive", defensive);
			break;
		case 3:
			printList("Spell", spell);
			break;
		default: 
			break;
		}
		
		String whichItem = "";
		System.out.print("Input item's ID ['EXIT' to cancel] >> ");
		whichItem = s.nextLine();
		
	}

	void printList(String header, List<? extends Item> items) {
		System.out.println();
		items.get(0).ascii();
		System.out.println();
	    printHead();
	    if (!items.isEmpty()) {
	        for (Item item : items) {
	            item.display();
	        }
	    }
	    printBottom();
	}

	
	Integer toInt(String str) {
		return Integer.parseInt(str);
	}
	
	public void printHead() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "ATTACK", "MAX USE");
        System.out.println("----------------------------------------------------------------------------");
	}
	
	public void printBottom() {
		System.out.println("----------------------------------------------------------------------------");
	}
	
	void readFile(String filePath) {
	    try {
	        List<String> lines = Files.readAllLines(Paths.get(filePath));

	        for (String line : lines) {
	            String[] parts = line.split("#", 6);
	            String type = parts[2];

	            switch (type) {
	                case "spell":
	                    spell.add(new Spell(parts[0], parts[1], type, toInt(parts[3]), toInt(parts[4]), toInt(parts[5])));
	                    break;
	                case "defensive":
	                    defensive.add(new Defensive(parts[0], parts[1], type, toInt(parts[3]), toInt(parts[4]), toInt(parts[5])));
	                    break;
	                case "offensive":
	                	offensive.add(new Offensive(parts[0], parts[1], type, toInt(parts[3]), toInt(parts[4]), toInt(parts[5])));
	                    break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	void init() {
		defensive.removeAll(defensive);
		offensive.removeAll(offensive);
		spell.removeAll(spell);
		
		readFile("item.txt");
	}
}

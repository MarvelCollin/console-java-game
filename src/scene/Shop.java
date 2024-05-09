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
	ArrayList<Defensive> defensiveShop = new ArrayList<Defensive>();
	ArrayList<Offensive> offensiveShop = new ArrayList<Offensive>();
	ArrayList<Spell> spellShop = new ArrayList<Spell>();

	public void menu() {
		init();
		f.clr();
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
		do {
			System.out.print(">> ");
			choice = s.nextInt(); s.nextLine();
			
			switch(choice) {
			case 1: 
				printList("Offensive");
				break;
			case 2: 
				printList("Defensive");
				break;
			case 3:
				printList("Spell");
				break;
			case 4:
				break;
			}
		} while (choice < 1 || choice > 4);
		
		String whichItem = "";
		Item items;
		do {
			System.out.print("Input item's ID ['EXIT' to cancel] >> ");
			whichItem = s.nextLine();
			if(whichItem.equals("EXIT")) return;
			items = getDetail(whichItem);
		} while (whichItem.length() < 1 || items == null);
		
	}

	Item getDetail(String ID) {
		// 1 -> off, 2 -> def, 3 -> spell
		for (Offensive o : offensiveShop) {
			if(ID.equals(o.getId())) {
				return o;
			}
		}
		
		for (Defensive o : defensiveShop) {
			if(ID.equals(o.getId())) {
				return o;
			}
		}
		for (Spell o : spellShop) {
			if(ID.equals(o.getId())) {
				return o;
			}
		}
		
		return null;
		
		
	}
	
	void printList(String header) {
		menu.cls();
		System.out.println();
		System.out.println();
	    
		if(header.equals("Defensive")) {
			defensiveShop.get(0).ascii();
			printHead();
			for (Defensive d : defensiveShop) {
				d.display(d.getDeflect(), d.getMaxUse());
			}
		} else if(header.equals("Offensive")) {
			offensiveShop.get(0).ascii();
			printHead();
			for (Offensive d : offensiveShop) {
				d.display(d.getDamage(), d.getMaxUse());
			}
		} else if(header.equals("Spell")) {
			spellShop.get(0).ascii();
			printHead();
			for (Spell d : spellShop) {
				d.display(d.getDamage(), d.getMana());
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
	                    spellShop.add(new Spell(parts[0], parts[1], type, toInt(parts[3]), toInt(parts[4]), toInt(parts[5])));
	                    break;
	                case "defensive":
	                    defensiveShop.add(new Defensive(parts[0], parts[1], type, toInt(parts[3]), toInt(parts[4]), toInt(parts[5])));
	                    break;
	                case "offensive":
	                	offensiveShop.add(new Offensive(parts[0], parts[1], type, toInt(parts[3]), toInt(parts[4]), toInt(parts[5])));
	                    break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	void init() {
		// temp way
		defensiveShop.removeAll(defensiveShop);
		offensiveShop.removeAll(offensiveShop);
		spellShop.removeAll(spellShop);
		
		readFile("item.txt");
	}
}

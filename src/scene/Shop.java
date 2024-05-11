package scene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import helper.Helper;
import helper.Menus;
import helper.Setting;
import item.Defensive;
import item.Offensive;
import item.Spell;
import monster.Agility;
import monster.Intelligence;
import monster.Strength;
import parent.Item;
import prettifier.Outputs;

public class Shop implements Helper, Outputs, Setting{
	public void menu() {
		int currChoice = 0;
		f.clr();
		int choice = 0;
		
		System.out.println(c.CYAN + shopOutput + c.RESET);
		
		System.out.println("1. Buy Offensive Item");
		System.out.println("2. Buy Defensive Item");
		System.out.println("3. Buy Spells Item");
		System.out.println("4. Restore 50 Health for 30 coins");
		System.out.println("5. Exit");
		do {
			System.out.print(">> ");
			choice = s.nextInt(); s.nextLine();
			
			switch(choice) {
			case 1: 
				printList("Offensive");
				currChoice = 1;
				break;
			case 2: 
				printList("Defensive");
				currChoice = 2;
				break;
			case 3:
				printList("Spell");
				currChoice = 3;
				break;
			case 4:
				System.out.println(c.BRIGHT_GREEN + "Restoring 50 Health..." + c.RESET);
				currPlayer.setHealth(currPlayer.getHealth() + 40);
				currPlayer.setMoney(currPlayer.getMoney() - 30);
				break;
			case 5:
				break;
			}
		} while (choice < 1 || choice > 5);
		
		String whichItem = "";
		Item items;
		do {
			System.out.print("Input item's ID ['EXIT' to cancel] >> ");
			whichItem = s.nextLine();
			if(whichItem.equals("EXIT")) return;
			items = getDetail(whichItem);
			if(items != null && currPlayer.getMoney() < items.getPrice()) {
				System.out.println(c.RED + "Not enough item to buy !. GET AWAY FROM HERE !!" + c.RESET);
				f.sleeping(1000);
				f.enter(true);
				return;
			}
			if(items != null) {
				switch(currChoice) {
				case 1:
					currOffensive.add((Offensive) items);
					currOffensive.get(currOffensive.size() - 1).setUseLeft(currOffensive.get(currOffensive.size() - 1).getMaxUse());
					break;
				case 2:
					currDefensive.add((Defensive) items);
					currDefensive.get(currDefensive.size() - 1).setUseLeft(currDefensive.get(currDefensive.size() - 1).getMaxUse());
					break;
				case 3:
					currSpell.add((Spell) items);
					break;
				}
				
				currPlayer.setMoney(currPlayer.getMoney() - items.getPrice());
				System.out.println(c.BRIGHT_GREEN + "Successfully bought " + items.getName() + c.RESET);
				f.sleeping(1000);
				f.enter(true);
			}
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
	                    spellShop.add(new Spell(parts[0], parts[1], type, toInt(parts[3]), 0, toInt(parts[4]), toInt(parts[5])));
	                    break;
	                case "defensive":
	                    defensiveShop.add(new Defensive(parts[0], parts[1], type, toInt(parts[3]),0 , toInt(parts[4]), toInt(parts[5])));
	                    break;
	                case "offensive":
	                	offensiveShop.add(new Offensive(parts[0], parts[1], type, toInt(parts[3]), 0, toInt(parts[4]), toInt(parts[5])));
	                    break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void init() {
		// temp way
		defensiveShop.removeAll(defensiveShop);
		offensiveShop.removeAll(offensiveShop);
		spellShop.removeAll(spellShop);
		
		readFile(itemTxt);
	}
}

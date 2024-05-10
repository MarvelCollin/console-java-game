package game;

import helper.Helper;
import helper.Outputs;
import item.Defensive;
import item.Offensive;
import item.Spell;

public class Player implements Helper, Outputs{
	private int damage, mana, health, money;
	public Player(int damage, int mana, int health, int money) {
		super();
		this.damage = damage;
		this.mana = mana;
		this.health = health;
		this.money = money;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void printStats() {
	    System.out.println(c.GREEN);
	    System.out.println("--Current Player Stats--");

	    System.out.println("+----------------------+");
	    System.out.printf("| %-10s | %-7d |\n", "Health:", getHealth());
	    System.out.printf("| %-10s | %-7d |\n", "Damage:", getDamage());
	    System.out.printf("| %-10s | %-7d |\n", "Mana:", getMana());
	    System.out.printf("| %-10s | %-7d |\n", "Money:", getMoney());
	    System.out.println("+----------------------+");
	    
	    System.out.println(c.RESET);
	}

	
	public int getDamageItem() {
		return 10;
	}
	
	public int menuAttack() {
		int choice;
		System.out.println();
		System.out.println("1. Normal Attack");
		System.out.println("2. Attack with item");
		System.out.println("3. Store Mana");
		System.out.print("Choice >> ");
		choice = s.nextInt(); s.nextLine();
		
		System.out.println();
		switch(choice) {
		case 1: 
			System.out.println(c.BRIGHT_GREEN + "User attack with Base Damage > " + getDamage() + c.RESET);
			return getDamage();
		case 2:
			System.out.println(c.BRIGHT_GREEN + "User attack with item > " + (getDamage() + getDamageItem()) + c.RESET);
			return getDamage() + getDamageItem();
		case 3:
			System.out.println(c.BRIGHT_BLUE + "Storing 10 mana" + c.RESET);
			return -10;
		default:
			menuAttack();
			break;
		}
		
		return getDamage();
	}

	public void setAll(int damage, int mana, int health, int money) {
		this.damage = damage;
		this.mana = mana;
		this.health = health;
		this.money = money;
	}
	
	public void displayCurr() {
		System.out.println(c.BLUE + itemsO + c.RESET);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "DEFLECT", "MAX USE", "USE LEFT");
        System.out.println("----------------------------------------------------------------------------------------");
		
        for (Defensive d : currDefensive) {
        	System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s  | %-8s | %-8s |%n", d.getId(),d.getName(), d.getType(), d.getPrice(), d.getDeflect(), d.getMaxUse(), d.getUseLeft());
		}
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println();
        
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "DAMAGE", "MAX USE", "USE LEFT");
        System.out.println("---------------------------------------------------------------------------------------");
        
        for (Offensive d : currOffensive) {
        	System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s | %-8s | %-8s |%n", d.getId(),d.getName(), d.getType(), d.getPrice(), d.getDamage(), d.getMaxUse(), d.getUseLeft());
        }
        System.out.println("---------------------------------------------------------------------------------------");
        
        System.out.println();
        
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "DAMAGE", "MANA");
        System.out.println("----------------------------------------------------------------------------");
        
        for (Spell d : currSpell) {
        	System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s | %-8s |%n", d.getId(),d.getName(), d.getType(), d.getPrice(), d.getDamage(), d.getMana());
        }
        
        System.out.println("----------------------------------------------------------------------------");
        f.enter(true);
	}
	
}

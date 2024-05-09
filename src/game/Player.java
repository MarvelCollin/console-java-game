package game;

import helper.Helper;

public class Player implements Helper{
	private int damage, mana, health, money;
	private String offensive;
	private int offUsed;
	private String defensive;
	private int armorLeft;
	private String spell;
	private int spellUsed;
	
	public Player(int damage, int mana, int health, int money, String offensive, int offUsed, String defensive,
			int armorLeft, String spell, int spellUsed) {
		super();
		this.damage = damage;
		this.mana = mana;
		this.health = health;
		this.money = money;
		this.offensive = offensive;
		this.offUsed = offUsed;
		this.defensive = defensive;
		this.armorLeft = armorLeft;
		this.spell = spell;
		this.spellUsed = spellUsed;
	}
	
	public String getOffensive() {
		return offensive;
	}

	public void setOffensive(String offensive) {
		this.offensive = offensive;
	}

	public int getOffUsed() {
		return offUsed;
	}

	public void setOffUsed(int offUsed) {
		this.offUsed = offUsed;
	}

	public String getDefensive() {
		return defensive;
	}

	public void setDefensive(String defensive) {
		this.defensive = defensive;
	}

	public int getArmorLeft() {
		return armorLeft;
	}

	public void setArmorLeft(int armorLeft) {
		this.armorLeft = armorLeft;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public int getSpellUsed() {
		return spellUsed;
	}

	public void setSpellUsed(int spellUsed) {
		this.spellUsed = spellUsed;
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
	    System.out.println(c.BACKGROUND_BLACK);

	    System.out.println("+----------------------+");
	    System.out.printf("| %-10s | %-7d |\n", "Health:", getHealth());
	    System.out.printf("| %-10s | %-7d |\n", "Damage:", getDamage());
	    System.out.printf("| %-10s | %-7d |\n", "Mana:", getMana());
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
			System.out.println("User attack with Base Damage > " + getDamage() + c.RESET);
			return getDamage();
		case 2:
			System.out.println("User attack with item > " + (getDamage() + getDamageItem()) + c.RESET);
			return getDamage() + getDamageItem();
		case 3:
			System.out.println("Storing 10 mana" + c.RESET);
			return -10;
//			return setMana();
		default:
			menuAttack();
			break;
		}
		
		return getDamage();
	}

	public void setAll(int damage, int mana, int health, int money, String offensive, int offUsed, String defensive,
			int armorLeft, String spell, int spellUsed) {
		this.damage = damage;
		this.mana = mana;
		this.health = health;
		this.money = money;
		this.offensive = offensive;
		this.offUsed = offUsed;
		this.defensive = defensive;
		this.armorLeft = armorLeft;
		this.spell = spell;
		this.spellUsed = spellUsed;
	}
	
}

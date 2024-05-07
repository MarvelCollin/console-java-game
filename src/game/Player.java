package game;

import helper.Helper;

public class Player implements Helper{
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
        System.out.println(c.BACKGROUND_BLACK + "Monster Stats: ");
        System.out.println("Health: " + getHealth() + " ");
        System.out.println("Damage: " + getDamage() + " ");
        System.out.println("Mana: " + getMana() + " " + c.RESET);
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

}

package game;

import helper.Color;

public class Player {
	Color c = new Color();
	
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
	
	public int menuAttack() {
		int choice;
		
		System.out.println("1. Normal Attack");
		System.out.println("2. Attack with item");
		System.out.println("3. Store Mana");
		
	}

}

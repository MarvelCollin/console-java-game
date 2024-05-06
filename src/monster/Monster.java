package monster;

import java.util.Random;

import helper.Color;
import helper.Function;

public abstract class Monster {
	String name;
	int damage;
	int health;
	String type;
	
	Function f = new Function();
	Color c = new Color();
	public Random r = new Random();
	
	public Monster(String name) {
		super();
		this.name = name;
	}
	
	public abstract int attack();
	public abstract int initDamage();
	public abstract int receiveDamage();
	public abstract int initHealth();
	public abstract int initArmor();

	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String name) {
		this.type = type;
	}
	
	public void printStats() {
		System.out.println(c.WHITE);
        System.out.println(c.BACKGROUND_BLACK + "Monster Stats: ");
        System.out.println("Name: " + getName() + " ");
        System.out.println("Type: " + getType() + " ");
        System.out.println("Damage: " + getDamage() + " ");
        System.out.println("Health: " + getHealth() + " " + c.RESET);
	}
}

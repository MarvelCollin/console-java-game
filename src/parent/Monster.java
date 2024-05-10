package parent;

import java.util.Random;

import helper.Color;
import helper.Function;
import helper.Helper;

public abstract class Monster implements Helper{
	protected String name;
	protected int damage;
	protected int health;
	protected String type;
	
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
	    System.out.println(c.RED);
	    System.out.println("--Current Monster Stats--");

	    System.out.println("+---------------------------------+");
	    System.out.printf("| %-10s | %-18s |\n", "Name:", getName());
	    System.out.printf("| %-10s | %-18s |\n", "Type:", getType());
	    System.out.printf("| %-10s | %-18d |\n", "Damage:", getDamage());
	    System.out.printf("| %-10s | %-18d |\n", "Health:", getHealth());
	    System.out.println("+---------------------------------+");

	    System.out.println(c.RESET);
	}

}

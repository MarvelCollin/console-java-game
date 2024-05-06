package monster;

import java.util.Random;

import helper.Function;

public abstract class Monster {
	String name;
	int damage;
	int health;
	
	Function f = new Function();
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
	
	public void printStats() {
        System.out.println("Monster Stats:");
        System.out.println("Damage: " + damage);
        System.out.println("Health: " + health);
	}
}

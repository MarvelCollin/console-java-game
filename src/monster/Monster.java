package monster;

import java.util.Random;

public abstract class Monster {
	int damage;
	int health;
	
	public Random r = new Random();
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

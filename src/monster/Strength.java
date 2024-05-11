package monster;

import java.util.Random;

import parent.Monster;
import prettifier.Color;

public class Strength extends Monster{
	int armor;
	public Strength(String name) {
		super(name);
		damage = initDamage();
		health = initHealth();
		type = "Strength";
		armor = initArmor();
	}

	public int initArmor() {
		return f.random(20, 40);
	}

	@Override
	public int attack() {	
		int damage = initDamage();
		System.out.println(c.BRIGHT_RED + getName() + " Attack with base damage " + damage);
		System.out.println("Damage received " + damage + c.RESET);
		
		return damage;
	}

	@Override
	public int initDamage() {
		return f.random(20, 30);
	}


	@Override
	public int initHealth() {
		return f.random(200, 210) - getDamage();
	}

	@Override
	public int receivedDamage(int damage) {
		int damageDeflected = damage - this.armor;
		Random r = new Random();
		
		int random = r.nextInt(3);
		if(random == 3) return damage;
		if(random == 2) return 0;
		
		if(damageDeflected < 0) return 0;
		
		setHealth(getHealth() - damageDeflected);
		return damageDeflected;
	}
	
	//MARVELL COLLIIIII


}

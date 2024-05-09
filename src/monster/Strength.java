package monster;

import helper.Color;
import parent.Monster;

public class Strength extends Monster{
	int armor;
	public Strength(String name) {
		super(name);
		damage = initDamage();
		health = initHealth();
		type = "Strength";
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
	public int receiveDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int initHealth() {
		return f.random(200, 210) - getDamage();
	}



}

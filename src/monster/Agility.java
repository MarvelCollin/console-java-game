package monster;

import parent.Monster;

public class Agility extends Monster{
	int critical;
	
	public Agility(String name) {
		super(name);
		damage = initDamage();
		health = initHealth();
		type = "Agility";
	}

	@Override
	public int attack() {	
		critical = f.random(1,3);
		int damage = this.damage * critical;
		System.out.println(c.BRIGHT_RED + "Attack with base damage > " + this.damage);
		if(critical != 1) {
			System.out.println(getName() + " is a Agility Hero, Using skills with damage critical " + damage);
		}
		
		System.out.println();
		System.out.println("Receive damage " + damage + c.RESET);
		
		return damage;
	}

	@Override
	public int initDamage() {
		return f.random(40, 50);
	}

	@Override
	public int initHealth() {
		return f.random(100, 120) - getDamage();
	}

	@Override
	public int initArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int receivedDamage(int damage) {
		setHealth(getHealth() - damage); 
		return damage;
	}


}

package monster;

import parent.Monster;

public class Intelligence extends Monster{
	
	public Intelligence(String name) {
		super(name);
		damage = initDamage();
		health = initHealth();
		type = "Intelligence";
	}

	@Override
	public int attack() {	
		int skills = f.random(30, 49);
		int damage = initDamage();
		System.out.println(c.BRIGHT_RED + getName() + " Attack with damage " + damage );
		System.out.println(getName() + " is a Intelligence Hero, Using skills with damage " + skills );
		
		System.out.println();
		System.out.println("Receive damage " + (damage + skills) + c.RESET);
		return damage + skills;
	}

	@Override
	public int initDamage() {
		return f.random(10,20);
	}

	@Override
	public int receiveDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int initHealth() {
		return f.random(100, 110);
	}

	@Override
	public int initArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

}

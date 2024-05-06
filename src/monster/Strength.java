package monster;

public class Strength extends Monster{
	int armor;
	
	public Strength(String name) {
		super(name);
		damage = initDamage();
		health = initHealth();
	}

	public int initArmor() {
		return f.random(20, 40);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int initDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int receiveDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int initHealth() {
		// TODO Auto-generated method stub
		return 0;
	}



}

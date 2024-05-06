package monster;

public class Agility extends Monster{
	public Agility(String name) {
		super(name);
		damage = initDamage();
		health = initHealth();
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int initDamage() {
		return f.random(40, 50);
	}

	@Override
	public int receiveDamage() {
		// TODO Auto-generated method stub
		return 0;
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


}

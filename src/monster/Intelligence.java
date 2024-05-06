package monster;

public class Intelligence extends Monster{
	
	public Intelligence(String name) {
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

	@Override
	public int initArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

}

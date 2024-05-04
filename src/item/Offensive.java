package item;

public class Offensive extends Item{
	int attack;
	
	public Offensive(String id, String name, String type, int price, int maxUse, int attack) {
		super(id, name, type, price, maxUse);
		this.attack = attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	
}

package item;

import parent.Item;

public class Spell extends Item {
	int attack;
	
	public Spell(String id, String name, String type, int price, int maxUse, int attack) {
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

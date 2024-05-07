package item;

import parent.Item;

public class Defensive extends Item{
	int deflect;
	
	public Defensive(String id, String name, String type, int price, int maxUse, int deflect) {
		super(id, name, type, price, maxUse);
		this.deflect = deflect;
	}

	public int getDeflect() {
		return deflect;
	}

	public void setDeflect(int deflect) {
		this.deflect = deflect;
	}
	
	
	
}

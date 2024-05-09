package item;

import parent.Item;

public class Spell extends Item {
	private int damage;
	private int mana;

	public Spell(String id, String name, String type, int price, int useLeft, int damage, int mana) {
		super(id, name, type, price, useLeft);
		this.damage = damage;
		this.mana = mana;
	}

	public void ascii() {
		String ascii = "  _________             .__  .__   \r\n"
				+ " /   _____/_____   ____ |  | |  |  \r\n"
				+ " \\_____  \\\\____ \\_/ __ \\|  | |  |  \r\n"
				+ " /        \\  |_> >  ___/|  |_|  |__\r\n"
				+ "/_______  /   __/ \\___  >____/____/\r\n"
				+ "        \\/|__|        \\/           ";
		
		
		System.out.println(c.BLUE + ascii + c.RESET);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	
}

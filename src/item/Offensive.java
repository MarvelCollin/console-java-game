package item;

import parent.Item;

public class Offensive extends Item{

	private int damage;
	private int maxUse;

	public Offensive(String id, String name, String type, int price, int useLeft, int damage, int maxUse) {
		super(id, name, type, price, useLeft);
		this.damage = damage;
		this.maxUse = maxUse;
	}
	
	public void ascii() {
		String ascii = "________   _____  _____                    .__              \r\n"
				+ "\\_____  \\_/ ____\\/ ____\\____   ____   _____|__|__  __ ____  \r\n"
				+ " /   |   \\   __\\\\   __\\/ __ \\ /    \\ /  ___/  \\  \\/ // __ \\ \r\n"
				+ "/    |    \\  |   |  | \\  ___/|   |  \\\\___ \\|  |\\   /\\  ___/ \r\n"
				+ "\\_______  /__|   |__|  \\___  >___|  /____  >__| \\_/  \\___  >\r\n"
				+ "        \\/                 \\/     \\/     \\/              \\/ ";
		
		
		System.out.println(c.RED + ascii + c.RESET);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMaxUse() {
		return maxUse;
	}

	public void setMaxUse(int maxUse) {
		this.maxUse = maxUse;
	}

}

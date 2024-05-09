package item;

import java.util.ArrayList;

import parent.Item;

public class Defensive extends Item{
	private int deflect;
	private int maxUse;
	
	public Defensive(String id, String name, String type, int price, int useLeft, int deflect, int maxUse) {
		super(id, name, type, price, useLeft);
		this.deflect = deflect;
		this.maxUse = maxUse;
	}
	
	
	public void ascii() {
		String ascii = "________          _____                    .__              \r\n"
				+ "\\______ \\   _____/ ____\\____   ____   _____|__|__  __ ____  \r\n"
				+ " |    |  \\_/ __ \\   __\\/ __ \\ /    \\ /  ___/  \\  \\/ // __ \\ \r\n"
				+ " |    `   \\  ___/|  | \\  ___/|   |  \\\\___ \\|  |\\   /\\  ___/ \r\n"
				+ "/_______  /\\___  >__|  \\___  >___|  /____  >__| \\_/  \\___  >\r\n"
				+ "        \\/     \\/          \\/     \\/     \\/              \\/ ";
		
		
		System.out.println(c.GREEN + ascii + c.RESET);
	}

	public int getDeflect() {
		return deflect;
	}

	public void setDeflect(int deflect) {
		this.deflect = deflect;
	}

	public int getMaxUse() {
		return maxUse;
	}

	public void setMaxUse(int maxUse) {
		this.maxUse = maxUse;
	}

}


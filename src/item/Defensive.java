package item;

import java.util.ArrayList;

import parent.Item;

public class Defensive extends Item{
	public Defensive(String id, String name, String type, int value, int price, int maxUse) {
		super(id, name, type, value, price, maxUse);
		// TODO Auto-generated constructor stub
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

}


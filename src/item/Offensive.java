package item;

import parent.Item;

public class Offensive extends Item{

	public Offensive(String id, String name, String type, int value, int price, int maxUse) {
		super(id, name, type, value, price, maxUse);
		// TODO Auto-generated constructor stub
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
}

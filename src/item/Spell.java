package item;

import parent.Item;

public class Spell extends Item {

	public Spell(String id, String name, String type, int value, int price, int maxUse) {
		super(id, name, type, value, price, maxUse);
		// TODO Auto-generated constructor stub
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
}

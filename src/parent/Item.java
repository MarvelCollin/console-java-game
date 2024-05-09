package parent;

import helper.Helper;

public class Item implements Helper{
	private String id;
	private String name;
	private String type;
	private int price;
	private int useLeft;
	
	public Item(String id, String name, String type,int price, int useLeft) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.useLeft = useLeft;
	}

	public int getUseLeft() {
		return useLeft;
	}

	public void setUseLeft(int useLeft) {
		this.useLeft = useLeft;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void display(int part1, int part2) {
		System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s | %-8s |%n", getId(), getName(), getType(),getPrice(), part1, part2);
	}

	public void ascii() {
		//override
	}
}
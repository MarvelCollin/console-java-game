package item;

public class Item {
	String id;
	String name;
	String type;
	int price;
	int maxUse;
	
	public Item(String id, String name, String type, int price, int maxUse) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.maxUse = maxUse;
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

	public int getMaxUse() {
		return maxUse;
	}

	public void setMaxUse(int maxUse) {
		this.maxUse = maxUse;
	}
	
	
	
	
}

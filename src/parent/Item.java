package parent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import helper.Helper;

public class Item implements Helper{
	private String id;
	private String name;
	private String type;
	private int value;
	private int price;
	private int maxUse;
	
	public Item(String id, String name, String type, int value, int price, int maxUse) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.value = value;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
	
	public void display() {
		System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s | %-8s |%n", getId(), getName(), getType(),getPrice(), getValue(), getMaxUse());
	}

	public void ascii() {
		//override
	}
}
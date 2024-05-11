package game;

import helper.Helper;
import item.Defensive;
import item.Offensive;
import item.Spell;
import prettifier.Outputs;

public class Player implements Helper, Outputs{
	private int damage, mana, health, money;
	private String email, password;
	
	public Player(int damage, int mana, int health, int money) {
		super();
		this.damage = damage;
		this.mana = mana;
		this.health = health;
		this.money = money;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		if(mana > 30) {
			this.mana = 30;
		} else {
			this.mana = mana;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health > 300) {
			this.health = 300;
		} else {
			this.health = health;
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void addMoney(int money) {
		setMoney(getMoney() + money);
	}
	
	public void printStats() {
	    System.out.println(c.GREEN);
	    System.out.println("--Current Player Stats--");

	    System.out.println("+----------------------+");
	    System.out.printf("| %-10s | %-7d |\n", "Health:", getHealth());
	    System.out.printf("| %-10s | %-7d |\n", "Damage:", getDamage());
	    System.out.printf("| %-10s | %-7d |\n", "Mana:", getMana());
	    System.out.printf("| %-10s | %-7d |\n", "Money:", getMoney());
	    System.out.println("+----------------------+");
	    
	    System.out.println(c.RESET);
	}

	
	public int getDamageItem(String id) {
		for (Offensive o : currOffensive) {
			if(o.getId().equals(id)) {
				int damage = o.getDamage();
				
				System.out.println(c.BRIGHT_GREEN + "You attacked with " + o.getName() + " with damage " + o.getDamage() + c.RESET);
				if(o.getUseLeft() == 1) {
					System.out.println(c.RED + o.getName() + " cant be used anymore. throwing to trashcan..." + c.RESET);
					currOffensive.remove(o);
				} else {
					o.setUseLeft(o.getUseLeft() - 1);
				}
				return damage;
			}
		}
		
		for (Spell o : currSpell) {
			if(o.getId().equals(id)) {
				if(currPlayer.getMana() < o.getMana()) {
					System.out.println(c.RED + "Ehh!? it seems like you dont have enough mana" + c.RESET);
					return 0;
				}
				System.out.println(c.BRIGHT_GREEN + "You Spell-ed with " + o.getName() + " with damage " + o.getDamage() + c.RESET);
				System.out.println(c.BRIGHT_BLUE + "Cost " + o.getMana() + " Mana" + c.RESET);
				o.setUseLeft(o.getUseLeft() - 1);
				currPlayer.setMana(currPlayer.getMana() - o.getMana());
				return o.getDamage();
			}
		}
		System.out.println(c.RED + "You failed to grab your weapon !" + c.RESET);
		return 0;
	}
	
	public int menuAttack() {
		int choice;
		System.out.println();
		System.out.println("1. Normal Attack");
		System.out.println("2. Attack with item");
		System.out.println("3. Store Mana");
		System.out.print("Choice >> ");
		choice = s.nextInt(); s.nextLine();
		
		System.out.println();
		switch(choice) {
		case 1: 
			System.out.println(c.BRIGHT_GREEN + "User attack with Base Damage > " + getDamage() + c.RESET);
			return getDamage();
		case 2:
			currPlayer.displayOffensive();
			currPlayer.displaySpell();
			
			String choose;
			System.out.print(c.BLUE + "Choose item's ID > " + c.RESET);
			choose = s.nextLine();
			
			return getDamage() + getDamageItem(choose);
		case 3:
			System.out.println(c.BRIGHT_BLUE + "Storing 10 mana" + c.RESET);
			return -10;
		default:
			menuAttack();
			break;
		}
		
		return getDamage();
	}


	public void setAll(int damage, int mana, int health, int money) {
		this.damage = damage;
		this.mana = mana;
		this.health = health;
		this.money = money;
	}
	
	
	public void displayDefensive() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "DEFLECT", "MAX USE", "USE LEFT");
		System.out.println("----------------------------------------------------------------------------------------");
		
		for (Defensive d : currDefensive) {
			System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s  | %-8s | %-8s |%n", d.getId(),d.getName(), d.getType(), d.getPrice(), d.getDeflect(), d.getMaxUse(), d.getUseLeft());
		}
		
		System.out.println("----------------------------------------------------------------------------------------");
	}

	public void displayOffensive() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "DAMAGE", "MAX USE", "USE LEFT");
		System.out.println("---------------------------------------------------------------------------------------");
		
		for (Offensive d : currOffensive) {
			System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s | %-8s | %-8s |%n", d.getId(),d.getName(), d.getType(), d.getPrice(), d.getDamage(), d.getMaxUse(), d.getUseLeft());
		}
		
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	public void displaySpell() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("| %-9s | %-18s | %-10s | %-6s | %-6s | %-8s |%n", "ID", "NAME", "TYPE", "PRICE", "DAMAGE", "MANA");
		System.out.println("----------------------------------------------------------------------------");
		
		for (Spell d : currSpell) {
			System.out.printf("| %-9s | %-18s | %-10s | $%-5s | %-6s | %-8s |%n", d.getId(),d.getName(), d.getType(), d.getPrice(), d.getDamage(), d.getMana());
		}
		
		System.out.println("----------------------------------------------------------------------------");
	}
	
	public void displayCurr() {
		System.out.println(c.BLUE + itemsO + c.RESET);
		displayDefensive();
		System.out.println();
		displayOffensive();
		System.out.println();
		displaySpell();
		f.enter(true);
	}
	
	public int receiveDamage() {
		displayDefensive();
		
		String choose = "";
		System.out.print(c.BLUE + "Choose item's ID [wont use item -> 'NO'] > " + c.RESET);
		choose = s.nextLine();
		if(choose.equals("NO")) {
			System.out.println(c.BRIGHT_BLUE + "Not wearing any armor.. " + c.RESET);
			return 0;
		}
		
		for (Defensive d : currDefensive) {
			if(d.getId().equals(choose)) {
				
				int deflect = d.getDeflect();
				String name = d.getName();
				if(d.getUseLeft() == 1) {
					System.out.println();
					System.out.println(c.RED + "This armor gonna be your last !" + c.RESET);
					System.out.println();
					currDefensive.remove(d);
				}
				
				System.out.println(c.BRIGHT_BLUE + "Succesfully equip " + name + " With deflect > " + deflect + c.RESET);
				d.setUseLeft(d.getUseLeft() - 1);
				
				return d.getDeflect();
			}
		}
		
		System.out.println(c.RED + "You're too late !!" + c.RESET);
		return 0;
	}
}

package scene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import game.Player;
import helper.Color;
import helper.Function;
import helper.Helper;
import helper.Outputs;
import helper.Save;
import monster.Agility;
import monster.Intelligence;
import monster.Strength;
import parent.Monster;

public class Battle implements Helper, Outputs{
	int turns;
	String fileMonster = "monster.txt";
	String monsterName, type;
	Monster monster;
	boolean endBattle = false;
	Player player;
	
	public Battle() {

	}
	
	void monsterTurn() {
		System.out.println(c.PURPLE + monsterAttacking + c.RESET);
		
		monster.printStats();
		System.out.println();
		player.printStats();
		
		int damaged = player.receiveDamage() - monster.attack();
		
		if(damaged > 0) {
			System.out.println(c.BRIGHT_GREEN + "uh.. your armor is too strong, the monster doesnt gave any damage !" + c.RESET);
		} else {
			player.setHealth(player.getHealth() + damaged);
			System.out.println(c.RED + "Total damage received > " + damaged + c.RESET);
		}
		
		f.enter(true);
	}
	
	public void init(Player initPLayer) {
		player = initPLayer;
		
		turns = f.random(0, 1);
		
		 try {
	            List <String> monsters = Files.readAllLines(Paths.get(fileMonster));
	            // setiap nama bakalan ganti
	           
	            int line = f.random(0, 2);
	            
	            String getListMonsters = null;
	            
	            int currLine = 0;
	            getListMonsters = monsters.get(line);
	            for (String m: monsters) {
	            	if(currLine == line) {
	            		getListMonsters = m;
	            		break;
	            	} else {
	            		getListMonsters = "Null#Null";
	            	}
	            	currLine++;
	            }
	            
	            
	            int getHashtag = 1;
	            for (int i = 0; i < getListMonsters.length(); i++) {
					if(getListMonsters.charAt(i) == '#') getHashtag++;
				}
	            
	            String[] parts = getListMonsters.split("#", getHashtag);
	            
	            int whichMonster = f.random(0, getHashtag - 1);
	            monsterName = parts[whichMonster];
	            
	            // 1 -> Strength, 2 -> Intelligence, 3 -> Agility
	            switch(line){
	            case 0:
	            	monster = new Strength(monsterName);
	            	break;
	            case 1:
	            	monster = new Intelligence(monsterName);
	            	break;
	            case 2: 
	            	monster = new Agility(monsterName);
	            	break;
	            }
	        } catch (IOException e) {
	            System.out.println("Failed");
	        }
	}

	void userTurn() {
		System.out.println(c.GREEN + userAttacking + c.RESET);
		
		monster.printStats();	
		System.out.println();
		player.printStats();
		
		int damage = player.menuAttack();
		System.out.println(c.RED + "Attacking with total " + damage + c.RESET);
		if(damage < 0) {
			player.setMana(player.getMana() + 10);
		} else {
			monster.setHealth(monster.getHealth() - damage);
		}
		
		f.enter(true);
	}
	
	
	void whoTurn() {
		if(turns % 2 == 0) {
			monsterTurn();
		} else {
			userTurn();
		}
		
//		System.out.println("Player health " + player.getHealth());
//		System.out.println("Monster health " + monster.getHealth());
		if(player.getHealth() <= 0) {
			System.out.println(c.RED + lose + c.RESET);
			f.sleeping(2000);
			endBattle = true;
		} else if(monster.getHealth() <= 0){
			currPlayer.setMoney(currPlayer.getMoney() + 30);
			System.out.println(c.GREEN + won + c.RESET);
			f.sleeping(2000);
			System.out.print(c.YELLOW + picking30Coin);
			System.out.println(c.RESET);
			System.out.println(c.BRIGHT_GREEN + "Restoring 100 HP..." + c.RESET);
			currPlayer.setHealth(currPlayer.getHealth() + 100);
			f.sleeping(1500);
			endBattle = true;
		}
		turns++;
	}
	
	public void menuBattle() {
		endBattle = false;
		System.out.println(c.YELLOW + huh + c.RESET);
		f.sleeping(1000);
		System.out.println(c.RED + feel);
		System.out.println(watched + c.RESET);
//		System.out.println(c.RED + monsterNearby + c.RESET);
		f.sleeping(2000);
		f.enter(true);
		
		while(!endBattle) {
			whoTurn();
		}
		
//		turns = r.nextInt(1);
		
	}
}

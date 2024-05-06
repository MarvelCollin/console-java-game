package scene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import helper.Color;
import helper.Function;
import monster.Agility;
import monster.Intelligence;
import monster.Strength;

public class Battle {
	Color c = new Color();
	int turns;
	String fileMonster = "monster.txt";
	Function f = new Function();
	String monsterName, type;
	Strength st;
	Agility agl;
	Intelligence intl;
	
	
	public Battle() {
		// TODO Auto-generated constructor stub
	}
	
	void monsterTurn() {
		String ascii = c.RED + "   _____                          __                 ___________                   \r\n"
				+ "  /     \\   ____   ____   _______/  |_  ___________  \\__    ___/_ _________  ____  \r\n"
				+ " /  \\ /  \\ /  _ \\ /    \\ /  ___/\\   __\\/ __ \\_  __ \\   |    | |  |  \\_  __ \\/    \\ \r\n"
				+ "/    Y    (  <_> )   |  \\\\___ \\  |  | \\  ___/|  | \\/   |    | |  |  /|  | \\/   |  \\\r\n"
				+ "\\____|__  /\\____/|___|  /____  > |__|  \\___  >__|      |____| |____/ |__|  |___|  /\r\n"
				+ "        \\/            \\/     \\/            \\/                                   \\/ " + c.RESET;
		
		System.out.println(ascii);
		
		// Defensive items
		
		
	}
	
	void initMonster() {
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
	            
	            int whichMonster = f.random(0, getHashtag);
	            monsterName = parts[whichMonster];
	            
	            // 1 -> Strength, 2 -> Intelligence, 3 -> Agility
	            switch(line){
	            case 1:
	            	Strength strength = new Strength(monsterName);
	            	break;
	            case 2:
	            	Intelligence intelligence = new Intelligence(monsterName);
	            }
	            
	            
	        } catch (IOException e) {
	            System.out.println("Failed");
	        }
	}

	void userTurn() {
		String ascii = "   _____   __    __                 __   .__                \r\n"
				+ "  /  _  \\_/  |__/  |______    ____ |  | _|__| ____    ____  \r\n"
				+ " /  /_\\  \\   __\\   __\\__  \\ _/ ___\\|  |/ /  |/    \\  / ___\\ \r\n"
				+ "/    |    \\  |  |  |  / __ \\\\  \\___|    <|  |   |  \\/ /_/  >\r\n"
				+ "\\____|__  /__|  |__| (____  /\\___  >__|_ \\__|___|  /\\___  / \r\n"
				+ "        \\/                \\/     \\/     \\/       \\//_____/  ";
		
		System.out.print(ascii);
	
	}
	
	
	void whoTurn() {
		if(turns % 2 == 0) {
			monsterTurn();
		} else {
			userTurn();
		}
	}
	
	public void menuBattle() {
//		turns = r.nextInt(1);
		initMonster();
//		monsterTurn();
//		whoTurn();
		
	}
}

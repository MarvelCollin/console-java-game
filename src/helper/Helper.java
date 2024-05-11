package helper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

import game.Map;
import game.Player;
import handler.UserHandler;
import item.Defensive;
import item.Offensive;
import item.Spell;
import main.App;
import prettifier.Color;
import scene.Battle;
import scene.Shop;

public interface Helper {
	Scanner s = new Scanner(System.in);
	Color c = new Color();
	Function f = new Function(); // recalling Function from Helper
	Menus menu = new Menus();
	Map map = new Map();
	Battle battle = new Battle();
	Player currPlayer = new Player(30, 30, 300, 40);
	Validation v = new Validation();
	boolean endGame = false;
	App app = new App();	
	Random r = new Random();
	UserHandler userHandler = new UserHandler();
	Shop shop = new Shop();
	int widthSize = 370;
	int heightSize = 370;
	
	char[][] mapChar = new char[heightSize][widthSize];
	
	ArrayList<Defensive> currDefensive = new ArrayList<Defensive>();
	ArrayList<Offensive> currOffensive = new ArrayList<Offensive>();
	ArrayList<Spell> currSpell = new ArrayList<Spell>();
	
	ArrayList<Defensive> defensiveShop = new ArrayList<Defensive>();
	ArrayList<Offensive> offensiveShop = new ArrayList<Offensive>();
	ArrayList<Spell> spellShop = new ArrayList<Spell>();
}

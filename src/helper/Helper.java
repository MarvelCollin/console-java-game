package helper;

import java.util.Random;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

import game.Map;
import game.Player;
import handler.UserHandler;
import main.App;
import main.Menus;
import scene.Battle;

public interface Helper {
	Scanner s = new Scanner(System.in);
	Color c = new Color();
	Function f = new Function(); // recalling Function from Helper
	Menus menu = new Menus();
	Map map = new Map();
	Battle battle = new Battle();
	Player currPlayer = new Player(30, 30, 300, 40, null, 0, null, 0, null, 0);
	Validation v = new Validation();
	boolean endGame = false;
	App app = new App();	
	Random r = new Random();
	UserHandler userHandler = new UserHandler();
}

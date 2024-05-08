package helper;

import java.util.Scanner;

import game.Map;
import game.Player;
import main.Menus;
import scene.Battle;

public interface Helper {
	Scanner s = new Scanner(System.in);
	Color c = new Color();
	Function f = new Function(); // recalling Function from Helper
	Menus menu = new Menus();
	Map map = new Map();
	Battle battle = new Battle();
	Player currPlayer = new Player(0, 0, 0, 0, null, 0, null, 0, null, 0);
}

package helper;

import java.util.Scanner;

import game.Map;
import main.Menus;
import scene.Battle;

public interface Helper {
	Scanner s = new Scanner(System.in);
	Color c = new Color();
	Function f = new Function();
	Menus menu = new Menus();
	Map map = new Map();
	Battle battle = new Battle();
}

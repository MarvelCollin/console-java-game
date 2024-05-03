package main;

import java.util.Random;

import game.Map;

public class Main {
	Menus menu = new Menus();
	Map map = new Map();
	
	public Main() {
//		menu.enter();
		map.initMap();
		map.printMap();
	}

	public static void main(String[] args) {
		new Main();
	}

}

package main;

import java.util.Random;
import java.util.Scanner;

import game.Map;
import game.Player;
import helper.Color;
import scene.Battle;

public class Main {
	Menus menu = new Menus();
	Map map = new Map();
	Color c = new Color();
	Battle battle = new Battle();
	
	int xPlayer = map.getWidthSize() / 2;
	int yPlayer = map.getHeightSize() / 2;
	Scanner s = new Scanner(System.in);
	Player player = new Player(30, 30, 200, 250);
			
	
	public void move() {
		String input;
		
		System.out.print(">> ");
		input = s.nextLine();
		
		int preX = 0, preY = 0;
		
		
		if(input.equals("w") || input.equals("W")) {
			preY = -1;
		} else if(input.equals("a") || input.equals("A")) {
			preX = -1;
		} else if(input.equals("d") || input.equals("D")) {
			preX = 1;
		} else if(input.equals("s") || input.equals("S")) {
			preY = 1;
		} else {
			move();
			return;
		}
		
		int yCamera = map.getYCamera() / 2;
		int xCamera = map.getXCamera() / 2;
		
		int xShadow = xPlayer + preX + xCamera;
		int yShadow = yPlayer + preY + yCamera;
		
//		map.isPreMoveEmpty(yPlayer + preY + yCamera, xPlayer + preX + xCamera);
		if(map.isPreMoveEmpty(yShadow, xShadow) == false) {
			map.checker(yShadow, xShadow);
		} 
		
		yPlayer += preY;
		xPlayer += preX;
		
		menu.cls(); 
		map.printCamera(yPlayer, xPlayer);
	}
	
	public Main() {
//		menu.enter();
		map.initMap();	
//		map.printMap();
//		map.printCamera(yPlayer, xPlayer);
		battle.init(player);
		battle.menuBattle();
//		while(true) {
//			move();
//		}
	}

	public static void main(String[] args) {
		new Main();
	}

}

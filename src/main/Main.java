package main;

import java.util.Random;
import java.util.Scanner;

import game.Map;

public class Main {
	Menus menu = new Menus();
	Map map = new Map();
	int xPlayer = map.getWidthSize() / 2;
	int yPlayer = map.getHeightSize() / 2;
	Scanner s = new Scanner(System.in);

	public void move() {
		String input;
		
		int tempX, tempY;
		System.out.print(">> ");
		input = s.nextLine();
		
		if(input.equals("w") || input.equals("W")) {
			yPlayer--;
		} else if(input.equals("a") || input.equals("A")) {
			xPlayer--;
		} else if(input.equals("d") || input.equals("D")) {
			xPlayer++;
		} else if(input.equals("s") || input.equals("S")) {
			yPlayer++;
		} else {
			move();
			return;
		}
		
		if(!map.isEmpty(yPlayer, xPlayer)) map.checker(yPlayer, xPlayer);
		
		menu.cls();
		map.printCamera(yPlayer, xPlayer);
	}
	
	public Main() {
//		menu.enter();
		map.initMap();
		map.printMap();
//		map.printCamera(yPlayer, xPlayer);
		
		while(true) {
			move();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}

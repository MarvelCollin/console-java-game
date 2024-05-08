package main;

import game.Player;
import helper.Helper;
import scene.Shop;

public class App implements Helper{
	int xPlayer = map.getWidthSize() / 2;
	int yPlayer = map.getHeightSize() / 2;
	Player player = new Player(30, 30, 200, 250);
	String error = "";
	
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
		
		
		if(yShadow >= map.getHeightSize() - 2 || xShadow >= map.getWidthSize() - 2 || yPlayer <= 5 || xPlayer <= 5) {
			System.out.println(c.RED + "It's Danger Zone, Please GET AWAY !!" + c.RESET);
			xPlayer -= preX;
			yPlayer  -= preY;
//			menu.enter();
		} else if(map.isPreMoveEmpty(yShadow, xShadow) == false) {
			if(map.getValue(yShadow, xShadow) == 'O') {
				player.setMoney(player.getMoney() + 5);
			}
			
			if(map.getValue(yShadow, xShadow) == 'O') {
				map.setValue(' ', yShadow, xShadow);
			}
			map.checker(yShadow, xShadow);
		} 
		
		if(map.getValue(yShadow, xShadow) != '#') {
			yPlayer += preY;
			xPlayer += preX;
		}
		
		menu.cls(); 
		System.out.println(error);
		map.printCamera(yPlayer, xPlayer);
	}
	
	public App() {
		new Shop();
		
//		map.initMap();
//		map.initPlayer(player);
//		map.printCamera(yPlayer, xPlayer);
//		while(true) {
//			if(error.length() > 0) {
//				System.out.println(error);
//			}
//			move();
//			error = "";
//		}
	}

}

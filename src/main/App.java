package main;

import java.awt.Menu;

import javax.sound.sampled.AudioFileFormat;

import game.Authentication;
import game.Player;
import helper.Helper;
import scene.Shop;

public class App implements Helper{
	int xPlayer = map.getWidthSize() / 2;
	int yPlayer = map.getHeightSize() / 2;
//	Player player = new Player(30, 30, 200, 250);
	String error = "";
	
	public void move() {
		f.clr();
		if(currPlayer.getHealth() < 1) {
			System.out.println();
			System.out.println(c.RED + "It seems like you're dead");
			System.out.println(c.GREEN + "Automaticly Recover 10 HP > Cost 10 Coin" + c.RESET);
			currPlayer.setHealth(10);
			currPlayer.setMoney(currPlayer.getMoney() - 10);;
			System.out.println();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		map.printCamera(yPlayer, xPlayer);
		String input;
		
		
		do {
			System.out.print(">> ");
			input = s.nextLine();
		} while (input.length() < 1);
		
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
				currPlayer.setMoney(currPlayer.getMoney() + 5);
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
	}
	
	void init() {
		map.initMap();
		new Authentication();
//		;
	}
	
}

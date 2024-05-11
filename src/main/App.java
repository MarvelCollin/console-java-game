package main;

import java.awt.Menu;

import javax.sound.sampled.AudioFileFormat;

import game.Player;
import handler.Authentication;
import handler.Save;
import handler.UserHandler;
import helper.Helper;
import scene.Shop;

public class App implements Helper{
	int xPlayer = map.getWidthSize() / 2;
	int yPlayer = map.getHeightSize() / 2;
	String outputMessage= "";
	
	public void move() {
		f.clr();
		if(currPlayer.getHealth() < 1) {
			System.out.println();
			System.out.println(c.RED + "It seems like you're dead");
			System.out.println(c.GREEN + "Automaticly Recover 10 HP > Cost 20 Coin" + c.RESET);
			currPlayer.setHealth(10);
			currPlayer.setMoney(currPlayer.getMoney() - 20);;
			System.out.println();
			f.sleeping(3000);
		}
		map.printCamera(yPlayer, xPlayer);
		String input = "";
		System.out.println(outputMessage);
		outputMessage = "";
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
		} else if(input.equals("z") || input.equals("Z")) {
			f.clr();
			shop.menu();
		} else if(input.equals("i") || input.equals("I")) {
			f.clr();
			currPlayer.displayCurr();
		} else if(input.equals("k") || input.equals("K")) {
			new Save();
		} else if(input.equals("kolinganteng")) {
			currPlayer.setMoney(currPlayer.getMoney() + 1000);
		} else if(input.equals("marcobotak")) {
			currPlayer.setHealth(300);
		} else if(input.equals("pantatvincent")) {
			currPlayer.setMana(30);
		} else if(input.equals("e")) {
			new Save();
			
			System.out.println(c.RED + "Exiting program...." + c.RESET);
			System.exit(0);
			return;
		} else if(input.equals("stiphengabisaberakjongkok")) {
			yPlayer = r.nextInt(200) + 100;
			xPlayer = r.nextInt(200) + 100;
		} else {
			move();
			return;
		}
		
		int yCamera = map.getYCamera() / 2;
		int xCamera = map.getXCamera() / 2;
		
		int xShadow = xPlayer + preX + xCamera;
		int yShadow = yPlayer + preY + yCamera;
		if(map.getValue(yShadow, xShadow) == '#') outputMessage = c.RED + "Uh.. you're about smashing your head to the walls.." + c.RESET;
		
		if(yShadow >= map.getHeightSize() - 11 || xShadow >= map.getWidthSize() - 11 || yPlayer <= 12 || xPlayer <= 12) {
			
			outputMessage = c.RED + "It's Danger Zone, Please GET AWAY !!" + c.RESET;
			xPlayer -= preX;
			yPlayer  -= preY;
//			menu.enter();
		} else if(map.isPreMoveEmpty(yShadow, xShadow) == false) {
			if(map.getValue(yShadow, xShadow) == 'O') {
				outputMessage = c.BRIGHT_GREEN +  "oh wow look ! YAAAAAAAAAAAY 5 coins !!!" + c.RESET;
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
	}
	
	void init() {
		shop.init();
		map.initMap();
		new Authentication();
	}
	
}

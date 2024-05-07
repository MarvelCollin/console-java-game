package helper;

import java.util.Random;
import java.util.Scanner;

public class Function implements Helper{
	public static int random(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	
	public void enter() {	
		System.out.println();
		System.out.println(c.BRIGHT_YELLOW + "Please press enter to continue... " + c.RESET);
		Scanner s = new Scanner(System.in);
		s.nextLine();
	}
	
	public void enter(boolean cls) {	
		System.out.println();
		System.out.println(c.BRIGHT_YELLOW + "Please press enter to continue... " + c.RESET);
		Scanner s = new Scanner(System.in);
		s.nextLine();
		if(cls) clr();
	}
	
	public void clr() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}

package helper;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Function implements Helper{
	public static int random(int min, int max) {
		return r.nextInt(max - min + 1) + min;
	}
	
	public void enter() {	
		System.out.println();
		System.out.println(c.BRIGHT_YELLOW + "Please press enter to continue... " + c.RESET);
		s.nextLine();
	}
	
	public void enter(boolean cls) {	
		System.out.println();
		System.out.println(c.BRIGHT_YELLOW + "Please press enter to continue... " + c.RESET);
		s.nextLine();
		if(cls) clr();
	}
	
	public void clr() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
    public int StringDoubleToInt(String value) {
    	return (int) Double.parseDouble(value);
    }
	
    public int StringToInt(String value) {
    	return Integer.parseInt(value);
    }
    
    public static void loading() {
     
    }
}

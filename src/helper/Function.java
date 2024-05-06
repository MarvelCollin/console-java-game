package helper;

import java.util.Random;

public class Function {

	public Function() {
		// TODO Auto-generated constructor stub
	}
	
	public static int random(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	
}

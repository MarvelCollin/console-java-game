package helper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
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
    
    public void simulateProgress(int totalTasks) {
        System.out.print("Loading : [");
        for (int i = 0; i < totalTasks; i++) {
            System.out.print(" ");
        }
        System.out.print("] 0%");
        System.out.flush(); 
        
        for (int i = 0; i < totalTasks; i++) {
            try {
                Thread.sleep(15);
                updateProgressBar((i + 1), totalTasks);
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateProgressBar(int completedTasks, int totalTasks) {
    	clr();
        int progress = (int) ((double) completedTasks / totalTasks * 100);
        String progressBar = "\rProgress: [";
        int completedSteps = (int) ((double) completedTasks / totalTasks * 50);
        
        for (int i = 0; i < completedSteps; i++) {
            progressBar += "=";
        }
        
        for (int i = completedSteps; i < 50; i++) {
            progressBar += " ";
        }
        
        progressBar += "] " + progress + "%";
        System.out.print(c.GREEN + progressBar + c.RESET);
        System.out.flush();
    }
    
    public void sleeping(int value) {
    	try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void writeFile(String value, String path, boolean append) {
    	FileWriter fw;
		try {
			fw = new FileWriter(path, append);
			fw.write(value + "\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

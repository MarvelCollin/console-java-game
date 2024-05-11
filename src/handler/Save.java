package handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import helper.Helper;
import helper.Setting;
import item.Defensive;
import item.Offensive;
import item.Spell;

public class Save implements Helper, Setting{

	public Save(int y, int x) {
		saveUser();
		saveMap(y,x);
	}

	void saveUser() {
		String lineUser = "";
		
		lineUser += currPlayer.getEmail() + "#";
		lineUser += currPlayer.getPassword() + "#";
		lineUser += currPlayer.getMoney() + "#";
		lineUser += (double) currPlayer.getHealth() + "#";
		lineUser += (double) currPlayer.getMana() + "#";
		
		for (Defensive d : currDefensive) {
			int used = d.getMaxUse() - d.getUseLeft();
			lineUser += d.getId()+"@"+used+"-";
		}
		
		for (Offensive d : currOffensive) {
			int used = d.getMaxUse() - d.getUseLeft();
			lineUser += d.getId()+"@"+used+"-";
		}
		
		for (Spell d : currSpell) {
			lineUser += d.getId()+"@"+d.getUseLeft()+"-";
		}
		
		String lineUserMod = lineUser.substring(0, lineUser.length() - 1);
		String finalStore = new String(lineUserMod);
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(userTxt));
			FileWriter fw = new FileWriter(userTxt);
			
			for (String line : lines) {
				if(v.getEmail(line).equals(currPlayer.getEmail())) {
					line = finalStore;
				}
				
				fw.write(line + "\n");
			}
			
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c.BRIGHT_GREEN + "Saving Current User Data..." + c.RESET);
		f.enter(true);
	}
	
	void saveMap(int y, int x) {
		String relativePath = "src/mapData/";
        String fileName = currPlayer.getEmail();
        
		 File directory = new File(relativePath);

		 File[] files = directory.listFiles();

		 if (files != null && files.length > 0) {
			 for (File file : files) {
				 if (file.isFile()) {
					 String[] get = file.getName().split("#");
					 
					 if(get[0].equals(currPlayer.getEmail())) {
						 file.delete();
					 }
				 }
			 }
		 }

        String filePath = relativePath + fileName + "#" + y + "#" + x + ".txt";

	        try {
	            File file = new File(filePath);

	            if (file.exists()) {
	            	return;
	            } else {
	                FileWriter writer = new FileWriter(file);
	                
	                for (int i = 0; i < heightSize; i++) {
						for (int j = 0; j < widthSize; j++) {
							writer.write(mapChar[i][j]);
						}
						writer.write("\n");
					}

	                writer.close();

	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	}
	
}

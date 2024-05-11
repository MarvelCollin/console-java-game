package handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import helper.Helper;

public class Load implements Helper{

	public Load() {
		loadMap();
	}
	
	void loadMap() {
		 String folderPath = "src/mapData/";
		 File directory = new File(folderPath);

		 File[] files = directory.listFiles();

		 if (files != null && files.length > 0) {
			 for (File file : files) {
//				 System.out.println(file.getName());
				 if (file.isFile()) {
					 String[] get = file.getName().split("#");
					 
					 if(get[0].equals(currPlayer.getEmail())) {
						 initToMap(folderPath + file.getName());
						 
						 int dotIndex = get[2].lastIndexOf('.');
						 
						 String getX = get[2].substring(0, dotIndex);

						 app.initPlayer(Integer.parseInt(get[1]), Integer.parseInt(getX));
						 return;
					 }
					 
				 }
			 }
		 } 
		 
		 System.out.println(c.GREEN + "Generating New Map..." + c.RESET);
		 f.sleeping(1500);
		 map.initMap();
	}
	
	void initToMap(String filePath) {
		System.out.println(c.BRIGHT_GREEN + "Getting Last Data map..." + c.RESET);
		f.sleeping(1500);
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(filePath));
			
            for (int i = 0; i < lines.size(); i++) {
            	mapChar[i] = lines.get(i).toCharArray();
            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

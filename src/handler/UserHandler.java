package handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import helper.Helper;
import item.Defensive;
import item.Offensive;
import item.Spell;
import prettifier.Outputs;

public class UserHandler implements Helper, Outputs{
	public boolean loginChecker(String emailInput, String passwordInput) {
        String filePath = "credential.txt";

        String email = "";
        String password = "";
        int money = 0;
        int health = 0;
        int mana = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                
                if(!parts[0].equals(emailInput)) continue;
                if(!parts[0].equals(emailInput) && !parts[1].equals(passwordInput)) continue; 
                
                email = parts[0]; 
                password = parts[1];
                money = f.StringToInt(parts[2]);
                health = f.StringDoubleToInt(parts[3]);
                mana = f.StringDoubleToInt(parts[4]);
//                System.out.println(parts[5]);
                currPlayer.setEmail(email);
                currPlayer.setPassword(password);
                String[] items = parts[5].split("-");
                gettingItems(items);
                
                currPlayer.setAll(30, mana, health, money);
                
                return true;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return false;
    }
	
	public void gettingItems(String[] str) {
		for(int i = 0; i < str.length; i++) {
//			System.out.println(str[i]);
			String[] div = str[i].split("@");
			
			for (Offensive o : offensiveShop) {
				if(o.getId().equals(div[0])) {
					currOffensive.add(o);
					Offensive last = currOffensive.get(currOffensive.size() - 1);
					last.setUseLeft(last.getMaxUse() - f.StringToInt(div[1]));
					break;
				}
			}
			
			for (Defensive d : defensiveShop) {
				if(d.getId().equals(div[0])) {
					currDefensive.add(d);
					Defensive last = currDefensive.get(currDefensive.size() - 1);
					last.setUseLeft(last.getMaxUse() - f.StringToInt(div[1]));
					break;
				}
			}
			
			for (Spell s : spellShop) {
				if(s.getId().equals(div[0])) {
					currSpell.add(s);
					break;
				}
			}
		}
	}
	


}

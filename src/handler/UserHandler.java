package handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import helper.Helper;

public class UserHandler implements Helper{
	
	public boolean loginChecker(String emailInput, String passwordInput) {
        String filePath = "credential.txt";

        String email = "";
        String password = "";
        int money = 0;
        int health = 0;
        int mana = 0;
        String offensive = "";
        int usedOff = 0;
        String armor = "";
        int usedArmor = 0;
        String spell = "";
        int usedSpell = 0;

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
                
                String[] items = parts[5].split("-");
                
                
                currPlayer.setAll(30, mana, health, money, offensive, usedOff, armor, usedArmor, spell, usedSpell);
                return true;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return false;

    }
	
	void displayCurr() {
//        System.out.println("Email: " + email);
//        System.out.println("Password: " + password);
//        System.out.println("Money: " + money);
//        System.out.println("Health: " + health);
//        System.out.println("Mana: " + mana);
//        System.out.println("Offensive: " + offensive);
//        System.out.println("Used Offensive: " + usedOff);
//        System.out.println("Armor: " + armor);
//        System.out.println("Used Armor: " + usedArmor);
//        System.out.println("Spell: " + spell);
//        System.out.println("Used Spell: " + usedSpell);
	}

}

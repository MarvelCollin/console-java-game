package helper;

import item.Defensive;
import item.Offensive;
import item.Spell;

public class Save implements Helper{

	public Save() {
		saveUser();
	}

	void saveUser() {
		StringBuilder user = new StringBuilder();
		
		user.append(currPlayer.getEmail()+"#"+currPlayer.getPassword()+"#"
				+currPlayer.getMoney()+"#"+currPlayer.getHealth()+"#"+currPlayer.getMana()+"#");
		
		for (Defensive d : currDefensive) {
			int used = d.getMaxUse() - d.getUseLeft();
			user.append(d.getId()+"@"+used+"-");
		}
		
		for (Offensive d : currOffensive) {
			int used = d.getMaxUse() - d.getUseLeft();
			user.append(d.getId()+"@"+used+"-");
		}
		
		for (Spell d : currSpell) {
			user.append(d.getId()+"@"+d.getUseLeft()+"-");
		}
		
		user.charAt(user.length() - 1);
		
		System.out.println(user);
	}
	
}

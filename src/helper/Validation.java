package helper;

public class Validation implements Helper{
	public String getEmail(String line) {
		StringBuilder email = new StringBuilder();
			
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '#') break;
			email.append(line.charAt(i));
			
		}
		
		return String.valueOf(email);
	}
	
}

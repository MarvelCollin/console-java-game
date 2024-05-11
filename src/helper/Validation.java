package helper;

public class Validation implements Helper{
	public String getEmail(String line) {
		String[] email = line.split("#");
		
		return email[0];
	}
	
}

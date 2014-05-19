package I18NSample;

import java.util.*;

public final class I18NSample {
	
	private I18NSample(){}
	
	public static void main(String[] args) {
		String language, country;
		Locale currentLocale;
		ResourceBundle messages;
		if (args.length != 2) {
			language = new String("en");
			country = new String("US");
		}
		else{
			language = new String(args[0]);
			country = new String(args[1]);
		}
		
		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		
		System.out.println(messages.getString("greetings"));
		System.out.println(messages.getString("inquiry"));
		System.out.println(messages.getString("farewell"));
	}
}
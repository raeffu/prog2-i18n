package dateExample;

import java.text.*;
import java.util.*;
import java.util.Date;
 
public final class DateExample {
	
   private DateExample(){}
 
   public static void main(String args[]) {
 
     // Get the Date
     Date now = new Date();
 
     // Get date formatters for default, German, and French locales
     DateFormat theDate = DateFormat.getDateInstance(DateFormat.LONG);
     DateFormat germanDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMANY);
     DateFormat frenchDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
     DateFormat japanesDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.JAPANESE);
 
     // Format and print the dates
     System.out.println("Date in the default locale: " + theDate.format(now));
     System.out.println("Date in the German locale : " + germanDate.format(now));
     System.out.println("Date in the French locale : " + frenchDate.format(now));  
     System.out.println("Date in the Japanese locale : " + japanesDate.format(now));  
   } 
}
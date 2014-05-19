package resourceBundleExample;

import java.util.*;

public final class ResourceBundleExample {
	
   private ResourceBundleExample(){}
	
   public static void main(String args[]) throws MissingResourceException {
 
     String resourceName = "RBExample";
     ResourceBundle rb;
 
     // Default locale
     rb = ResourceBundle.getBundle(resourceName);
     System.out.println("Default : " + rb.getString("Hello" + ".text"));
     
     // Request a resource bundle with explicitly specified locale
     rb = ResourceBundle.getBundle(resourceName, Locale.GERMANY);
     System.out.println("German : " + rb.getString("Hello" + ".text"));
     
     // No property file for China in this example... use default 
     rb = ResourceBundle.getBundle(resourceName, Locale.CHINA); 
     System.out.println("Chinese : " + rb.getString("Hello" + ".text"));
 
     // Here is another way to do it...
     Locale.setDefault(Locale.FRANCE);
     rb = ResourceBundle.getBundle(resourceName);
     System.out.println("French : " + rb.getString("Hello" + ".text"));
 
     // No property file for China in this example... use default, which is now fr_FR.
     rb = ResourceBundle.getBundle(resourceName, Locale.CHINA);
     System.out.println("Chinese : " + rb.getString("Hello" + ".text"));
   } 
}
package propertyUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {
	public static String path ="C:\\Users\\dell\\eclipse-workspace\\GetCover\\src\\test\\resources\\getCoverConfig.properties";
	 ///public static Properties props=new Properties();
	 
	 public static String getreadData(String Key)
	 { 
		 String value="";
		 try {
			 
			 FileInputStream fis = new FileInputStream(path);
			  Properties props=new Properties();
			
			 props.load(fis);
			 value=props.getProperty(Key);
			 		
		} catch (Exception e) {
			System.out.println("Issue in GetRead Data" +e);
		}
		  
		return value;
		 
	 }
	 

}

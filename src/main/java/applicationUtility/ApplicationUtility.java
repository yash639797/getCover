package applicationUtility;

import java.util.Random;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseLibrary.BaseClass;

public class ApplicationUtility extends BaseClass
{
 
	
	
	public static void sendKeys(WebElement element, String value ) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, value);
    }
	
	public static void click(WebElement element) {
		element.click();
	}

	
	
	public static String generateRandomString(int length) {
        // Define the regular expression to represent the characters allowed in the random string
     
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Create a StringBuilder to store the random string
        StringBuilder stringBuilder = new StringBuilder();

        // Create a Random object
        Random random = new Random();

        // Generate random characters until the desired length is reached
        for (int i = 0; i < length; i++) {
            // Generate a random index within the range of the characters string
            int randomIndex = random.nextInt(characters.length());

            // Append the random character at the random index to the StringBuilder
            stringBuilder.append(characters.charAt(randomIndex));
        }

        // Convert StringBuilder to String and return
        return stringBuilder.toString();
    }
	
	public static void visibletextDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	public static void indexBaseDropDown(WebElement element,int value)
	{
		Select sel=new Select(element);
		sel.selectByIndex(value);
	}
	public static void byValueDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	 public static int getRandomIndexInArray(int arrayLength) {
	        Random random = new Random();
	        return random.nextInt(arrayLength);
	    }
	  static int randomNumber;
	 public static int genrateRondomNumber(int lengthOfNumber)
	 {
		 Random random = new Random();
		 if(lengthOfNumber==1)
		 {
			 randomNumber=	random.nextInt(9); 
		 }		
		 else if(lengthOfNumber==2)
		 {
			 randomNumber=	random.nextInt(90)+9; 
		 }
		 else if(lengthOfNumber==3)
		 {
			 randomNumber=	random.nextInt(900)+99; 
		 }
		 else if(lengthOfNumber==4)
		 {
			 randomNumber=random.nextInt(9000)+999;  
		 }
		 else if(lengthOfNumber==5)
		 {
			 randomNumber=	random.nextInt(90000)+9999; 
		 }
		
		 return randomNumber;
		 
	 }
	 public static void scrollWhereElement(WebElement element )
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",element);
	 }
}

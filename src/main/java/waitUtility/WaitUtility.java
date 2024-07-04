package waitUtility;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseLibrary.BaseClass;

public class WaitUtility extends BaseClass {
    private static WebDriverWait wait;

    public static void visibilityOfElement(WebElement element, int time) {
        try {System.out.println("1 "+element);
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOf(element));
        
            
            System.out.println("2 "+element);
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be visible: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception in dynamic wait method: " + e.getMessage());
        }
    }
    
    public static void inVisibilityOfElement(WebElement element, int time) {
        try {
        	System.out.println("1 "+element);
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOf(element));
            System.out.println("2 "+element);
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be visible: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception in dynamic wait method: " + e.getMessage());
        }
    }
}

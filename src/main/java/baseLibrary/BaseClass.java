package baseLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	public static WebDriver driver;
	
//	
//	private static void startKeepAwake() {
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(() -> {
//            try {
//                Robot robot = new Robot();
//                robot.mouseMove(0, 0); // Move mouse to (0, 0)
//                robot.mouseMove(1, 0); // Move mouse slightly to simulate activity
//            } catch (AWTException e) {
//                e.printStackTrace();
//            }
//        }, 0, 30, TimeUnit.SECONDS); // Run the task every 30 seconds
//    }
	@BeforeTest
public void  getLaunch() throws InterruptedException
{
	//WebDriverManager.chromedriver().setup();
try {
	

  System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\eclipse-workspace\\GetCover\\driver\\chromedriver.exe");
  driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("http://15.207.221.207/dashboard");
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  startKeepAwake();
} catch (Exception e) {
	System.out.println(e);
}	

}
}

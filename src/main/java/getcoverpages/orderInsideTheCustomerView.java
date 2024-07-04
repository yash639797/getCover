package getcoverpages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import applicationUtility.ApplicationUtility;
import applicationUtility.CsvFile;
import baseLibrary.BaseClass;

public class orderInsideTheCustomerView  extends BaseClass
{

	public void sumOfOrder()
	{
		try {
		driver.findElement(By.xpath("//span[text()='Order']")).click();
		driver.findElement(By.xpath("//span[text()='Order List']")).click();
		Thread.sleep(4000);
		ApplicationUtility.visibletextDropDown(driver.findElement(By.xpath("//span[text()='Order List']")), "Active");
		Thread.sleep(500);
		driver.findElement(By.xpath("//img[@class='cursor-pointer ']")).click();
		Thread.sleep(4000);
		
		
		
			
			
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void orderCustomerView() 
	{
		String filePath="";
		for(int i=1;i<=1500;i++)
		{
		try {
			
		driver.findElement(By.xpath("//span[normalize-space()='Customer']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='Customer List']")).click();
		Thread.sleep(1000);
			
		
			Integer num[]= {4,5,6,7,8,9,10,11,12,13};
			int customerSrNo=num[ApplicationUtility.getRandomIndexInArray(num.length)]; 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//div[@data-column-id='8'])["+customerSrNo+"]/div")));
			Thread.sleep(4000);
		    driver.findElement(By.xpath("(//div[@data-column-id='8'])["+customerSrNo+"]/div")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[text()=' View']")).click();
		    Thread.sleep(6000);
		    driver.findElement(By.xpath("//span[contains(@class,'text-black ml-2')]")).click();
		    Thread.sleep(6000);
		    driver.findElement(By.xpath("//button[text()='Next']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='dealerPurchaseOrder']"))
					.sendKeys("D.P.O.-00" + ApplicationUtility.generateRandomString(3) + i);
			WebElement serviceCoverage = driver.findElement(By.xpath("//*[@id='Service Coverage']"));
			serviceCoverage.click();
			ApplicationUtility.indexBaseDropDown(serviceCoverage, 1);
			WebElement coverageType = driver.findElement(By.xpath("//select[@id='Coverage Type']"));
			ApplicationUtility.indexBaseDropDown(coverageType, 1);
			Thread.sleep(400);
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			Thread.sleep(1000);
			ApplicationUtility.indexBaseDropDown(driver.findElement(By.xpath("//select[@id='Product Category']")), 1);
			ApplicationUtility.indexBaseDropDown(driver.findElement(By.xpath("//select[@id='Product SKU']")), 1);
			Thread.sleep(5000);

			String priceType = driver
					.findElement(By.xpath("//div[@class='relative undefined']/child::input[contains(@name,'priceType')]"))
					.getAttribute("value");
			Thread.sleep(500);
			  
			if (priceType.equalsIgnoreCase("Regular Pricing")) {
				int noOfProduct=ApplicationUtility.genrateRondomNumber(3);
				driver.findElement(By.xpath("//div[@class='relative undefined']/child::input[contains(@name,'noOfProducts')]")).sendKeys(String.valueOf(noOfProduct));
				Thread.sleep(500);
				driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/child::input"))
						.sendKeys("04/10/2024");
				WebElement fileInput = driver.findElement(By.xpath("//button[contains(@class,'bg-[#F2F2F2] py-10 ')]"));
				fileInput.click();
				Thread.sleep(1000);
				 filePath = CsvFile.regularPriceingCsv(noOfProduct);
			}
			else if (priceType.equalsIgnoreCase("Flat Pricing"))
			{
				int noOfProduct=ApplicationUtility.genrateRondomNumber(3); 
				String startRange = driver.findElement(By.xpath("//input[@id='productsArray[0].rangeStart']")).getAttribute("value");
				String endRange = driver.findElement(By.xpath("//input[@id='productsArray[0].rangeEnd']")).getAttribute("value");		
				driver.findElement(By.xpath("//div[@class='relative undefined']/child::input[contains(@name,'noOfProducts')]")).sendKeys(String.valueOf(noOfProduct));
				Thread.sleep(500);
				driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/child::input"))
						.sendKeys("04/10/2024");
				WebElement fileInput = driver.findElement(By.xpath("//button[contains(@class,'bg-[#F2F2F2] py-10 ')]"));
				fileInput.click();
				Thread.sleep(1000);
			
				filePath = CsvFile.flatPriceingCsv(noOfProduct, Integer.parseInt(startRange), Integer.parseInt(endRange));
			}
			else if (priceType.equalsIgnoreCase("Quantity Pricing"))
			{
				driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/child::input"))
				.sendKeys("06/18/2024");
		WebElement fileInput = driver.findElement(By.xpath("//button[contains(@class,'bg-[#F2F2F2] py-10 ')]"));
		fileInput.click();
		Thread.sleep(1000);
	
		filePath = CsvFile.QuantityPriceingCsv();
	
			}
				
			
			    Robot robot = new Robot();
				StringSelection stringSelection = new StringSelection(filePath);
			
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				Thread.sleep(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				Thread.sleep(8000);
				driver.findElement(By.xpath("//button[text()='Next']")).click();
				Thread.sleep(400);

				ApplicationUtility.indexBaseDropDown(driver.findElement(By.xpath("//select[@name='paymentStatus']")),
						0);

				driver.findElement(By.xpath("//button[text()='Submit']")).click();

				Thread.sleep(16000);
				driver.findElement(By.xpath("//a[@class='h-[60px] w-[60px] flex border-[1px] bg-white border-Light-Grey rounded-[25px]']")).click();
				//driver.navigate().back();
				Thread.sleep(5000);

			
		    
		    }
	
	 catch (Exception e) {
		 if(!driver.getCurrentUrl().equalsIgnoreCase("http://15.207.221.207/dashboard)"))
				 {
			 driver.navigate().back();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 }
		e.printStackTrace();}
		
		}
	}
}
	

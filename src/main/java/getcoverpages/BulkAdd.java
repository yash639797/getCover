package getcoverpages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import applicationUtility.ApplicationUtility;
import applicationUtility.CsvFile;
import baseLibrary.BaseClass;
import waitUtility.WaitUtility;

public class BulkAdd extends BaseClass {
	
	@FindBy(xpath="//div[@class='self-center mx-auto']")
	private WebElement Loader;
	
	String Dealer1="dealer00123";
	String Reseller1="reseller001"; 
	String Customer1="custmore005 125";
	
	String Dealer2="yash001";
	String Reseller2="reseller002";
	String Customer2="customer002";

	public void reseller() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Reseller']")).click();
		driver.findElement(By.xpath("//span[text()='Add Reseller']")).click();
		for (int i = 0; i <= 10; i++) {
			if (i != 0) {
				driver.findElement(By.xpath("//*[text()='Add New Reseller']")).click();
			}
			Thread.sleep(1000);
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='Dealer Name']"));
			ApplicationUtility.indexBaseDropDown(dropdownElement, 1);
//	   
//	        Select dropdown = new Select(dropdownElement);
//	        Thread.sleep(2000);
//
//	  if(i/2==0) {
//	        dropdown.selectByIndex(0);
//	  }
//	  else {
//	        dropdown.selectByIndex(1);
//	        
//	  }  
			String resellername = ApplicationUtility.generateRandomString(5) + "00" + i;
			driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys(resellername);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='firstName']"))
					.sendKeys(ApplicationUtility.generateRandomString(5));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='lastName']"))
					.sendKeys(ApplicationUtility.generateRandomString(4));

			driver.findElement(By.xpath("//input[@id='street']")).sendKeys("mohali");
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("5 phase");
			dropdownElement = driver.findElement(By.xpath("//select[@id='Reseller State']"));
			Select dropdown1 = new Select(dropdownElement);
			Thread.sleep(1000);

			if (i / 2 == 0) {
				dropdown1.selectByIndex(7);
			} else {
				dropdown1.selectByIndex(8);

			}
			driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("12345");
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(resellername + "@yopmail.com");
			driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("1234567890");
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			Thread.sleep(7000);
		}
	}

	public void order() throws InterruptedException, AWTException {
		try {
			
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Order']")).click();

		driver.findElement(By.xpath("//span[text()='Add Order']")).click();

		ram: for (int i = 0; i <= 100; i++) {
			if (i != 0) {
				driver.findElement(By.xpath("//span[text()='Add New Order']")).click();
			 
			}
			Thread.sleep(400);
			WebElement dealerField = driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/child::input)[1]"));
			
			if(i%2==0)
			{
			
			Thread.sleep(1000);
			dealerField.click();
			Thread.sleep(1000);
			
			dealerField.sendKeys(Dealer1);
			dealerField.sendKeys(Keys.ENTER);
			Thread.sleep(6000);
			
			WebElement customerName = driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/child::input)[4]"));
			customerName.click();
			Thread.sleep(1000);
			customerName.sendKeys(Customer1);
			Thread.sleep(1000);
			customerName.sendKeys(Keys.ENTER);
		}
//			
//			  else
//			  
//			  { 
//				  dealerField.click();
//			  Thread.sleep(2000); 
//			  dealerField.sendKeys(Dealer2); dealerField.sendKeys(Keys.ENTER); 
//			  customerName.click(); Thread.sleep(2000); customerName.sendKeys(Customer2);
//			  customerName.sendKeys(Keys.ENTER);
//			  
//			 }
			  
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

			ApplicationUtility.visibletextDropDown((driver.findElement(By.xpath("//select[@id='Product Category']"))),
					"Adani");
			Thread.sleep(5000);
			ApplicationUtility.visibletextDropDown(driver.findElement(By.xpath("//select[@id='Product Name']")),
					"solar1");
			Thread.sleep(5000);

			String priceType = driver
					.findElement(By.xpath("//div[@class='relative']/child::input[contains(@name,'priceType')]"))
					.getAttribute("value");
			Thread.sleep(500);
//			Integer csvfile[]= {200,1000,500,2000,5000};
//					
//					int indexValue=csvfile[ApplicationUtility.getRandomIndexInArray(csvfile.length)];
//					
					
			if (priceType.equalsIgnoreCase("Regular Pricing")) {
				int noOfProduct=ApplicationUtility.genrateRondomNumber(4);
				driver.findElement(By.xpath("//div[@class='relative']/child::input[contains(@name,'noOfProducts')]")).sendKeys(String.valueOf(noOfProduct));
				Thread.sleep(500);
				driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/child::input"))
						.sendKeys("04/23/2024");
				WebElement fileInput = driver.findElement(By.xpath("//button[contains(@class,'bg-[#F2F2F2] py-10 ')]"));
				fileInput.click();
			
				
			//	String filePath = "C:\\Users\\dell\\Downloads\\"+indexValue+".xlsx";
				String filePath = CsvFile.regularPriceingCsv(noOfProduct);
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

				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='Next']")).click();
				Thread.sleep(400);

				ApplicationUtility.indexBaseDropDown(driver.findElement(By.xpath("//select[@name='paymentStatus']")),
						0);

				driver.findElement(By.xpath("//button[text()='Submit']")).click();

				Thread.sleep(10000);

			}
		}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	

	

	public void dealer() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Dealer']")).click();
		driver.findElement(By.xpath("//span[text()='Add Dealer']")).click();
		for (int i = 0; i <= 10; i++) {
			if (i != 0) {
				driver.findElement(By.xpath("//*[text()='Add New Dealer']")).click();
			}

			String dealername = ApplicationUtility.generateRandomString(5) + "00" + i;
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(dealername);
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='firstName']"))
					.sendKeys(ApplicationUtility.generateRandomString(5));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='lastName']"))
					.sendKeys(ApplicationUtility.generateRandomString(4));

			driver.findElement(By.xpath("//input[@id='street']")).sendKeys("mohali");
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("5 phase");
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='Business State']"));
			Thread.sleep(1000);

			if (i % 2 == 0) {
				ApplicationUtility.indexBaseDropDown(dropdownElement, 11);
				driver.findElement(
						By.xpath("//p[contains(@class,'text-light-black flex')]/descendant::input[@id='yes']")).click();
			} else {
				ApplicationUtility.indexBaseDropDown(dropdownElement, 5);
			}
			driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("12345");
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(dealername + "@yopmail.com");
			driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("1234567890");

			ApplicationUtility.visibletextDropDown((driver.findElement(By.xpath("//select[@id='Product Category']"))),
					"Adani");
			Thread.sleep(500);
			ApplicationUtility.visibletextDropDown(driver.findElement(By.xpath("//select[@id='Product Name']")),
					"solar");

			driver.findElement(By.xpath("//input[@id='priceBook[0].retailPrice']")).sendKeys(String.valueOf(i * 25));
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			Thread.sleep(8000);

		}
	}

	public void customer() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Customer']")).click();
			driver.findElement(By.xpath("//span[text()='Add Customer']")).click();
			for (int i = 0; i <= 10; i++) {
				if (i != 0) {
					driver.findElement(By.xpath("//*[text()='Add New Customer']")).click();
				}

			//	WebElement dealerdropdown = driver.findElement(By.xpath("//*[@id='react-select-2-input']"));
				WebElement dealerdropdown = driver.findElement(By.xpath("//*[@class=' css-19bb58m']/child::input"));

				if (i % 2 == 0) {
					Thread.sleep(1000);
					dealerdropdown.click();
					Thread.sleep(2000);
					dealerdropdown.sendKeys(Dealer1);
					Thread.sleep(1000);
					dealerdropdown.sendKeys(Keys.ENTER);
					
				} else {
					dealerdropdown.click();
					Thread.sleep(2000);
					dealerdropdown.sendKeys(Dealer2);
					Thread.sleep(1000);
					dealerdropdown.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					
					
					WebElement resellerdropdown = driver.findElement(By.xpath("(//*[@class=' css-19bb58m']/child::input)[2]"));
					resellerdropdown.click();
					Thread.sleep(1000);
					resellerdropdown.sendKeys(Reseller2);
					Thread.sleep(1000);
					resellerdropdown.sendKeys(Keys.ENTER);
					Thread.sleep(100);
				}

				String Customername = "C.A.N.-" + ApplicationUtility.generateRandomString(4) + "00" + i;
				driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys(Customername);
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@id='firstName']"))
						.sendKeys(ApplicationUtility.generateRandomString(5));
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@id='lastName']"))
						.sendKeys(ApplicationUtility.generateRandomString(4));

				driver.findElement(By.xpath("//input[@id='street']")).sendKeys("mohali");
				driver.findElement(By.xpath("//input[@id='city']")).sendKeys("5 phase");
				WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='Customer State']"));

				if (i % 2 == 0) {
					ApplicationUtility.indexBaseDropDown(dropdownElement, 10);

				} else {
					ApplicationUtility.indexBaseDropDown(dropdownElement, 5);
				}
				driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("12345");
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Customername + "@yopmail.com");
				driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("1234567890");
				driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
				Thread.sleep(7000);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public void orderDynamic() throws InterruptedException, AWTException {
		try {

			List<String> dealerList=new ArrayList<String>();
			List<String> customerList=new ArrayList<String>();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Order']")).click();

		driver.findElement(By.xpath("//span[text()='Add Order']")).click();


		WebElement dealerField = driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/child::input)[1]"));
		WebElement customerName = driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/child::input)[4]"));
		dealerField.click();
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//div[contains(@class, 'css-qr46ko') or contains(@class, 'css-10wo9uf-option')]"));
		for(WebElement dd:dropdownlist)
		{
		dealerList.add(dd.getText());
		
		}
		System.out.println(dealerList);
		dealerloop:for(int j=1;j<=dealerList.size();j++)
		{
			dealerField.sendKeys(dealerList.get(j));
			dealerField.sendKeys(Keys.ENTER);
			Thread.sleep(6000);
		//	WaitUtility.inVisibilityOfElement(Loader,6000);
		int attempts=0;
			 while(attempts < 2) {
			        try {
			        	 customerName = driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/child::input)[4]"));
			        	 customerName.click();
			        	 for(WebElement dd:dropdownlist)
			 			{
			 			customerList.add(dd.getText());
			 			if(customerList.size()==1)
			 			{
			 				customerList.clear();
			 				continue dealerloop;
			 			}
			 			else
			 			{
			 				customerName.sendKeys(dealerList.get(j));
			 				customerName.sendKeys(Keys.ENTER);
			 				customerList.clear();
			 				Thread.sleep(6000);
			 				WaitUtility.inVisibilityOfElement(Loader,4000);
			 				break dealerloop;
			 			}
			 			}}catch(Exception e) {
			 				e.printStackTrace();
				        }}
			 		
			        	
			           
			        
			        attempts++;
			    }
			
			
			
		
		
		
		
		
	

				  driver.findElement(By.xpath("//button[text()='Next']")).click();
				Thread.sleep(1000);



		}catch(Exception e)
		{
			e.printStackTrace();
			}}
		}
package getcoverpages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtility.ApplicationUtility;
import applicationUtility.CsvFile;
import baseLibrary.BaseClass;
import waitUtility.WaitUtility;

public class BulkClaim extends BaseClass
{
	@FindBy(xpath="//div[@class='self-center mx-auto']")
	private WebElement Loader;
	
	public  BulkClaim()
	{
		PageFactory.initElements(driver, this);
	}

	
public void bulkClaimAdd()
{
	
	
	for(int i=0;i<=100;i++)
	{
		
		if(i==0)
	{
		driver.findElement(By.xpath("//span[text()='Claim']")).click();
	}
	try {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add Claim']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='contractId']")).clear();
		driver.findElement(By.xpath("//input[@id='contractId']")).sendKeys("oc-2024-10");
		
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		WaitUtility.inVisibilityOfElement(Loader, 1200);
		
		
		
		
	/*
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 * wait.until(ExpectedConditions.)
	 */

		
		
	//	Thread.sleep(5000);
		System.out.println(" 1 loader ");
		
		ApplicationUtility.visibletextDropDown(driver.findElement(By.xpath("//*[contains(@class,' bg-[#333] text')] ")), "100");
		//Thread.sleep(4000);
		System.out.println("2 loader");
		
		WaitUtility.inVisibilityOfElement(Loader, 1200);
		
		
	List<WebElement> contractId= driver.findElements(By.xpath("//tbody/tr/td[@class='py-3']"));
	ArrayList<String> getContractId= new ArrayList<String>();
	//for(int j=1;j<=10;j++)
	{
	for(WebElement dd:contractId)
	{
		getContractId.add(dd.getText());
		
	}
	}
	
	String filePath=CsvFile.claimCsv(getContractId);
	
	
	driver.findElement(By.xpath("//span[text()='Add Bulk Claim']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(@class,'bg-[#F2F2F2] bor')]/img")).click();
	Thread.sleep(2000);

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
	Thread.sleep(2000);
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    WaitUtility.inVisibilityOfElement(Loader, 25000);
   // Thread.sleep(20000);
	
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	
	
	
	
}
}
	
	
	
	

}

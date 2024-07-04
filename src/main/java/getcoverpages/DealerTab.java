package getcoverpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import applicationUtility.ApplicationUtility;
import baseLibrary.BaseClass;
import extentlisteners.ExtentListeners;
import waitUtility.WaitUtility;

public class DealerTab extends BaseClass
{
	public DealerTab()
	{
		PageFactory.initElements(driver,this);
	}
	String dealerName=ApplicationUtility.generateRandomString(6)+ApplicationUtility.genrateRondomNumber(2);
	String dealerMail=dealerName+"@yopmail.com"; 
	@FindBy(xpath="//*[text()='Dealer']")
	private WebElement DealerTab;
	
	@FindBy(xpath="//span[text()='Add Dealer']")
	private WebElement AddDealerTab;
	@FindBy(xpath="//input[@id='name']")
	private WebElement DealerAccountName;
	
	

	@FindBy(xpath="//input[@id='firstName']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@id='street']")
	private WebElement BusinessStreetAddress ;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement BusinessCity ;
	@FindBy(xpath="//select[@id='Business State']")
	private WebElement BusinessState ;
	@FindBy(xpath="//input[@id='zip']")
	private WebElement ZipCode;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='phoneNumber']")
	private WebElement PhoneNumberField ;
	
	@FindBy(xpath="//select[@id='Product Category']")
	private WebElement ProductCategory;
	
	@FindBy(xpath="//select[@id='Product Name']")
	private WebElement ProductName ;
	
	@FindBy(xpath="//input[@id='priceBook[0].retailPrice']")
	private WebElement RetailPrice;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement SubmitButton ;
	@FindBy(xpath="//div[@class='self-center mx-auto']")
	private WebElement Loader;
	
	@FindBy(xpath="(//div[@class='sc-jrAGKZ bSeuEx rdt_TableRow']//child::div[@id='cell-2-undefined'])[1]")
	private WebElement list1Row2Col ;
	@FindBy(xpath="(//div[@class='sc-jrAGKZ bSeuEx rdt_TableRow']//child::div[@id='cell-3-undefined'])[1]")
	private WebElement list1Row3Col ;
	@FindBy(xpath="(//*[@alt='Active Icon'])[1]")
	private WebElement  SingleView_3Dot;
	@FindBy(xpath="//a[normalize-space()='View']")
	private WebElement  SingleViewButton;
	@FindBy(xpath="//span[normalize-space()='Servicer']")
	private WebElement  ServicerTabButton;
	@FindBy(xpath = "//*[text()='Do you want to create an account?']//child::input[@id='no-create-account']")
	private WebElement radioButtonNOCreateAccount ;
	@FindBy(xpath="//div[@class='flex items-center px-3 undefined']//input[@value='true']")
	private WebElement radioButtonworkAsServicer ;
	@FindBy(xpath="//input[@id='no-separate-account']")
	private WebElement radioButtonNoSeparateAccount ;
	
	
	
 SoftAssert softAssert;
	public void addDealer()  {
		
		softAssert=new SoftAssert();
		try {
			
		DealerTab.click();
		AddDealerTab.click();
		
		DealerAccountName.sendKeys(dealerName);
		FirstName.sendKeys(ApplicationUtility.generateRandomString(5));
		LastName.sendKeys(ApplicationUtility.generateRandomString(4));
		BusinessStreetAddress.sendKeys("mohali");
		emailField.sendKeys(dealerMail);
		PhoneNumberField.sendKeys("9826786252");
		BusinessStreetAddress.sendKeys("Mohali");
		BusinessCity.sendKeys(ApplicationUtility.generateRandomString(7));
	    ApplicationUtility.indexBaseDropDown(BusinessState, 11);
	    ZipCode.sendKeys(String.valueOf(ApplicationUtility.genrateRondomNumber(5)));
		ApplicationUtility.indexBaseDropDown(ProductCategory, 1);
		ApplicationUtility.indexBaseDropDown(ProductName, 1);
        RetailPrice.sendKeys(String.valueOf(ApplicationUtility.genrateRondomNumber(5)));
        SubmitButton.click();
        
        WaitUtility.inVisibilityOfElement(Loader, 15);
         
        if (driver.getCurrentUrl().equalsIgnoreCase("http://15.207.221.207/dealerList"))
        {
         softAssert.assertEquals(list1Row2Col.getText(),dealerName);
         softAssert.assertEquals(list1Row3Col.getText(),dealerMail);
         System.out.println("Dealer is created suceesfully");
         ExtentListeners.test.log(Status.INFO, "Dealer is Created Suceesfully with this name "+dealerName);
         ExtentListeners.test.log(Status.INFO, "Dealer mail id is "+dealerMail);
        }
        if (driver.getCurrentUrl().equalsIgnoreCase("http://15.207.221.207/addDealer"))
        {
         
        
        }
		
	} catch (Exception e) {
		System.out.println("Issue in add dealer tab "+e);
	}
	}
	public void condtionDealerAdd()
	{
		try {
			
			DealerTab.click();
			AddDealerTab.click();
			
			WaitUtility.visibilityOfElement(DealerAccountName, 10);
			String dealerName=ApplicationUtility.generateRandomString(7);
			DealerAccountName.sendKeys(dealerName);
			FirstName.sendKeys(ApplicationUtility.generateRandomString(5));
			LastName.sendKeys(ApplicationUtility.generateRandomString(4));
			BusinessStreetAddress.sendKeys("mohali");
			String dealerMail=dealerName+"@yopmail.com";
			emailField.sendKeys(dealerMail);
			PhoneNumberField.sendKeys("9826786252");
			BusinessStreetAddress.sendKeys("Mohali");
			BusinessCity.sendKeys(ApplicationUtility.generateRandomString(7));
		    ApplicationUtility.indexBaseDropDown(BusinessState, 11);
		    ZipCode.sendKeys(String.valueOf(ApplicationUtility.genrateRondomNumber(5)));
		   
		    radioButtonNOCreateAccount.click();
		    radioButtonworkAsServicer.click();
		    radioButtonNoSeparateAccount.click();
			ApplicationUtility.indexBaseDropDown(ProductCategory, 1);
			ApplicationUtility.indexBaseDropDown(ProductName, 1);
	        RetailPrice.sendKeys(String.valueOf(ApplicationUtility.genrateRondomNumber(5)));
	        SubmitButton.click();
	        
	        WaitUtility.inVisibilityOfElement(Loader, 15);
	         
	        if (driver.getCurrentUrl().equalsIgnoreCase("http://15.207.221.207/dealerList"))
	        {
	         softAssert.assertEquals(list1Row2Col.getText(),dealerName);
	         softAssert.assertEquals(list1Row3Col.getText(),dealerMail);
	         System.out.println("Dealer is created suceesfully");
	         ExtentListeners.test.log(Status.INFO, "Dealer is Created Suceesfully with this name "+dealerName);
	         ExtentListeners.test.log(Status.INFO, "Dealer mail id is "+dealerMail);
	         
	         
	        //pending code imapct ist radio button 
	         
	        SingleView_3Dot.click();
	        SingleViewButton.click();
	        WaitUtility.inVisibilityOfElement(Loader, 15);
	        ServicerTabButton.click();
	        WaitUtility.inVisibilityOfElement(Loader, 15); 
	        
	      if(dealerName.equalsIgnoreCase(list1Row2Col.getText()))
	      {
	      ExtentListeners.test.log(Status.PASS, dealerName+"is also servicer");  
	      }
	      else
	      {
	    	  ExtentListeners.test.log(Status.FAIL, dealerName+"is not work as a servicer"); 
	      }
	        
	        
	         
	        
	         
	        }
	        if (driver.getCurrentUrl().equalsIgnoreCase("http://15.207.221.207/addDealer"))
	        {
	        ExtentListeners.test.log(Status.INFO, "Dealer is not Created Suceesfully with this name ");
	        }
	        
			
		} catch (Exception e) {
			System.out.println("Issue in add dealer tab "+e);
		}
	}












}


package getcoverpages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import applicationUtility.ApplicationUtility;
import baseLibrary.BaseClass;
import extentlisteners.ExtentListeners;
import propertyUtility.PropertyUtility;
import waitUtility.WaitUtility;

public class LoginPage extends BaseClass{
	
	
	public LoginPage()
	{ 
		PageFactory.initElements(driver, this );
	}

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInButton;
	
	@FindBy(xpath="//*[text()='Invalid Credentials']")
    private WebElement invalidCredentials ;
	@FindBy(xpath="//*[text()='Email Required']")
	private WebElement emailValidation;
	@FindBy(xpath="//button[text()='Password Required']")
    private WebElement passwordValidation;
	@FindBy(xpath="//*[text()='Invalid email address']")
    private WebElement InvalidEmailaddress;
	@FindBy(xpath="//*[@class='mx-auto py-6 w-[160px] ']")
	private WebElement logoGetcover;
	
	
	 
	public void clickEmail() {
	    try {
	        
	        ApplicationUtility.click(emailField);
	        ExtentListeners.test.log(Status.INFO, "click email id");
	        emailField.sendKeys(PropertyUtility.getreadData("loginEmail"));
	        passwordField.click();
	       if(PropertyUtility.getreadData("loginEmail").isEmpty()) 
	       {
	    	   WaitUtility.visibilityOfElement(emailValidation, 2);
	    	   if (emailValidation.isDisplayed())
	    	   {
	    		   
		          ExtentListeners.test.log(Status.FAIL, "email value is null ");
		          Assert.fail("email field is requird");
	    	   
	       }}
	       String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	       
	       if(PropertyUtility.getreadData("loginEmail").matches(emailRegex))
	       {
	    	   ExtentListeners.test.log(Status.INFO, "fill the email field"); 
	       }
	       else
	       {
	    	 if(InvalidEmailaddress.getText().equalsIgnoreCase("Invalid email address"))
	    	 {
	    		 Assert.fail("Invalid email Address");
	    		 ExtentListeners.test.log(Status.FAIL, "Invalid email Address");
	    	 }
	       }
	       }

	     catch (Exception e) {
	        System.out.println("problem in click email field" + e);
	    }
	}


	public void clickPassword()
	{
		try {
			WaitUtility.visibilityOfElement(passwordField, 2);
			ApplicationUtility.click(passwordField); 
			passwordField.sendKeys(PropertyUtility.getreadData("loginPassword"));
			if(PropertyUtility.getreadData("loginPassword").isEmpty())
			{
				ExtentListeners.test.log(Status.FAIL, "password is empty" );
				Assert.fail("password is blank");
			}
		} catch (Exception e) {
			System.out.println("problem in  click eamil field" +e);
		}
}
	 public void clickSignIn()
	 {
		try {
			WaitUtility.visibilityOfElement(signInButton, 2);
	        ApplicationUtility.click(signInButton);
	        
	        ExtentListeners.test.log(Status.INFO, "click the sign in button");
	        	String currenturl=driver.getCurrentUrl();
	        	String homepageurl="http://15.207.221.207/dashboard";
//	        	
//	        	if(currenturl.equalsIgnoreCase(homepageurl)){
//	        		ExtentListeners.test.log(Status.INFO, "Login successfully" );
//	        		}
//	        	else {
//	        		WaitUtility.visibilityOfElement(invalidCredentials, 2);
//	        		if (invalidCredentials.isDisplayed())
//					{
//	        	ExtentListeners.test.log(Status.INFO, "invalid credentials " );	
//	        	Assert.fail("invalid credentials");
			//	}
			//	}
			
		} catch (Exception e) {
			System.out.println("problen in sign in button "+e);
		} }
	 }

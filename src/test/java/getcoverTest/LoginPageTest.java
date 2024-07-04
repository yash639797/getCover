package getcoverTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseLibrary.BaseClass;
import extentlisteners.ExtentListeners;
import getcoverpages.LoginPage;

public class LoginPageTest extends BaseClass
{

	LoginPage ob;
	
	@Test(priority = 0)
	public void verifyPageTitel() 
	{
		ob=new LoginPage(); 
		String expectedTitel="Get Cover";
		Assert.assertEquals(driver.getTitle(),expectedTitel);
		ExtentListeners.test.log(Status.INFO, "verify the get cover login page");
		
		
	}
	
	@Test(priority = 1)
	public void loginTest()
	{
		ob.clickEmail();
		ob.clickPassword();
		ob.clickSignIn();
	}
}

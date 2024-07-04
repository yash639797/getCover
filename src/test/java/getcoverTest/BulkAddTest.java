package getcoverTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import baseLibrary.BaseClass;
import getcoverpages.BulkAdd;

public class BulkAddTest extends BaseClass
{
   BulkAdd ob;
   @Test
	public void resellertest() throws InterruptedException, AWTException
	{
		ob= new BulkAdd();
		//ob.reseller();
	   //ob.order();
		ob.orderDynamic();
		//ob.dealer();
		//ob.customer();
	}
	
}

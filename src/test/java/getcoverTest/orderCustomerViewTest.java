package getcoverTest;

import org.testng.annotations.Test;

import baseLibrary.BaseClass;
import getcoverpages.orderInsideTheCustomerView;

public class orderCustomerViewTest extends BaseClass {

	
	orderInsideTheCustomerView ob;
	@Test
	public void orderTest() {
		
		ob=new  orderInsideTheCustomerView();
		ob.orderCustomerView();
		
	}
}

package getcoverTest;

import org.testng.annotations.Test;

import baseLibrary.BaseClass;
import getcoverpages.BulkClaim;

public class BulkClaimTest extends BaseClass
{
	BulkClaim ob;
	@Test
	public void bulkClaimTest()
	{
		ob=new BulkClaim();
		ob.bulkClaimAdd();
		
	}

}

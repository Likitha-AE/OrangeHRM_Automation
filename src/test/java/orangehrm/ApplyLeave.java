package orangehrm;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import pomclass.HomePage;
import pomclass.LeavePage;
import pomclass.PimPage;

@Listeners(generic_utilities.ListenerImplementaion.class)

public class ApplyLeave extends BaseClass {
	
	@Test
	public void applyLeave() {
		HomePage hp=new HomePage(driver);
		hp.clickLeave();
		LeavePage lp=new LeavePage(driver);
		lp.clickApply();
		lp.applyLeave(driver, 29, 30);
	}
	
}

package orangehrm;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import pomclass.HomePage;
import pomclass.PimPage;

@Listeners(generic_utilities.ListenerImplementaion.class)


public class CreateEmployee extends BaseClass {
	
	@Test
	public void createEmployee() {
		HomePage hp=new HomePage(driver);
		hp.pIM();
		PimPage pp=new PimPage(driver);
		pp.addemployee();
		pp.createEmployee(driver, "test", "script", "data", "test script data", "test@123", "test@123");
	}
}

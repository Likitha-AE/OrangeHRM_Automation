package orangehrm;

import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import pomclass.HomePage;
import pomclass.JobPage;

public class CreateJobTiltle extends BaseClass {
	
	@Test
	public void createJobTitle() {
		HomePage hp=new HomePage(driver);
		hp.clickAdmin();
		JobPage jp=new JobPage(driver);
		jp.createJobTitle("Test Engineer");
		System.out.println("Job got created");
	}
}

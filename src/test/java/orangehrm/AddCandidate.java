package orangehrm;

import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import pomclass.CandidatesPage;
import pomclass.HomePage;

public class AddCandidate extends BaseClass {

	@Test
	public void addCandidate() {
		HomePage hp=new HomePage(driver);
		hp.clickRecruitment();
		hp.clickRecruitment();
		CandidatesPage cp=new CandidatesPage(driver);
		cp.createCandidates("testing", "automation", "task", "test123@gmail.com");	
	}
}

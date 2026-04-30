package orangehrm;

import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import pomclass.HomePage;
import pomclass.VacanciesPage;

public class EditVacancy extends BaseClass {
	@Test
	public void editVacancy() {
		HomePage hp=new HomePage(driver);
		hp.clickRecruitment();
		VacanciesPage vp=new VacanciesPage(driver);
		vp.editVacancy("Head Of Finance");
		System.out.println("vacancy got updated");
	}
}

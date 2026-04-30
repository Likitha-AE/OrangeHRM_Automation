package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesPage {
	
	@FindBy(xpath = "//a[text()='Vacancies']")
	private WebElement vacancies;
	
	@FindBy(xpath="//div[text()='Junior Account Assistant']//following::div/descendant::i[@class='oxd-icon bi-pencil-fill']")
	private WebElement edit;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement arroed;
	
	@FindBy(xpath="//span[.='Finance Manager']")
	private WebElement role;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement hm;
	
	@FindBy(xpath = "//button[contains(.,'Save')] ")
	private WebElement save;

	public VacanciesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVacancies() {
		return vacancies;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getArroed() {
		return arroed;
	}

	public WebElement getRole() {
		return role;
	}

	public WebElement getHm() {
		return hm;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void editVacancy(String manager) {
		vacancies.click();
		edit.click();
		arroed.click();
		role.click();
		hm.sendKeys(manager);
		save.click();
		
	}

}

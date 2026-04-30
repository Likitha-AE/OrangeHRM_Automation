package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPage {
	@FindBy(xpath = "//span[contains(.,'Job')]")
	private WebElement jobdd;
	
	@FindBy(linkText ="Job Titles")
	private WebElement jtitle;
	
	@FindBy(xpath="//button[contains(.,'Add')] ")
	private WebElement add;
	
	@FindBy(xpath="//div[@class='oxd-input-group__label-wrapper']/following::div/input[@class='oxd-input oxd-input--active']")
	private WebElement job;

	public JobPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getJobdd() {
		return jobdd;
	}

	public WebElement getJtitle() {
		return jtitle;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getJob() {
		return job;
	}
	
	public void createJobTitle(String name) {
		jobdd.click();
		jtitle.click();
		add.click();
		job.sendKeys(name);
		
	}
}

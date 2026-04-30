package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Admin")
	private WebElement admin;
	
	@FindBy(linkText = "PIM")
	private WebElement pim;
	
	@FindBy(linkText ="Time")
	private WebElement time;
	
	@FindBy(linkText = "Leave")
	private WebElement leave;
	
	@FindBy(xpath="//span[.='Recruitment']")
	private WebElement recruitment;
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement profile;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getPim() {
		return pim;
	}

	public WebElement getTime() {
		return time;
	}

	public WebElement getLeave() {
		return leave;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getLogout() {
		return logout;
	}

	public void signOut(WebDriver driver) {
		profile.click();
		logout.click();
	}
	public void pIM() {
		pim.click();
	}
	
	public void clickLeave() {
		leave.click();
	}
	public void clickTime() {
		leave.click();
	}
	public void clickAdmin() {
		admin.click();
	}
	public void clickRecruitment() {
	recruitment.click();
	}
	
}

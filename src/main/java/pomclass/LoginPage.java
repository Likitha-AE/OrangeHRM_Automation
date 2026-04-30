package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="username")
	private WebElement usernameEdt;
	
	@FindBy (name="password")
	private WebElement passwordEdt;
	
	@FindBy(xpath ="//button[contains(.,'Login')]")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}

	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	public void login(String un,String pwd)
	{
		usernameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	

}

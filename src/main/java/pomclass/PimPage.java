package pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import generic_utilities.ExceptionHandling;
import generic_utilities.WebDriverUtils;

public class PimPage {
	
	@FindBy(xpath = "//a[.='Add Employee']")
	private WebElement addEmployee;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement fName;
	
	@FindBy(xpath ="//input[@name='lastName']")
	private WebElement lName;
	
	@FindBy(xpath="//input[@name='middleName']")
	private WebElement mName;
	
	
	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	private WebElement setpwd;
	
	@FindBy(xpath ="//button[contains(.,'Save')]")
	private WebElement save;
	

	public PimPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}


	public WebElement getAddEmployee() {
		return addEmployee;
	}


	public WebElement getfName() {
		return fName;
	}


	public WebElement getlName() {
		return lName;
	}


	public WebElement getmName() {
		return mName;
	}
	
	public WebElement getSetpwd() {
		return setpwd;
	}
	
	public void addemployee() {
		addEmployee.click();
	}

	public void createEmployee(WebDriver driver,String fn,String mn,String ln,String un,String pwd,String cpwd) {
		
		fName.sendKeys(fn);
		mName.sendKeys(mn);
		lName.sendKeys(ln);
		ExceptionHandling eh=new ExceptionHandling();
		eh.retryClick(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"), 3);
		driver.findElement(RelativeLocator.with(By.xpath("//input[@class='oxd-input oxd-input--active']")).below(By.xpath("//label[.='Username']"))).sendKeys(un);
		driver.findElement(RelativeLocator.with(By.xpath("//input[@class='oxd-input oxd-input--active']")).below(By.xpath("//label[.='Password']"))).sendKeys(pwd);
		driver.findElement(RelativeLocator.with(By.xpath("//input[@class='oxd-input oxd-input--active']")).below(By.xpath("//label[.='Confirm Password']"))).sendKeys(cpwd);
		save.click();
	}


	public void editEmployee(WebDriver driver, String string) {
		fName.sendKeys(string);
		mName.sendKeys(string);
		lName.sendKeys(string);
		save.click();
		
	}

}

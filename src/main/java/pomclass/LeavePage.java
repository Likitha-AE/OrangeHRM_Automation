package pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import generic_utilities.ExceptionHandling;

public class LeavePage {
	
	@FindBy(xpath = "//a[.='Apply']")
	private WebElement apply;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement dd;
	
	@FindBy(xpath = "//span[.='CAN - Personal']")
	private WebElement leavetype;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']")
	private WebElement clender;
	
	@FindBy(xpath = "//label[.='From Date']")
	private WebElement fDate;
	
	@FindBy(xpath = "//label[.='To Date']")
	private WebElement tDate;
	
	@FindBy(xpath = "//button[contains(.,'Apply')]")
	private WebElement submit;

	public LeavePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getApply() {
		return apply;
	}

	public WebElement getDd() {
		return dd;
	}

	public WebElement getLeavetype() {
		return leavetype;
	}

	public WebElement getClender() {
		return clender;
	}

	public WebElement getfDate() {
		return fDate;
	}

	public WebElement gettDate() {
		return tDate;
	}
	
	public void clickApply() {
		apply.click();
	}
	
	public void applyLeave(WebDriver d,int fd,int td) {
		ExceptionHandling eh=new ExceptionHandling();
		eh.retryForStaleElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"), 3);
		leavetype.click();
		d.findElement(RelativeLocator.with(By.xpath("//label[.='From Date']")).below(By.xpath("//i[@class='oxd-icon bi-calendar oxd-date-input-icon']"))).click();;
		d.findElement(By.xpath("//div[@class='oxd-calendar-date-wrapper']/div[.='"+fd+"']")).click();
		d.findElement(RelativeLocator.with(By.xpath("//label[.='To Date']")).below(By.xpath("//i[@class='oxd-icon bi-calendar oxd-date-input-icon']"))).click();;
		d.findElement(By.xpath("//div[@class='oxd-calendar-date-wrapper']/div[.='"+td+"']")).click();
		submit.click();
		
	}
	
	
	

}

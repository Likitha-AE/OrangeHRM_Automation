package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class CandidatesPage {
	
	@FindBy(xpath = "//a[.='Candidates']")
	private WebElement candidate;
	
	@FindBy(xpath = "//button[contains(.,'Add')]")
	private WebElement add;
	
	@FindBy(name="firstName")
	private WebElement fName;
	
	@FindBy(name = "middleName")
	private WebElement mName;
	
	@FindBy(name = "lastName")
	private WebElement lName;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement dd;

	@FindBy(xpath="//span[.='Payroll Administrator']")
	private WebElement role;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active' and @placeholder='Type here']")
	private WebElement email;
	
	@FindBy(xpath="//button[contains(.,'Save')]")
	private WebElement save;
	
	public CandidatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCandidate() {
		return candidate;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getfName() {
		return fName;
	}

	public WebElement getmName() {
		return mName;
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getDd() {
		return dd;
	}

	public WebElement getRole() {
		return role;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSave() {
		return save;
	}
	
	
	public void createCandidates(WebDriver d,String fn,String mn,String ln,String e) {
		candidate.click();
		WebDriverUtils wLib=new WebDriverUtils();
		wLib.waituntilelementToBeClickable(d, 10, add);
		add.click();
		fName.sendKeys(fn);
		mName.sendKeys(mn);
		lName.sendKeys(ln);
		dd.click();
		role.click();
		email.sendKeys(e);
		save.click();	
	}

}

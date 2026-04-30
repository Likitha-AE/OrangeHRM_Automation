package generic_utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pomclass.HomePage;
import pomclass.LoginPage;

public class BaseClass {
	public FileUtils fLib=new FileUtils();
	public JavaUtils jLib=new JavaUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public static ThreadLocal<WebDriver> wdriver=new ThreadLocal<WebDriver>();
	
	@BeforeClass(alwaysRun = true)
	public void launchTheBrowser() throws IOException
	{
		String env = fLib.getData("env");
		String BROWSER = fLib.getData("browser");
		String URL = fLib.getData(env+".url");
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		sdriver = driver;
		
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver, 15);
		System.out.println("Browser Launched");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException
	{
		String USERNAME = fLib.getData("username");
		String PASSWORD = fLib.getData("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		System.out.println("Logged into Appln");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logOut()
	{
		HomePage hp = new HomePage(driver);
		//hp.signOut(driver);
		System.out.println("Logged out From Appln");
	}
	
	@AfterClass(alwaysRun = true)
	public void closingBrowser()
	{
		driver.quit();
		System.out.println("Browser closed");
	}

}

package interviewscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.WebDriverUtils;

public class HandlingPopup {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.findElement(By.id("alertbtn")).click();
		 driver.switchTo().alert().accept();
		 Thread.sleep(2000);
		 driver.findElement(By.id("name")).sendKeys("testing");
		 driver.findElement(By.id("confirmbtn")).click();
		 driver.switchTo().alert().dismiss();
		 Thread.sleep(2000);
		 driver.quit();
		 
	}

}

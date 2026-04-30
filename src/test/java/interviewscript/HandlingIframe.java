package interviewscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframe {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.switchTo().frame("courses-iframe");
		 driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/descendant::a[.='JOIN NOW']")).click();
		 Thread.sleep(2000);
		 driver.quit();
		
	}

}

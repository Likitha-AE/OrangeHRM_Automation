package interviewscript;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.findElement(By.id("openwindow")).click();
		 String parent = driver.getWindowHandle();
		 driver.findElement(By.id("openWindow")).click();
		 Set<String> windows = driver.getWindowHandles();
		 for (String window : windows) {
		     if (!window.equals(parent)) {
		         driver.switchTo().window(window);
		         System.out.println(driver.getTitle());
		         driver.close();
		     }
		 }
		 
		 driver.switchTo().window(parent);
		 driver.findElement(By.xpath("//a[@class='_domainCTALink_125zm_44']")).click();
		 
	}

}

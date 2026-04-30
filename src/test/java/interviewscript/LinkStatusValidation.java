package interviewscript;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkStatusValidation {
	public static void main(String[] args) throws InterruptedException {
    String eachLink;
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    List<WebElement> links = driver.findElements(By.tagName("a"));
    System.out.println(links.size());
    for (WebElement link : links) {
        try {
            eachLink = link.getDomAttribute("href");
            URI uri = new URI(eachLink);
            URL url = uri.toURL();
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            
            if (http.getResponseCode() == 200) {
                System.out.println("pass " + eachLink + " -------> "
                        + http.getResponseMessage() + " -------> "
                        + http.getResponseCode());
            }
            else {
            	System.out.println("Status code is not equal to 200"+eachLink);
                }     
 
            } catch (Exception e) {
                System.out.println("Status code is not equal to 200");
            }
        }
 
        Thread.sleep(5000);
        driver.quit();
    }

}

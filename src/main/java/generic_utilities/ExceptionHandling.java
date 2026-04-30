package generic_utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionHandling {
	
	public WebElement retryForStaleElement(By locator, int maxAttempts) {
	    int attempts = 0;
	    while (attempts < maxAttempts) {
	        try {
	            return BaseClass.sdriver.findElement(locator);
	        } catch (StaleElementReferenceException e) {
	            attempts++;
	            System.out.println("Retrying due to stale element... Attempt: " + attempts);
	        }
	    }
	    throw new StaleElementReferenceException("Element remained stale after " + maxAttempts + " attempts");
	}
	
	public void retryClick(By locator, int maxAttempts) {
	    int attempts = 0;

	    while (attempts < maxAttempts) {
	        try {
	            WebDriverWait wait = new WebDriverWait(BaseClass.sdriver, Duration.ofSeconds(10));
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	            element.click();
	            return;
	        } catch (ElementNotInteractableException | TimeoutException e) {
	            attempts++;
	            System.out.println("Retrying click... Attempt: " + attempts);
	        }
	    }

	    throw new ElementNotInteractableException("Element not interactable after " + maxAttempts + " attempts");
	}

}

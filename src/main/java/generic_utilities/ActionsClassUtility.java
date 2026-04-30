package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassUtility {
	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}
	public void rightClickOnwebPage(WebDriver driver) {
		actions(driver).contextClick().perform();
	}
	public void rightClickOnEle(WebDriver driver,WebElement element) {
		actions(driver).contextClick(element).perform();
	}
	public void doubleClickWebPage(WebDriver driver) {
		actions(driver).doubleClick().perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement sourElement,WebElement targetElement) {
		actions(driver).dragAndDrop(sourElement,targetElement).perform();
	}
}

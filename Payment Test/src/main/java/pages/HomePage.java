package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			 .withTimeout(Duration.ofSeconds(20))
			 .pollingEvery(Duration.ofSeconds(5))
			 .ignoring(NoSuchElementException.class);

	String cartURL = "https://apps.experience.eyouthlearning.com/payment?_gl=1*17bbxhg*_gcl_au*MjA5Mzk0Mjg5NS4xNzQ2MjEwODY5";
	
	public void openCart(){
		driver.navigate().to(cartURL);
	}
}

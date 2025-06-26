package tests;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	protected WebDriver driver = new FirefoxDriver();
	protected String baseURL = "https://eyouthlearning.com/signin?redirect=/";
	
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			 .withTimeout(Duration.ofSeconds(600))
			 .pollingEvery(Duration.ofSeconds(20))
			 .ignoring(NoSuchElementException.class);
	
	
    @BeforeTest
    public void openBrowser() {
    	driver.manage().window().fullscreen();;
    	driver.navigate().to(baseURL);
    	
    	WebElement usernameTxt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		WebElement passwordTxt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
				 
		usernameTxt.sendKeys("sharar6");
		passwordTxt.sendKeys("nopasswordgiven");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div[1]/div/div[3]/form/div[3]/button")).click();
    }

    @AfterTest
    public void closeBrowser() {
    	driver.quit();
    }
}

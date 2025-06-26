package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	 FirefoxDriver driver;
	    private By userNameLoc = By.id("username");
	    private By passwordLoc = By.id("password");
	    private By LoginBtnLoc = By.className("signup--btn");

	    public Login(FirefoxDriver d)
	    {
	        this.driver = d;
	    }
	    
	    public void login()
		{
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		        driver.findElement(userNameLoc).sendKeys("sharar6");
		        driver.findElement(passwordLoc).sendKeys("nopasswordgiven");
		        driver.findElement(LoginBtnLoc).click();
		}
}

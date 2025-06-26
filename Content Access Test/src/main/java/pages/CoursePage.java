package pages;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursePage {

FirefoxDriver driver;
	
	public CoursePage(FirefoxDriver d) {
		this.driver = d;
	}
	
	public By startCourseBtn = By.cssSelector("a.btn");
	public By courseBanner = By.cssSelector(".next-btn");
	public By finalQuizDl = By.cssSelector("#courseHome-outline > li:nth-child(4) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2) > button:nth-child(1) > span:nth-child(1) > svg:nth-child(1)");
	public By finalQuizUrl = By.cssSelector(".text-break > span:nth-child(1) > a:nth-child(1)");
	public By questionSubmitBtn = By.cssSelector(".submit");
	public By ProgressBtn = By.cssSelector("a.nav-item:nth-child(2)");
	public By certificateStatus = By.cssSelector(".pgn__card-section");
	public By nextBtn = By.cssSelector(".next-btn");
	public By progressPercent = By.cssSelector(".donut-chart-number");
	public By certificateImg = By.cssSelector(".certificate-wrapper > header:nth-child(1) > img:nth-child(1)");
	
	public boolean userCanOpenCourseContent() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(startCourseBtn));
		driver.findElement(startCourseBtn).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(courseBanner));
		if(driver.findElement(courseBanner).isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean userCanOpenQuiz() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(finalQuizDl));
		driver.findElement(finalQuizDl).click();
		
		Actions builder = new Actions(driver);
		builder.scrollByAmount(0, 50).build().perform();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(finalQuizUrl));
		driver.findElement(finalQuizUrl).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(courseBanner));
		if(driver.findElement(courseBanner).isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean userCanSubmitNonAnswered() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		builder.scrollByAmount(0, 50).build().perform();
		
		 try {
		        driver.findElement(questionSubmitBtn);
		        return true; // Element is found
		    } catch (Exception e) {
		        return false; // Element does not exist
		    }
	}
	
	public boolean noCourseNoCertificate() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ProgressBtn));
		driver.findElement(ProgressBtn).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(certificateStatus));
		return driver.findElement(certificateStatus).getText() != "Download Certificate";
	}
	
	public void skipCourseContent() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(startCourseBtn));
		driver.findElement(startCourseBtn).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(courseBanner));
		
		for(int i = 0; i < 5 ; i++) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(nextBtn));
			driver.findElement(nextBtn).click();
		}
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ProgressBtn));
		driver.findElement(ProgressBtn).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(progressPercent));
	}
	
	public void availableCertificate() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(startCourseBtn));
		driver.findElement(startCourseBtn).click();
	}
}

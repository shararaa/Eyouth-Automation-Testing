package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	FirefoxDriver driver;
	
	public HomePage(FirefoxDriver d) {
		this.driver = d;
	}
	
	By confirmHome = By.xpath("/html/body/div/div/div[4]/div/div[1]/div");
	By allCoursesBtnLoc = By.xpath("/html/body/div/div/div[2]/div/div[1]/div/ul/div[1]/div/a");
	By freeCoursesCbLoc = By.id("Free");
	By subscripedCourseLinkLoc = By.cssSelector("#coursesbody > div > div:nth-child(4) > div > div.MuiCardContent-root.muirtl-r1q4z4 > strong > p");
	By nonSubscripedCourseLinkLoc = By.cssSelector("div.AllCoursesAndFilteration_singleCourseCard__OI7R1:nth-child(3) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > p:nth-child(1)");
	public By supscribedBtnLoc = By.xpath("/html/body/div/div/div[4]/div/div[1]/div[2]/div[3]/div/div[8]/div/div/button");
	By finishedCourse = By.cssSelector("div.AllCoursesAndFilteration_singleCourseCard__OI7R1:nth-child(2) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > p:nth-child(1)");
	
	
	public void navigateNonEnrolledCourse() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(confirmHome));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allCoursesBtnLoc));
		driver.findElement(allCoursesBtnLoc).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(nonSubscripedCourseLinkLoc));
		driver.findElement(nonSubscripedCourseLinkLoc).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(supscribedBtnLoc));
	}
	
	public void navigateEnrolledCourse() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(freeCoursesCbLoc));
		driver.findElement(freeCoursesCbLoc).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(subscripedCourseLinkLoc));
		driver.findElement(subscripedCourseLinkLoc).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(supscribedBtnLoc));
		driver.findElement(supscribedBtnLoc).click();
	}
	
	public void navigateFinshedCourse() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://eyouthlearning.com/all-courses?page=1&paid=false");
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(finishedCourse));
		driver.findElement(finishedCourse).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(supscribedBtnLoc));
		driver.findElement(supscribedBtnLoc).click();
	}
}

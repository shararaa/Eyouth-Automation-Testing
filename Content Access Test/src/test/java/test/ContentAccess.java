package test;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CoursePage;
import pages.HomePage;
import pages.Login;

public class ContentAccess {

	FirefoxDriver driver = new FirefoxDriver();
	HomePage HP;
	Login LP;
	CoursePage CP;
	
	@BeforeTest
	public void setup() {
		driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/signin?redirect=/");
        LP = new Login(driver);
        HP = new HomePage(driver);
        CP = new CoursePage(driver);
        LP.login();
	}
	
	@Test (priority = 1) //TC04
	public void userCanNotAccessNonEnrolledCourse() {
		HP.navigateNonEnrolledCourse();
		Assert.assertNotEquals(driver.findElement(HP.supscribedBtnLoc).getText(), "مشترك");
		driver.navigate().back();
	}
	
	@Test (priority = 2) //TC01
	public void userCanAccessCourse () {
		HP.navigateEnrolledCourse();
		Assert.assertTrue(CP.userCanOpenCourseContent());
		driver.navigate().back();
	}
	
	@Test (priority = 3) //TC07
	public void userCannotOpenFinalQuiz() {
		Assert.assertFalse(CP.userCanOpenQuiz());
	}
	
	@Test (priority = 4) //TC08
	public void userCanNotSubmitNonAnswered() {
		
		Assert.assertFalse(CP.userCanSubmitNonAnswered());
	}
	
	@Test (priority = 5) //TC09
	public void userCannotDownloadCertificateWithoutCompletingCourse() {
		driver.navigate().back();
		
		Assert.assertFalse(CP.noCourseNoCertificate());
		driver.navigate().back();
	}
	
	@Test(priority = 6) //TC05 ,TC06
	public void userCanNotSkipVideos() {
		driver.navigate().back();
		CP.skipCourseContent();
		Assert.assertEquals(driver.findElement(CP.progressPercent).getText() ,"0%");
	}
	
	@Test (priority = 7) //TC03
	public void userCanGetCertificate() {
		HP.navigateFinshedCourse();
		
		CP.availableCertificate();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://experience.eyouthlearning.com/certificates/4c84c4f4f9bb44d0bad7491d1e7a531c");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}

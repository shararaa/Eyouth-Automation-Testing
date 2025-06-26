package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.FawryPaymentPage;
import pages.HomePage;

public class FawryPaymentTests extends TestBase {
	
	//before running the tests you need to add some courses to your cart
	
	HomePage homePage = new HomePage(driver);
	CartPage cartPage = new CartPage(driver);
	FawryPaymentPage fawryPaymentPage = new FawryPaymentPage(driver);
	
	@Test (priority = 1 , groups = "fawry")
	public void continueBTNIsVisible() throws InterruptedException {
		Thread.sleep(3000);
		homePage.openCart();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(cartPage.continueBTN));
		Assert.assertTrue(cartPage.continueBTN.isDisplayed());
	}
	
	@Test (priority = 2 , groups = "fawry")
	public void proceedBTNIsVisible() throws InterruptedException {
		cartPage.continueBTN.click();
		
		Assert.assertTrue(cartPage.proceedBTN.isDisplayed() && !cartPage.proceedBTN.isEnabled());
		Assert.assertTrue(cartPage.fawryCodeCB.isDisplayed() && cartPage.fawryCodeCB.isEnabled());
		Assert.assertTrue(cartPage.creditCardCB.isDisplayed() && cartPage.creditCardCB.isEnabled());
	}
	
	@Test (priority = 3 , groups = "fawry")
	public void FawryCodeIsSent() throws InterruptedException {
		cartPage.paymentFawryCode();
		
		Assert.assertTrue(fawryPaymentPage.fawryIMG.isDisplayed());
		//To make sure the driver is at the right page
		
		fawryPaymentPage.continueBTN.click();
		Assert.assertTrue(fawryPaymentPage.homePageBTN.isDisplayed());
	}
}

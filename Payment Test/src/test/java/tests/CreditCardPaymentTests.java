package tests;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CreditCardPaymentPage;
import pages.FawryPaymentPage;
import pages.HomePage;

public class CreditCardPaymentTests extends TestBase {
	
	//before running the tests you need to add some courses to your cart
	
	HomePage homePage = new HomePage(driver);
	CartPage cartPage = new CartPage(driver);
	CreditCardPaymentPage creditCardPaymentPage = new CreditCardPaymentPage(driver);
	
	@DataProvider
	public Object[][] InvalidCardData(){
		Object[][] data = new Object[8][5];
		data[0][0] = "4223303285041639"; data[0][1]="Mohamed Sharara"; data [0][2] = "05"; data [0][3] = "20"; data [0][4] = "557";
		data[1][0] = "4223303285041639"; data[1][1]="Mohamed Sharara"; data [1][2] = "05"; data [1][3] = "29"; data [1][4] = "123";
		data[2][0] = "4223303285041639"; data[2][1]="Mohamed Sharara"; data [2][2] = "05"; data [2][3] = "29"; data [2][4] = "12";
		data[3][0] = "4223303285041639"; data[3][1]="Mohamed Sharara"; data [3][2] = "05"; data [3][3] = "29"; data [3][4] = "5==";
		data[4][0] = "4223303285041751"; data[4][1]="Mohamed Sharara"; data [4][2] = "05"; data [4][3] = "29"; data [4][4] = "557";
		data[5][0] = "4223303285041639"; data[5][1]="youssef Bahaa"; data [5][2] = "05"; data [5][3] = "29"; data [5][4] = "557";
		data[6][0] = "4223303285041639"; data[6][1]="Youssef Ba85# 562"; data [6][2] = "05"; data [6][3] = "29"; data [6][4] = "557";
		data[7][0] = ""; data[7][1]=""; data [7][2] = ""; data [7][3] = ""; data [7][4] = "";
		return data;
	}
	public Object[] validCardData(){
		Object[] data = new Object[5];
		data[0] = "4223303285041639"; data[1]="Fatma Aboul Fotouh"; data[2] = "05"; data[3] = "29"; data[4] = "557";
		return data;
	}
	
	
	@Test (priority = 4 , groups = "credit card")
	public void creditCardIsAccessible() throws InterruptedException {
		Thread.sleep(3000);
		homePage.openCart();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(cartPage.continueBTN));
		
		cartPage.continueBTN.click();
		cartPage.creditCardCB.click();
		cartPage.proceedBTN.click();
		
		Assert.assertTrue(creditCardPaymentPage.continueBTN.isDisplayed());
		Assert.assertTrue(creditCardPaymentPage.goBackBTN.isDisplayed());
	}
	
	@Test (priority = 5 , groups = "credit card" , dataProvider = "InvalidCardData")
	public void InvalidCreditCard(String cardNumber , String name , String month , String year , String cvv){
		int key = 1;
		creditCardPaymentPage.enterCardData(cardNumber, name, month, year, cvv);
		
		switch (key) {
		case 1:
			Assert.assertTrue(driver.findElement(By.cssSelector(".text-danger")).isDisplayed());
			break;

		case 2:
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(5) > small:nth-child(2)")).isDisplayed());
			break;
			
		case 3:
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(5) > small:nth-child(2)")).isDisplayed());
			break;
			
		case 4:
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(5) > small:nth-child(2)")).isDisplayed());
			break;
			
		case 5:
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(1) > small:nth-child(2)")).isDisplayed());
			break;
			
		case 6:
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(2) > small:nth-child(2)")).isDisplayed());
			break;
			
		case 7:
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(2) > small:nth-child(2)")).isDisplayed());
			break;
			
		case 8:
			creditCardPaymentPage.continueBTN.click();
			Assert.assertTrue(driver.findElement(By.cssSelector("div.form-group:nth-child(5) > small:nth-child(2)")).isDisplayed());
			break;
		}
		
		creditCardPaymentPage.clearCardData();
	}
	
	@Test (priority = 6 , groups = "credit card")
	public void validCreditCard() throws InterruptedException
 {
		creditCardPaymentPage.enterCardData("4223303285041639","Fatma Aboul Fotouh", "05", "29","557");
		creditCardPaymentPage.continueBTN.click();
		Thread.sleep(17000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("customerAuthFormAutoSubmit:validAuthentication"))));
		Assert.assertTrue(driver.findElement(By.id("customerAuthFormAutoSubmit:validAuthentication")).isDisplayed());
	}
}

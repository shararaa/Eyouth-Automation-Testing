package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardPaymentPage extends PageBase {

	public CreditCardPaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".mx-1")
	public WebElement goBackBTN;
	
	@FindBy(css = "button.btn:nth-child(2)")
	public WebElement continueBTN;
	
	@FindBy(id = "cardNumber")
	WebElement cardNumberTXT;
	
	@FindBy(id = "name")
	WebElement nameOnCardTXT;
	
	@FindBy(id = "cardExpiryMonth")
	WebElement expirationMonthTXT;
	
	@FindBy(id = "cardExpiryYear")
	WebElement expirationYearTXT;
	
	@FindBy(id = "cvv")
	WebElement cvvTXT;
	
	public void enterCardData(String cardNumber , String name , String month , String year , String cvv) {
		
		cardNumberTXT.sendKeys(cardNumber);
		nameOnCardTXT.sendKeys(name);
		expirationMonthTXT.sendKeys(month);
		expirationYearTXT.sendKeys(year);
		cvvTXT.sendKeys(cvv);
	}
	
	public void clearCardData () {
		cardNumberTXT.clear();
		nameOnCardTXT.clear();
		expirationMonthTXT.clear();
		expirationYearTXT.clear();
		cvvTXT.clear();
	}
}

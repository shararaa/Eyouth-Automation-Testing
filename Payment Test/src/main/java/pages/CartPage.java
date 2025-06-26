package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html/body/div/main/div/div/div/section/div/div/div[2]/div/section/div[2]/button")
	public WebElement continueBTN;
	
	@FindBy(id = "Fawry-Button")
	public WebElement fawryCodeCB;
	
	@FindBy(id = "Fawry-card")
	public WebElement creditCardCB;
	
	@FindBy(xpath = "/html/body/div/main/div/div/div/section/div/div/div[2]/div/section/div[1]/div[2]/form/div[4]/button[1]")
	public WebElement cancelBTN;
	
	@FindBy(css = ".btn-warning")
	public WebElement proceedBTN;
	
	public void paymentFawryCode() {
		fawryCodeCB.click();
		proceedBTN.click();
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FawryPaymentPage extends PageBase {

	public FawryPaymentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "img.imgFawry")
	public WebElement fawryIMG;
	
	@FindBy(id = "fawryCodeGen")
	public WebElement continueBTN;

	@FindBy(css = ".btn-primary")
	public WebElement homePageBTN;
}

package SumeetGaikwad.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SumeetGaikwad.abstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	
	 public CheckoutPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	
	 
	 @FindBy(css=".ta-item:nth-child(3)")
		WebElement selectcountry;
	 @FindBy(css=".action__submit")
		WebElement submit;
	 @FindBy(xpath="//input[@placeholder='Select Country']")
		WebElement country;
	 By results=By.cssSelector(".ta-results");
	 
	 public void selectCountry(String countryName)
	 {
		   Actions a=new Actions(driver);
	       a.sendKeys(country, countryName).build().perform();
	       waitForElementToAppear(results);
	       selectcountry.click();
	 }
	 public void submitOrder()
	 {
		 submit.click();
	 }
}

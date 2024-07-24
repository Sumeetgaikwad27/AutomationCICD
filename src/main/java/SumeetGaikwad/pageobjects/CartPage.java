package SumeetGaikwad.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SumeetGaikwad.abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	 public CartPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	
     @FindBy(css=".totalRow button")
	WebElement checkoutEle;
     @FindBy(css=".cartSection h3")
 	private List <WebElement> productTitles;
      
     
    public Boolean VerifyProductDisplay(String Pname)
    {
    	Boolean match=productTitles.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Pname));
    	return match;
    }
    
    public void checkOutPage()
    {
    	checkoutEle.click();
    }
    	
}

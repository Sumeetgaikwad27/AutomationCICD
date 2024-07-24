package SumeetGaikwad.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SumeetGaikwad.abstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	
	 public ProductCatalogue(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	// List<WebElement> prods=driver.findElements(By.cssSelector(".mb-3"));
     @FindBy(css=".mb-3")
	List <WebElement> products;
    By products1= By.cssSelector(".mb-3");
    By addToCart=By.cssSelector(".card-body button:last-child");
    By toastmsg=By.id("toast-container");
    @FindBy(css=".ng-animating")
	WebElement spinner;
     
    public List<WebElement> getProductList()
    {
    	waitForElementToAppear(products1);
    	return products;
    }
    
    public WebElement getProductByName(String Pname)
    {
    	 WebElement prod=getProductList().stream().filter(products->
    	 products.findElement(By.cssSelector("b")).getText().equals(Pname)).findFirst().orElse(null);
         return prod;
    }
    
    public void addToCart(String Pname)
    {
    	WebElement prod=getProductByName(Pname);
    	 prod.findElement(addToCart).click();
    	 waitForElementToAppear(toastmsg);
    	 waitForElementToDisappear(spinner);
    }
     
}

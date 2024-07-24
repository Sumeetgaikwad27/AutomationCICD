package SumeetGaikwad.Tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SumeetGaikwad.TestComponents.BaseTest;
import SumeetGaikwad.pageobjects.CartPage;
import SumeetGaikwad.pageobjects.CheckoutPage;
import SumeetGaikwad.pageobjects.ConfirmationPage;
import SumeetGaikwad.pageobjects.LandingPage;
import SumeetGaikwad.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

     @Test(dataProvider="getData", groups={"Purchase"})
     public void submitOrder(HashMap<String,String> input) throws IOException
     {
		
		
        lp.LoginApplication(input.get("email"), input.get("password"));
        
        ProductCatalogue productCatelogue=new ProductCatalogue(driver);
       List <WebElement>products=productCatelogue.getProductList();
       productCatelogue.addToCart(input.get("Pname"));
       productCatelogue.goToCart();
       
       CartPage cartPage=new CartPage(driver);
       Boolean match=cartPage.VerifyProductDisplay(input.get("Pname"));
       Assert.assertTrue(match);
       cartPage.checkOutPage();
       CheckoutPage checkoutPage=new CheckoutPage(driver);
       checkoutPage.selectCountry("india");
       checkoutPage.submitOrder();
       ConfirmationPage confirmationpage=new ConfirmationPage(driver);
       String confirmationmsg=confirmationpage.getConfirmationMessage();
       Assert.assertTrue(confirmationmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        
	}
    @DataProvider
    public Object[][] getData() throws IOException
    {
    	//return new Object[][] {{"sumeet@gmail.com","Sumeet@123", "ZARA COAT 3"},{"sumeet@gmail.com","Sumeet@123", "ADIDAS ORIGINAL"}}; 
    	List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SumeetGaikwad\\data\\PurchaseOrder.json");
		return new Object[][]  {{data.get(0)},{data.get(1)}} ;
    
    }
}

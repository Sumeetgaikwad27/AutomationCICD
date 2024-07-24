package SumeetGaikwad.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SumeetGaikwad.TestComponents.BaseTest;
import SumeetGaikwad.TestComponents.Retry;
import SumeetGaikwad.pageobjects.CartPage;
import SumeetGaikwad.pageobjects.CheckoutPage;
import SumeetGaikwad.pageobjects.ConfirmationPage;
import SumeetGaikwad.pageobjects.LandingPage;
import SumeetGaikwad.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest {

     @Test(retryAnalyzer=Retry.class)
     public void submitOrder() throws IOException
     {
		
		String Pname="ZARA COAT 3";
        lp.LoginApplication("sumeet@gmail.com", "Sumeet@12");
        Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg()); 
	}
 
}

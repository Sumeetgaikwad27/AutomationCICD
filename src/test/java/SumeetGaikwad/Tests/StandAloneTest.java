package SumeetGaikwad.Tests;

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

import SumeetGaikwad.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String Pname="ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage lp=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("sumeet@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Sumeet@123");
		driver.findElement(By.id("login")).click();
        List<WebElement> prods=driver.findElements(By.cssSelector(".mb-3"));
        
        WebElement prod=prods.stream().filter(products->products.findElement(By.cssSelector("b")).getText().equals(Pname)).findFirst().orElse(null);
        
        prod.findElement(By.cssSelector(".card-body button:last-child")).click();
        
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
       
       
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
       driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
       
       List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean match=cartproducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Pname));
       Assert.assertTrue(match);
       driver.findElement(By.cssSelector(".totalRow button")).click();
       Actions a=new Actions(driver);
       a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "ind").build().perform();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
       driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
       
       driver.findElement(By.cssSelector(".action__submit")).click();
       
       String confirmmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       driver.close();
       
       
        
        
        
	}
 
}

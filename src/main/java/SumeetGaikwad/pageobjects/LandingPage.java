package SumeetGaikwad.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SumeetGaikwad.abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	
	 public LandingPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	//Webelement useremail=driver.findElement(By.cssSelector("#userEmail"))
     @FindBy(css="#userEmail")
	WebElement useremail;
     
     //driver.findElement(By.cssSelector("#userPassword"))
     @FindBy(css="#userPassword")
 	WebElement userpass;
     
     //driver.findElement(By.id("login"))
     @FindBy(id="login")
  	WebElement login;
     
     @FindBy(css="[class*='flyInOut']")
 	WebElement errorMsg;
     
     public void goTo()
     {
    	 driver.get("https://rahulshettyacademy.com/client/");
     }
   
     public String getErrorMsg()
     {
    	 waitForWebelementToAppear(errorMsg);
    	 return errorMsg.getText();
     }

	public void LoginApplication(String email, String pass) {
		// TODO Auto-generated method stub
		useremail.sendKeys(email);
    	userpass.sendKeys(pass);
    	login.click();
	}
}

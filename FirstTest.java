package tESTING;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DonaMavenSelenium.DonaMavenSelenium.Webdriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	 WebDriver driver;
	 
	 
	
	By contact= By.linkText("Contact us");
	By valid1= By.className("navigation_page");
	By sign= By.linkText("Sign in");
	By valid2= By.linkText("Forgot your password?");
//@BeforeMethod	
@BeforeTest
public void setup() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	this.driver=driver;
	driver.get("http://automationpractice.com/index.php");
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}

@Test(priority=1)

public void Contact() {
	
	driver.findElement(contact).click();
	
	Assert.assertTrue(driver.findElement(valid1).isDisplayed());
}

@Test(priority=2,dependsOnMethods="Contact")
public void Signin() {

	driver.findElement(sign).click();
	String expected=driver.getTitle();
	String actual= "Login - My Store";
	Assert.assertEquals(expected, actual);
}
//@AfterMethod
@AfterTest
	public void quit() {
	driver.quit();
	
}




	
	

	
	
}

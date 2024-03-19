package normalflowusingtestng;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BankingAppthroughTestNg {
	
	public WebDriver driver;
	public Faker faker;
	public String fullname; 
	
	
	
	//Driver open,Window,Maximize
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		faker=new Faker();
		
		
		
	}
	
	@Test(priority = 0)
	public void BankManagerLogin() {
	driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
	String actualresult=driver.findElement(By.xpath("//button[@ng-class=\"btnClass1\"]")).getText();
	Assert.assertEquals(actualresult,"Add Customer");	
	}
	
	@Test(priority = 1,testName = "To verify the Add customer Functionality")
	public void AddCustomer() {
		    driver.findElement(By.xpath("//button[@ng-class=\"btnClass1\"]")).click();
	        WebElement firstname=driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
	        WebElement lastname=driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
	        WebElement postcode=driver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]"));                
	        String fname=faker.name().firstName();
	        String lname=faker.name().lastName();
	        String pcode=faker.address().zipCode();  
	        fullname=fname+" "+lname;	              
	        firstname.sendKeys(fname);
	        lastname.sendKeys(lname);
	        postcode.sendKeys(pcode);	        
	        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	        String actual=driver.switchTo().alert().getText();
	        String Expected="Customer added successfully with customer id";	        
	        SoftAssert as=new SoftAssert();
	        as.assertTrue(actual.contains(Expected));	     	       
	        driver.switchTo().alert().accept();
	}
	
	
	@AfterClass
     public void shutdown() {
		driver.quit();
	}

	
	

}

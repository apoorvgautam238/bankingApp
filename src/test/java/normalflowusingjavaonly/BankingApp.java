package normalflowusingjavaonly;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class BankingApp {
	
	//public static WebElement firstname;
	
	//Framework:- Oops -Inheritance,Objects,Encapulation,Interface,Collection,Modifier,Super,this etc,TestNg plugin,TestNG dependency;
	public static void main(String[] args) throws Exception {

		
		Faker faker=new Faker();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().minimize();
        //Dimension d=new Dimension(200, 400);
        //driver.manage().window().setSize(d);
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[@ng-class=\"btnClass1\"]")).click();
        WebElement firstname=driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        WebElement lastname=driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        WebElement postcode=driver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]"));                
        String fname=faker.name().firstName();
        String lname=faker.name().lastName();
        String pcode=faker.address().zipCode();        
        System.out.println(fname+"--"+lname+"--"+pcode);        
        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        postcode.sendKeys(pcode);	        
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();        
        Alert alert=driver.switchTo().alert();
        String alertcontent=alert.getText();
        System.out.println(alertcontent);
        alert.accept();
        driver.findElement(By.xpath("//button[@ng-class=\"btnClass2\"]")).click();
        String fullname=fname+" "+lname;
        WebElement customername=driver.findElement(By.xpath("//select[@name=\"userSelect\"]"));
        Select select=new Select(customername);
        //select.selectByIndex(1);
        //Thread.sleep(3000);
        select.selectByVisibleText(fullname);
        //Thread.sleep(3000);
        //select.selectByValue("11");
        //Thread.sleep(4000);
        WebElement currency=driver.findElement(By.xpath("//select[@name=\"currency\"]"));
        Select selectcurrency=new Select(currency);
        selectcurrency.selectByVisibleText("Rupee");  
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
        WebElement custo=driver.findElement(By.xpath("//select[@id=\"userSelect\"]"));
        Select customerlogin=new Select(custo);
        customerlogin.selectByVisibleText(fullname);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        
        }
	

	   
}



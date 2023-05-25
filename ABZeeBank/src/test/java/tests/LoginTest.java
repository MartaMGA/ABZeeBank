package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class LoginTest {
  
WebDriver d;
@Test
public void loginTest() {
	
	
d.get("https://demowebshop.tricentis.com");

		d.manage().window().maximize();
		d.findElement(By.linkText("Log in")).click();
		
		//d.findElement(By.partialLinkText("Shopp")).click();
		d.findElement(By.id("Email")).sendKeys("Itest@test.com");
		d.findElement(By.name("Password")).sendKeys("Itest@test");
		// XPATH : //tagname[@attribute='value'][@attribute='value']
		//d.findElement(By.xpath("//input[@value='Log in']")).click();
		
		//css=tagname[attribute='value'][attribute='value']
		d.findElement(By.cssSelector("input[value='Log in']")).click(); 
		
		String ER="Itest@test.com";
		String AR;
		try {
			
			AR=d.findElement(By.xpath("//a[@href='/customer/info']")).getText();
		}
catch (Exception e)
{
	AR=null;
}
		
		Assert.assertEquals(AR, ER);
}
			
		/*WebElement logout;
		try
		{	
	logout =d.findElement(By.linkText("Log out"));
	logout.click();
		} catch (Exception e)
		{
			//logout=null;
		}
		
		//Assert.assertNotNull(logout);
		//Assert.fail("Log on button is not present...");*/
		

@AfterTest


@BeforeTest
public void setup ()	
{
	System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
	d=new ChromeDriver();

}
}
package com.intertrust;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import javax.swing.text.AbstractDocument.Content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class Homepage {
	
	
	private static final boolean Acceptcookies = false;
	WebDriver driver=new ChromeDriver();
	//WebDriver driver;
	VcWebelements objvcwebelements;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30,1 ));
	FileReader fs;
	Properties prop;
	
	
	@BeforeTest
	public void sample() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\welcome\\Documents\\RESTapi-javaAutom-udmey\\myproject\\src\\main\\resources\\Driver\\chromedriver.exe");
		
		fs=new FileReader("C:\\Users\\welcome\\Documents\\RESTapi-javaAutom-udmey\\myproject\\TestData.properties");
		prop=new Properties();
		prop.load(fs);
		driver.get(prop.getProperty("url"));
		//driver.get("https://www.visualcrossing.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
		@Test(priority = 1)
	
		public void launchhome() throws InterruptedException
		{
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			objvcwebelements=new VcWebelements(driver);
			boolean str =  objvcwebelements.Acceptcookies.isDisplayed();
			if(str)
			{
				
				objvcwebelements.Acceptcookies.click();
				System.out.println("Accepted the cookies");
				objvcwebelements.weatherdata.click();
				System.out.println("Clicked on the Weather Data Menu");
				driver.manage().window().maximize();
			}else {
		
				System.out.println("Cookies Not Found");
				objvcwebelements.weatherdata.click();
		
			}
			
			wait.until(ExpectedConditions.visibilityOf(objvcwebelements.enterlocation));
			objvcwebelements.enterlocation.sendKeys(prop.getProperty("Location"));
			objvcwebelements.searchbutton.click();
			String title = driver.getTitle();
			System.out.println("Tittle of the page- " +title);
			assertEquals(title, prop.getProperty("PageTitle"));
			
			
				
		}
		
		@Test(priority = 2)
		public void driverclose() {
			String hdrtlt = objvcwebelements.HeaderTitle.getText();
			assertEquals(hdrtlt, prop.getProperty("HeaderTitle"));
			String home= objvcwebelements.weatherHistory.getText();
			System.out.println(home);
			assertEquals(home, prop.getProperty("Location"));
			System.out.println("closing the driver");
			driver.close();
			
		}
		
}

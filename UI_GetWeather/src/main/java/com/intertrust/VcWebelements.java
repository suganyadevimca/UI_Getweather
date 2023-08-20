package com.intertrust;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VcWebelements {

	WebDriver driver;
	@FindBy(xpath="//*[@class='nav-link text-nowrap'][text()='Weather Data']")
	public WebElement weatherdata;
	@FindBy(xpath="//input[@placeholder='Enter a location']")
	public WebElement enterlocation;
	@FindBy(xpath="//button[@type='submit'][text()='Search']")
	public WebElement searchbutton;
	@FindBy(xpath="//button[text()='Accept all cookies']")
	public WebElement Acceptcookies;
	@FindBy(xpath="//section//h1")
	public WebElement HeaderTitle;
	@FindBy(xpath="//a[@id='locationDropdownMenuButton']")
	public WebElement weatherHistory;
	
	
	
	public VcWebelements(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
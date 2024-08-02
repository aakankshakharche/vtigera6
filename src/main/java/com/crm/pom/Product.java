package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {

	public Product(WebDriver driver){
		PageFactory.initElements(driver, this);
	} 
	
	private @FindBy(xpath = "//img[@title='Create Product...']")
	WebElement createprod;
	private @FindBy(name = "productname")
	WebElement proname;
	private @FindBy(name = "vendor_name")
	WebElement vendorname;
	private @FindBy(xpath = "//input[@name='button']")
	WebElement prosavebu;
	private @FindBy(className = "dvHeaderText")
	WebElement headertext;
		
	public void createProd() {
		createprod.click();
	}
	public void proName(String name) {
		proname.sendKeys(name);		
	}
	public void vendorName(String name) {
		vendorname.sendKeys(name);		
	}
	public void proSaveBu() {
		prosavebu.click();
	}
	
	public WebElement headerText() {
		return headertext;
	}
}

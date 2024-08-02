package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomVendor {

	public PomVendor(WebDriver driver){
		PageFactory.initElements(driver, this);
	} 
	
	private @FindBy(linkText = "Vendors")
	WebElement venddor;
	private @FindBy(xpath = "//img[@title='Create Vendor...']")
	WebElement venplus;
	private @FindBy(name = "vendorname")
	WebElement venname;
	private @FindBy(xpath = "//input[@name='button']")
	WebElement vensavebu;
	
	public void vend() {
		venddor.click();
	}
	public void venPlus() {
		venplus.click();
	}
	public void venName(String vname) {
		venname.sendKeys(vname);
	}
	public void venSaveBu() {
		vensavebu.click();
	}
	private @FindBy(className = "dvHeaderText")
	WebElement headertext;
	
	public WebElement headerText() {
		return headertext;
	}
	
}

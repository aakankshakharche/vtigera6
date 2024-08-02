package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Organization {

	public Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	private @FindBy(xpath = "//img[@title='Create Organization...']")
	WebElement clickonplusbu;
	private @FindBy(name = "accountname")
	WebElement orgname;
	private @FindBy(xpath = "//input[@name='button']")
	WebElement savebu;
	private @FindBy(className = "dvHeaderText")
	WebElement headertext;
	private @FindBy(name = "industry")
	WebElement indus;
	public void indusDropdown() {		
		Select se=new Select(indus);
		se.selectByValue("Chemicals");
	}
	
	public void clickOnPlusBu() {
		clickonplusbu.click();
	}
	public void orgName(String oname) {
		orgname.sendKeys(oname);
	}
	public void saveBu() {
		savebu.click();
	}
	public WebElement headerText() {
		return headertext;
	}
	
}

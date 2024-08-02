package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "(//td[@class='small'])[2]")
	WebElement signno;
	private @FindBy(linkText = "Sign Out")
	WebElement signout;
	
	public WebElement signNo() {
		return signno;
	}	
	
	public void signOut() {
		signout.click();
	}
	private @FindBy(linkText = "Organizations")
	WebElement orgclick;
	
	public void clickOnOrg()
	{
		orgclick.click();
	}
	private @FindBy(linkText = "Contacts")
	WebElement clickoncon;
	
	public void conClick() {
		clickoncon.click();
	}
	private @FindBy(linkText = "More")
	WebElement more;
	public WebElement more() {
		return more;
	}
	private @FindBy(linkText = "Products")
	WebElement prod;
	public void prodOp() {
		prod.click();
	}
}

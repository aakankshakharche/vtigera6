package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomOfLogin {

	public PomOfLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	private @FindBy(name = "user_name")
	WebElement username;
	private @FindBy(name = "user_password")
	WebElement password;
	private @FindBy(id = "submitButton")
	WebElement submitbutton;
	
	
	public void userName(String uname) {
		username.sendKeys(uname);	
	} 
	public void pass(String pas) {
		password.sendKeys(pas);
	}
	public void submitBu() {
		submitbutton.click();
	}
	
}

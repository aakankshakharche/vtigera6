package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.JavaUtility.SDateAndEndJavaUtility;

public class Contact {

	public Contact(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(xpath = "//img[@title='Create Contact...']")
	WebElement clickcontplus;
	private @FindBy(name = "lastname")
	WebElement lasname;
	private @FindBy(xpath = "//img[@language='javascript']")
	WebElement orgnameplus;
	private @FindBy(xpath = "(//a[@href='javascript:window.close();'])[11]")
	WebElement orgname;
	private @FindBy(xpath = "//input[@value='T']")
	WebElement group;
	private @FindBy(name = "support_start_date")
	WebElement sustartdateclick;
	private @FindBy(name = "support_end_date")
	WebElement suenddateclick;
	private @FindBy(id = "dtlview_Support Start Date")
	WebElement srdate;
	private @FindBy(id = "dtlview_Support End Date")
	WebElement enddate;
	private @FindBy(xpath = "//input[@name='button']")
	WebElement savebu;
	
	private @FindBy(linkText = "componentName")
	WebElement orgnamehead;
	private @FindBy(id = "search_txt")
	WebElement search;
	private @FindBy(name = "")
	WebElement searchbu;
	public void conPlusClick() {
		clickcontplus.click();
	}
	public void lasName(String name) {
		lasname.sendKeys(name);
	}
	public void orgName() {
		orgnameplus.click();
	}
	public void organizeNme() {
		orgname.click();
	}
	public void groupCheckbox() {
		group.click();
	}
public void suStartDate() {
		
		String sdate = SDateAndEndJavaUtility.startDate("yyyy-MM-dd");
		sustartdateclick.sendKeys(sdate);
		System.out.println(sdate);
	}
	public void suEndDate() {		
		String edate = SDateAndEndJavaUtility.endDate("yyyy-MM-dd");
		suenddateclick.sendKeys(edate);
		System.out.println(edate);
	}
	public WebElement sDate() {
		return srdate;
	}
	public WebElement eDate() {
		return enddate;
	}
	public void conSaveBu() {
		savebu.click();
	}
	public WebElement orgniz() {
		return orgnamehead;
	}
	public  void searchTex(String name) {
		search.sendKeys(name);                               
	} 
}

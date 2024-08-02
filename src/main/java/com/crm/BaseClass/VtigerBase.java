package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.JavaUtility.VtigerJavaUtility;
import com.crm.pom.Homepage;
import com.crm.pom.PomOfLogin;



public class VtigerBase {

public static WebDriver driver;

     VtigerJavaUtility vj=new VtigerJavaUtility();
	
	@BeforeClass
	public void preCondition() throws IOException {
		String browser = vj.loginData("browserv");
		String url = vj.loginData("urlv");
		if (browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String username = VtigerJavaUtility.loginData("usernamev");
		String password = VtigerJavaUtility.loginData("passwordv");
		
		PomOfLogin log=new PomOfLogin(driver);
		log.userName(username);
		log.pass(password);
		log.submitBu();
	}
	
	@AfterMethod
	public void logout() {		
		Actions ac=new Actions(driver);
		Homepage log=new Homepage(driver);
		WebElement signo =log.signNo(); //driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		ac.moveToElement(signo).build().perform();
		ac=new Actions(driver);                                            //td[@class='small'])[2]
		log.signOut();                                                             
	}
	
	@AfterClass
	public void pastCondition() {
		driver.quit();
	}
}

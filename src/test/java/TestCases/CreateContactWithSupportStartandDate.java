package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.JavaUtility.SDateAndEndJavaUtility;
import com.crm.fileutility.CreateOrganiz;
import com.crm.pom.Contact;
import com.crm.pom.Homepage;

@Listeners(com.crm.listeners.VtigerListeners.class)

public class CreateContactWithSupportStartandDate extends VtigerBase {

	@Test(retryAnalyzer = com.crm.listeners.IretryAnalyzer.class)
	public void conWithstartandendDate() throws InterruptedException, IOException {
		
		Contact con=new Contact(driver);
		Homepage hm=new Homepage(driver);
		hm.conClick();
		con.conPlusClick();
		CreateOrganiz co=new CreateOrganiz();
		String lname = co.createOrgExcel("Sheet3", 0, 0);
		con.lasName(lname);
		con.groupCheckbox();
		Actions ac=new Actions(driver);
		ac.keyDown(Keys.PAGE_DOWN).build().perform();		
		
		Thread.sleep(1000);
		con.suStartDate();
		Thread.sleep(1000);
		con.suEndDate();
		Thread.sleep(1000);
		con.conSaveBu();
		
		//String startdate = SDateAndEndJavaUtility.startDate("yyyy-MM-dd");
		//System.out.println(startdate);
		//String enddate = SDateAndEndJavaUtility.endDate("yyyy-MM-dd");
		//System.out.println(enddate);
		//assertTrue(con.sDate().getText().contains(startdate));
		//assertTrue(con.eDate().getText().contains(enddate));
		
		//System.out.println(con.sDate().getText());
		
	}
}

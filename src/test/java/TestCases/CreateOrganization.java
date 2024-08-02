package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.JavaUtility.RandomUtility;
import com.crm.fileutility.CreateOrganiz;
import com.crm.pom.Homepage;
import com.crm.pom.Organization;
@Listeners(com.crm.listeners.VtigerListeners.class)


public class CreateOrganization extends VtigerBase{

	@Test(retryAnalyzer = com.crm.listeners.IretryAnalyzer.class)
	public void createOrganization() throws IOException {
		
		Organization org=new Organization(driver);
		Homepage hm=new Homepage(driver);
		hm.clickOnOrg();
		org.clickOnPlusBu();
		CreateOrganiz co=new CreateOrganiz();
		String oname = co.createOrgExcel("Sheet1", 0, 0);
		org.orgName(oname+RandomUtility.generateRandomNumber());
		org.saveBu();
		
		assertTrue((org.headerText().getText().contains(oname)));
	}
}

package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.JavaUtility.RandomUtility;
import com.crm.fileutility.CreateOrganiz;
import com.crm.pom.Homepage;
import com.crm.pom.Organization;

@Listeners(com.crm.listeners.VtigerListeners.class)

public class CreateOrganizationWithIndustry extends VtigerBase {

	@Test(retryAnalyzer = com.crm.listeners.IretryAnalyzer.class)
	public void orgwithIndustry() throws IOException {
		
		Organization org=new Organization(driver);
		Homepage hm=new Homepage(driver);
		hm.clickOnOrg();
		org.clickOnPlusBu();
		CreateOrganiz co=new CreateOrganiz();
		String creorg = co.createOrgExcel("Sheet2", 0, 0);
		org.orgName(creorg+RandomUtility.generateRandomNumber());
		org.indusDropdown();
		org.saveBu();
		assertTrue(org.headerText().getText().contains(creorg));
		
	}
}

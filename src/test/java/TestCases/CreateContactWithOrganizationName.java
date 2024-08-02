package TestCases;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.JavaUtility.RandomUtility;
import com.crm.fileutility.CreateOrganiz;
import com.crm.pom.Contact;
import com.crm.pom.Homepage;
@Listeners(com.crm.listeners.VtigerListeners.class)

public class CreateContactWithOrganizationName extends VtigerBase{

	@Test (retryAnalyzer = com.crm.listeners.IretryAnalyzer.class)
	public void creaConWiOrgName() throws IOException {
		Contact cn=new Contact(driver);
		Homepage hm=new Homepage(driver);
		hm.conClick();
		cn.conPlusClick();
		CreateOrganiz co=new CreateOrganiz();
		String lname = co.createOrgExcel("Sheet4", 0, 0);
		cn.lasName(lname);
		cn.orgName();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		child.remove(parent);
		for (String str : child) {
			driver.switchTo().window(str);
			if (cn.orgniz().isDisplayed()) {
				String ser = co.createOrgExcel("Sheet4", 1, 0);
				cn.searchTex(ser);
				
				
			}
		}
		//cn.organizeNme();
		//driver.navigate().back();
		cn.groupCheckbox(); 
		cn.conSaveBu();
	}
}

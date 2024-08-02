package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.fileutility.CreateOrganiz;
import com.crm.pom.Homepage;
import com.crm.pom.PomVendor;



public class CreateVendor extends VtigerBase{

	@Test
	public void createVendor() throws IOException {
		
		
		Actions ac=new Actions(driver);
		Homepage hm=new Homepage(driver);
		WebElement more =hm.more() ;
		ac.moveToElement(more).build().perform();
		PomVendor ven=new PomVendor(driver);
		ven.vend();
		ven.venPlus();
		CreateOrganiz co=new CreateOrganiz();
		String vname = co.createOrgExcel("Sheet5", 0, 0);
		ven.venName(vname);
		ven.venSaveBu();		
		//assertTrue((ven.headerText().getText().contains(vname)));
		
	}
}

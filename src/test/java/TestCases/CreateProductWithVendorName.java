package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.VtigerBase;
import com.crm.fileutility.CreateOrganiz;
import com.crm.pom.Homepage;
import com.crm.pom.Product;
@Listeners(com.crm.listeners.VtigerListeners.class)


public class CreateProductWithVendorName extends VtigerBase{

	@Test
	public void createProduct() throws IOException {
		
		Product crv=new Product(driver);
		Homepage hm=new Homepage(driver);
		hm.prodOp();
		crv.createProd();
		CreateOrganiz co=new CreateOrganiz();
		String pname = co.createOrgExcel("Sheet6", 0, 0);
		crv.proName(pname);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement vendorname = driver.findElement(By.name("vendor_name"));
		js.executeScript("arguments[0].value='shriram';", vendorname);
		crv.proSaveBu();
		//WebElement proname = driver.findElement(By.className("lvtHeaderText"));
		//assertTrue(crv.headerText().getText().contains(null));
	}
}

package com.crm.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateOrganiz {

	
	public String createOrgExcel(String sheetname,int row, int cell) throws IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CreateConfi.xlsx"); 
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		String s = sheet.getRow(row).getCell(cell).toString();
		return s;
	}
}

package com.ReadingDataFromPDFExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

public class ExcelDataSupplier extends driver{
@DataProvider
public Object[][] getData() throws Exception{
	
	String filepath = "C:\\Suresh\\com.dtcc\\src\\main\\resources\\TestData.xlsx";
	FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("sheet1");
	int noOfRows = sheet.getPhysicalNumberOfRows();
	int noOfColumns = sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[noOfRows-1][noOfColumns];
	for(int i=0;i<noOfRows-1;i++) {
		for(int j=0;j<noOfColumns;j++) {
			DataFormatter df = new DataFormatter();
			data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}
	}
	
	workbook.close();
	fis.close();
	
	return data;
	
}
	
	

}

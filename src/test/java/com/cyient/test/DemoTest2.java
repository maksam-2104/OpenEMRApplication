package com.cyient.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("src/test/resources/testdata/OpenEMRdata.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("ValidCredentialTest");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cellcount);
		
		Object[][] main = new Object[rowCount-1][cellcount];
		
		for(int r=1;r<rowCount;r++)
		{
			for(int c=0;c<cellcount;c++)	{
				
				
				 XSSFRow row= sheet.getRow(r);
	                XSSFCell cell= row.getCell(c);
	                
	                DataFormatter format = new DataFormatter();
	                String Cellvalue= format.formatCellValue(cell);
	                System.out.println(Cellvalue);

	                main[r-1][c] = Cellvalue;
			}
		}	
				
				//convert the excel value into excel arrays
	        	System.out.println(main[0][0]);
				System.out.println(main[1][2]);
				
			}
		

	}



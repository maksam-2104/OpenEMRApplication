package com.cyient.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("src/test/resources/testdata/OpenEMRdata.xlsx");
XSSFWorkbook book = new XSSFWorkbook(file);
XSSFSheet sheet = book.getSheet("ValidCredentialTest");
//XSSFRow row = sheet.getRow(2);
//XSSFCell cell = row.getCell(1);

//String cellValue = cell.getStringCellValue();
//System.out.println(cellValue);


for(int r=1;r<3;r++)
{
	for(int j=0;j<4;j++)


        {
            for(int c=0;c<4;c++)
            {
                XSSFRow row= sheet.getRow(r);
                XSSFCell cell= row.getCell(c);

 

                DataFormatter format = new DataFormatter();
                String Cellvalue= format.formatCellValue(cell);
                System.out.println(Cellvalue);
            }
        }
}
	}




	}




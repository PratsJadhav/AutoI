package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestBase.TestBase;

public class ExcelReader extends TestBase{
	String [][]data = null;
	FileInputStream fis;
	FileOutputStream fos;
	File file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
			
	public String[][] getExcelData() throws IOException
	{
		file = new File(System.getProperty("user.dir")+"\\InputFiles\\data.xlsx");
	    fis = new FileInputStream(file);
	    workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		
		int total_rows = sheet.getLastRowNum()+1;
		int total_columns = sheet.getRow(0).getLastCellNum();
		System.out.println("total number of rows = "+total_rows);
		System.out.println("total number of columns = "+total_columns);
		
		data = new String[total_rows][total_columns];
		
		for(int i= 0; i < total_rows;i++)
		{
			row = sheet.getRow(i);
			
			for(int j=0 ; j < total_columns; j++)
			{
				cell = row.getCell(j);
				
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				{
					data[i][j] = cell.getStringCellValue();
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					String s = String.valueOf(cell.getNumericCellValue());
					data[i][j] = s;
				}
			}
		}
		
	    
		return data;
	}
	

}

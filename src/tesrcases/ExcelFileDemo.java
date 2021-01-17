package tesrcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileDemo {

	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 int lastnum;
	
   ExcelFileDemo() throws IOException
	{
	  
	  String excelFilePath = "data files\\login_details.xlsx";
		 
	    FileInputStream inputstream = new FileInputStream(excelFilePath); 
	    
	    workbook = new XSSFWorkbook(inputstream);
	}
	
	
	public ArrayList<String> userName() {
		
		sheet= workbook.getSheetAt(0);
	   
	    Row row;
	    lastnum = sheet.getLastRowNum();
	    
	    
      ArrayList <String>usernames = new ArrayList<String>();
	    
	    for(int i=1;i<=lastnum;i++)
	    {
	    	row = sheet.getRow(i);
	    	usernames.add(row.getCell(0).getStringCellValue());
	    }
	  
		return usernames;
	}
	
	public ArrayList<String> password() {
		sheet= workbook.getSheetAt(0);
		lastnum = sheet.getLastRowNum();
	  
	    Row row;
	    
	    ArrayList <String>passwords = new ArrayList<String>();
	    
	    for(int i=1;i<=lastnum;i++)
	    {
	    	row = sheet.getRow(i);
	    	passwords.add(row.getCell(1).getStringCellValue());
	    }
	    
		return passwords;
	   
	}
	

}

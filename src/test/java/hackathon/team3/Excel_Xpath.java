package hackathon.team3;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Xpath {
	public String[] readFromExcel() throws Exception
	{
		//Create an object of File class to open xlsx file
		  File src=new File(System.getProperty("user.dir")+"//Excel//hackathon_excel.xlsx");
		 
		//Create an object of FileInputStream class to read excel file
		   FileInputStream fis=new FileInputStream(src);
		 
		   //creating object of XSSFWorkbook class
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		     //Read excel sheet by sheet name  
		      XSSFSheet sh1= wb.getSheetAt(0);
		      
		      //counting number of rows
		      int rowCount=sh1.getLastRowNum();
		      
		    //creating a String array to hold the elements of the sheet
		      String str[]=new String[6];
		 
		    
		    int k=0;
		  for(int i=1;i<(rowCount+1);i++) //loop to get the row index
		  {
		      Row row=sh1.getRow(i);//storing the row of a particular index
		     for(int j=1;j<row.getLastCellNum();j++) //loop to get the elements of each row
		     {
		    	// Cell cell =row.getCell(j);
		    	 
		    		 str[k]=row.getCell(j).getStringCellValue(); //storing the elements 
		    	 
		    		 k++; //incrementing the count
		     }
		   //  System.out.println();
		}
		  
		  return str; //returning the String array
	}
	
}

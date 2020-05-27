package hackathon.team3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excel_Write {
	
	public void writeIntoExcel(String shelfName, String shelfPrice, int row) throws Exception
	{
		
		File src=new File(System.getProperty("user.dir")+"//Excel//Hackathon_Print.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		Sheet s=wb.getSheetAt(0);
	
		
		
		Row r1=s.getRow(row);
		
		r1.createCell(1).setCellValue(shelfName);
		r1.createCell(2).setCellValue(shelfPrice);
		
//		Row r2=s.createRow(2);
//		
//		r1.createCell(1).setCellValue("");
//		r1.createCell(2).setCellValue("");
//		
//		Row r3=s.createRow(3);
//		
//		r1.createCell(1).setCellValue("");
//		r1.createCell(2).setCellValue("");
		
		FileOutputStream fos=new FileOutputStream(src);
		wb.write(fos);
        fos.close();       		
	
}
}

package Base.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData {
	//public Workbook book;
	XSSFWorkbook book;

	public ExcelData() throws Exception{

		FileInputStream fis= new FileInputStream("./Testdata/data.xlsx");
		 book =new XSSFWorkbook(fis);
		
		
		//Workbook book= WorkbookFactory.create(fis);
		//book= WorkbookFactory.create(fis);
	}


	public String config(String sheet,int row,int cell) {

		return book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

	}



}

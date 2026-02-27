package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	public Object[][] readExcel() throws IOException {
		File file = new File(System.getProperty("user.dir") +"/testData/Opencart_LoginData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		System.out.println("Data from ExcelSheet");
		for (int r = 1; r <= rowCount; r++) {
			XSSFRow currenrow = sheet.getRow(r);
			for (int c = 0; c < colCount; c++) {
				
				System.out.print(currenrow.getCell(c).toString()+" \t");
				data[r - 1][c] = currenrow.getCell(c).toString();
			}
			System.out.println();
		}

		workbook.close();
		fis.close();
		return data;
	}
	
}

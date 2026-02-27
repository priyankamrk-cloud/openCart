package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name = "dp")
	public static Object[][] getData() throws IOException {
		 return new Excelutility().readExcel();
	}

}

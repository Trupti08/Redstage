package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	 XSSFSheet sheet;
	XSSFWorkbook wb;
	String FilePath;

	static Properties properties;

	public static void readExcel() throws IOException {
		
		XSSFSheet sheet;
		XSSFWorkbook wb;

		try {
			File src = new File("D:\\Redstage\\TestData\\TestData.xlsx");

			FileInputStream fs = new FileInputStream(src);

			wb = new XSSFWorkbook(fs);

			// this is to get the access to Sheet1.
			sheet = wb.getSheetAt(0);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		System.out.println("Rest code is executed");
		
	}

	public String getData(int row, int col) throws IOException {

	
			readExcel();
		
		
		String data = sheet.getRow(row).getCell(col).getStringCellValue();

		return data;
	}

	public static void readConfigData() throws IOException {

		try {
			FileReader reader = new FileReader("configuration.properties");
			properties = new Properties();
			properties.load(reader);

		} catch (FileNotFoundException e) {
			System.out.println("File is not found in the mentioned location");
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Input parameters are incorrect");
			e.printStackTrace();
		}
	}

	public static String getObject(String propertyName) throws IOException {

		readConfigData();

		return properties.getProperty(propertyName);

	}
}

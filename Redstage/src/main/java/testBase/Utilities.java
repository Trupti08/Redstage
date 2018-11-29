package testBase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utilities  {

	static Map<String, String> locatorMap;
	static Map<String, String> dataMap;
	public static Properties properties;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@Test(dependsOnMethods = { "loadConfigurationProperties" }, description = "This is used to load locator file")
	public void loadLocatorMap() {
		try {
			locatorMap = new HashMap<>();
			FileInputStream file = new FileInputStream(Testbase.configPath + properties.getProperty("Locatorfile"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);

			int i = 0;
			for (i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				sheet.getRow(0).getCell(i).getStringCellValue();

				locatorMap.put(sheet.getRow(0).getCell(i).getStringCellValue(),
						sheet.getRow(1).getCell(i).getStringCellValue());

				workbook.close();

			}
			Log.log.info("Locator file is loaded");
		} catch (FileNotFoundException e) {
			Log.log.info("File is not found in the mentioned location");
			e.printStackTrace();
		}

		catch (IOException e) {
			Log.log.fatal("Input parameters are incorrect");
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "loadLocatorMap" })
	public  String fetchLocators(String locatorName) {
		return locatorMap.get(locatorName);
	}

	@Test(dependsOnMethods = { "loadConfigurationProperties" }, description = "This is used to load Test data file")
	public void loadTestDataMap() {
		try {
			dataMap = new HashMap<>();

			FileInputStream file = new FileInputStream(Testbase.configPath + properties.getProperty("TestDatafile"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);

			int i = 0;
			for (i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				sheet.getRow(0).getCell(i).getStringCellValue();

				dataMap.put(sheet.getRow(0).getCell(i).getStringCellValue(),
						sheet.getRow(1).getCell(i).getStringCellValue());
				workbook.close();
			}

			Log.log.info("Test data file is loaded");
		} catch (FileNotFoundException e) {
			Log.log.fatal("File is not found in the mentioned location");
			e.printStackTrace();
		}

		catch (IOException e) {
			Log.log.fatal("Input parameters are incorrect");
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "loadTestDataMap" })
	public String fetchTestData(String testData) {
		return dataMap.get(testData);
	}

	public void loadConfigurationProperties() {

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

	@Test(dependsOnMethods = { "loadConfigurationProperties" })
	public String fetchProperties(String propertyName) {
		return properties.getProperty(propertyName);

	}

	public void implementLog() {
		DOMConfigurator.configure(properties.getProperty("LogFile"));
	}

	
	public void implementReport() {
		extent = new ExtentReports(Testbase.configPath + properties.getProperty("extentReportPath"));
		extent.addSystemInfo("Host Name", "Windows 07").addSystemInfo("User Name", "Honey");
	}

	@Test(description = "This is a recurring activity, implement it in every test")
	public void startTest(String testName) {
		logger = extent.startTest(testName);
	}

	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}

	@Test(description = "This is one time activity, implement it in After test")
	public void flushReport() {
		extent.flush();
		extent.close();
	}

	public void writeTextFile(String text) {
		  try {
	            FileWriter writer = new FileWriter("MyFile.txt", true);
	            writer.write(text);
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
	}

	public String readTextFile() {
		String readLine = null;
		try {
			FileReader reader = new FileReader("MyFile.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			readLine = bufferedReader.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return readLine;

	}

}

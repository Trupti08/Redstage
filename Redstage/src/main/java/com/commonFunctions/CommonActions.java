package com.commonFunctions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

import com.log.Log;

import testBase.Testbase;

public class CommonActions extends Testbase {
	
	
	public void myClick(String xpath) {
		try {
			element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
			element.click();
			Log.log.info("Operation Click has been performed on element with xpath " + xpath);
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation Click has not been performed on element with xpath " + xpath);
		}
	}

	public void myClickWithControl(String xpath) {
		try {
			element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
			element.sendKeys(Keys.CONTROL);
			element.click();
			Log.log.info("Operation click with control has been performed on element with xpath " + xpath);
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation click with control has not been performed on element with xpath " + xpath);
		}
	}

	public void eClick(String xpath) {
		try {
			element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Log.log.info("Operation Executor click has been performed on element with xpath " + xpath);
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation Executor click has not been performed on element with xpath " + xpath);
		}
	}

	public void eClickWithControl(String xpath) {
		try {
			element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
			element.sendKeys(Keys.CONTROL);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Log.log.info("Operation Executor click with control has been performed on element with xpath " + xpath);
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error(
					"Operation Executor click with control has not been performed on element with xpath " + xpath);
		}
	}

	public void sendKeysByInput(String xpath, String input) {

		try {
			element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
			element.clear();
			element.sendKeys(input);
			Log.log.info("Operation Sendkeys has been performed on element with xpath " + xpath + " and " + input
					+ " has been entered ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation Sendkeys has not been performed on element with xpath " + xpath + " and " + input
					+ " has not been entered ");
		}
	}

	public void selectDropDownByText(String xpath, String input) {

		try {
			Select select = new Select(driver.findElement(By.xpath(waitForWebElement(xpath, 60000))));
			select.selectByVisibleText(input);
			Log.log.info("Operation Dropdown has been performed on element with xpath " + xpath + " and " + input
					+ " has been entered ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation Dropdown has not been performed on element with xpath " + xpath + " and " + input
					+ " has not been entered ");
		}
	}

	public void selectDropDownByValue(String xpath, String input) {

		try {
			Select select = new Select(driver.findElement(By.xpath(waitForWebElement(xpath, 60000))));
			select.selectByValue(input);
			Log.log.info("Operation Dropdown has been performed on element with xpath " + xpath + " and " + input
					+ " has been entered ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation Dropdown has not been performed on element with xpath " + xpath + " and " + input
					+ " has not been entered ");

		}
	}

	public void selectDropDownByIndex(String xpath, int input) {

		try {
			Select select = new Select(driver.findElement(By.xpath(waitForWebElement(xpath, 60000))));
			select.selectByIndex(input);
			Log.log.info("Operation Dropdown has been performed on element with xpath " + xpath + " and " + input
					+ " has been entered ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error("Operation Dropdown has not been performed on element with xpath " + xpath + " and " + input
					+ " has not been entered ");
		}
	}

	public void hover(String xpath) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.xpath(waitForWebElement(xpath, 60000)))).build().perform();
			Log.log.info("Operation Hover has been performed on element with xpath " + xpath);
		} catch (Exception e) {
			Log.log.error("Operation Hover has not been performed on element with xpath " + xpath);
			e.printStackTrace();
		}
	}

	public void switchToDefaultContent() {

		try {
			driver.switchTo().defaultContent();
			Log.log.info("Driver has been moved to default content");
		} catch (Exception e) {
			Log.log.error("Driver has not been moved to default content");
			e.printStackTrace();
		}
	}

	public void switchToFrame(String frameName) {
		try {
			driver.switchTo().frame(frameName);
			Log.log.info("Driver has been moved to frame " + frameName);
		} catch (Exception e) {
			Log.log.error("Driver has not been moved to frame " + frameName);
			e.printStackTrace();
		}
	}

	public void switchToWindow(String winHandle) {

		try {
			String firstWinHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			handles.remove(firstWinHandle);
			winHandle = handles.iterator().next();

			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle; // Storing handle of second window handle
				driver.switchTo().window(secondWinHandle);
				Log.log.info("Driver has been moved to window " + winHandle);
			}
		} catch (Exception e) {
			Log.log.fatal("Driver has not been moved to window " + winHandle);
			e.printStackTrace();
		}
	}

	public void takesScreenshot(String methodName) {
		try {
			File file = new File("Screenshot");
			// System.out.println(file.getAbsolutePath());
			TakesScreenshot scrShot = ((TakesScreenshot) Testbase.driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			fileName = file.getAbsolutePath() + "\\" + methodName + System.currentTimeMillis() + ".png";
			File DestFile = new File(fileName);
			FileUtils.copyFile(SrcFile, DestFile);
			Log.log.info("Operation screenshot has been performed and copied to location ");
		} catch (Exception e) {
			Log.log.warn("Operation screenshot has not been performed and copied to location ");
			e.printStackTrace();
		}
	}

	public boolean isTitleEquals(String input) {

		try {
			String title = driver.getTitle();
			AssertJUnit.assertEquals(title, input);
			Log.log.info("Title present in page is correct");
			flag = true;
		} catch (Exception e) {
			flag = false;
			Log.log.warn("Title present in page is incorrect");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean isTextDisplay(String xpath) {

		try {
			element = driver.findElement(By.xpath(waitForWebElement(xpath, 15000)));
			
			String Text=element.getText();
			
			Assert.assertEquals(Text, "Product Info >");

			Log.log.info("Text present in element with xpath " + xpath + " is correct");
			
			flag = true;
		} catch (Exception e) {
			Log.log.warn("Element with xpath " + xpath + " is not in web page");
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public void selectCheckBox(String xpath) {
		try {

			element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
			if (element.isSelected()) {
				Log.log.info("Element with xpath " + xpath + " is already selected");
			} else {
				element.click();
				Log.log.info("Element with xpath " + xpath + " is selected now");
			}
		} catch (ElementNotVisibleException e) {
			Log.log.warn("Element with xpath " + xpath + " is not in web page");
			e.printStackTrace();
		}
	}

	public String waitForWebElement(String xpath, int maxTimeInMilliSeconds) {
		flag = true;
		long startTime = System.currentTimeMillis();

		do {
			JavascriptExecutor executor = (JavascriptExecutor) Testbase.driver;
			flag = ((String) executor.executeScript("return document.readyState")).equals("complete");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (System.currentTimeMillis() - startTime > maxTimeInMilliSeconds) {
				System.out.println("Element is not present in page");
				break;
			}
		} while (flag = false);

		return xpath;
	}

	public void implementExplicitWait(String xpath, String waitType) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 45);
			switch (waitType) {
			case "Visible":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				Thread.sleep(3000);
				Log.log.info("Element with xpath " + xpath + " is visible now");
				break;

			case "Clickable":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				Thread.sleep(3000);
				Log.log.info("Element with xpath " + xpath + " is clickable now");
				break;

			case "Invisible":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				Thread.sleep(3000);
				Log.log.info("Element with xpath " + xpath + " is invisible now");
				break;
			}
		}

		catch (Exception e) {
			Log.log.warn("Explicit wait for element with xpath " + xpath + " is not working");
		}
	}

	public void implementExplicitWait(String xpath, String waitType, int waitTime) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			switch (waitType) {
			case "Visible":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				Thread.sleep(3000);
				Log.log.info("Element with xpath " + xpath + " is visible now");
				break;

			case "Clickable":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				Thread.sleep(3000);
				Log.log.info("Element with xpath " + xpath + " is clickable now");
				break;

			case "Invisible":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
				Thread.sleep(3000);
				Log.log.info("Element with xpath " + xpath + " is invisible now");
				break;
			}
		}

		catch (Exception e) {
			Log.log.warn("Explicit wait for element with xpath " + xpath + " is not working");
		}
	}

	public boolean isElementPresent(String xpath) {
		try {
			element = driver.findElement(By.xpath(xpath));
			if (element.isDisplayed()) {
				Log.log.info("Element with xpath " + xpath + " is present");
				flag = true;
			}

			else {
				flag = false;
				Log.log.info("Element with xpath " + xpath + " is not present");
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
		return flag;
	}

	public String getText(String xpath) {
		element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
		String text = element.getText();
		Log.log.info("Element with xpath " + xpath + " has text " + text);
		return text;

	}

	public String getAttribute(String xpath, String attribute) {
		element = driver.findElement(By.xpath(waitForWebElement(xpath, 60000)));
		String value = element.getAttribute(attribute);
		System.out.println(value);
		Log.log.info("Element with xpath " + xpath + " has value " + value);
		return value;

	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		Log.log.info("All cookies has been deleted");
	}

	public boolean isElementSelected(String xpath) {
		element = driver.findElement(By.xpath(xpath));
		if (element.isSelected()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	public int getCount(String xpathOfCountTag) {
		List<WebElement> elementPresentInPage = new ArrayList<>();
		elementPresentInPage = driver.findElements(By.xpath(xpathOfCountTag));
		Log.log.info("Number of elements present in xpath " + xpathOfCountTag + " is " + elementPresentInPage.size());
		return elementPresentInPage.size();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	
	
	
	

}

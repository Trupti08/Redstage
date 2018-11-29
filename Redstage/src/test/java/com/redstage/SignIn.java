package com.redstage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.pagewiseFunctions.Login;
import com.pagewiseLocators.LocatorofSignInPage;


import testBase.Testbase;




public class SignIn {

	CommonActions actions = new CommonActions();
	Login login = new Login();
	Testbase testbase = new Testbase();
	

	@BeforeMethod
	public void beforeMethod() throws IOException {
		testbase.startBrowser();
		testbase.deleteAllCookies();
		Testbase.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	
	/*
	 * Steps:Summary: Login with valid credentials. 
	 * 1.Enter url 
	 * 2.Click on Sign In
	 * 3.Enter Username 4.Enter Password 5.Click on Submit
	 * 
	 * Expected:User should able to login with valid credentials.
	 */

	@Test(priority = 1)



	public void validLogin() throws IOException {

		login.signInLink();

		login.enterUserName();

		login.enterPassword();

		login.clickOnSubmit();
		
		Log.log.info("User is Login with valid crdentials");

	}

	@Test(priority = 2)

	/*
	 * Steps:Summary: Login with Invalid credentials. 1.Enter url 
	 * 2.Click on Sign In
	 * 3.Enter invalid Username
	 *  4.Enter invalid Password 5.Click on Submit
	 * 
	 * Expected:User should not able to login with Invalid credentials.
	 */

	public void invalidLogin() throws IOException {

		login.signInLink();

		login.enterUserName();

		login.enterPassword();

		login.clickOnSubmit();
		
		String errorMessage= actions.getText(LocatorofSignInPage.errorMessagetext);
		
		Assert.assertEquals(errorMessage, "Invalid login or password");
		
		Log.log.info("User is not able to login with Invalid credentials");

		

	}

}

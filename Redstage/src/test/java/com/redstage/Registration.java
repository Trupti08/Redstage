package com.redstage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.pagewiseFunctions.Login;
import com.pagewiseFunctions.RegistrationForm;

import testBase.Testbase;

public class Registration {

	CommonActions actions = new CommonActions();
	Login login = new Login();
	RegistrationForm registration = new RegistrationForm();
	Testbase testbase = new Testbase();


	@BeforeMethod
	public void beforeMethod() throws IOException {
		testbase.startBrowser();
		testbase.deleteAllCookies();
		Testbase.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/*
	 * Steps:Summary: Registration Form 1.Enter url 2.Click on Create
	 * Account/Registration 3.Enter Valid data in all mandatory fields 4.Click on
	 * Submit
	 * 
	 * Expected:User should able to Registered successfully with valid data.
	 */

	@Test(priority = 1)

	public void validRegistration() throws IOException {

		login.signInLink();
		registration.clickonRegistrationLink();
		registration.enterInputs();
		registration.credentialsDeatils();
		Log.log.info("User is Registered Suceesfully");

	}

}

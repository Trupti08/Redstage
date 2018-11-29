package com.pagewiseFunctions;

import java.io.IOException;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.pagewiseLocators.LocatorofSignInPage;

import testBase.ExcelRead;

public class Login {
	CommonActions commonAction = new CommonActions();

	ExcelRead excel = new ExcelRead();

	public boolean signInLink() {

		boolean IsSignIn = false;
		try {

			if (commonAction.isElementPresent(LocatorofSignInPage.signInLink)) {

				commonAction.eClick(LocatorofSignInPage.signInLink);

				Log.info("Click on SignIn");
				IsSignIn = true;

			} else {

				Log.info("SignIn link is not present");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return IsSignIn;

	}

	public void enterUserName() throws IOException {
		String userName = ExcelRead.getObject("userName");

		commonAction.sendKeysByInput(LocatorofSignInPage.username, userName);
		Log.info("User Name is Entered");

	}

	public void enterPassword() throws IOException {
		String password = ExcelRead.getObject("password");

		commonAction.sendKeysByInput(LocatorofSignInPage.password, password);
		Log.info("Password Name is Entered");

	}

	public void clickOnSubmit() {
		commonAction.myClick(LocatorofSignInPage.submitButton);
		Log.info("Submit button is Clicked");

	}

}

package com.pagewiseFunctions;

import com.commonFunctions.CommonActions;
import com.log.Log;
import java.io.IOException;
import com.pagewiseLocators.LocatorsofRegistrationForm;

import testBase.ExcelRead;


public class RegistrationForm  {

	CommonActions commonAction = new CommonActions();

	
   /*click on Account/registration Link*/
	
	
	public boolean clickonRegistrationLink() {

		boolean isClicked = false;

		if (commonAction.isElementPresent(LocatorsofRegistrationForm.registration_link)) {

			commonAction.myClick(LocatorsofRegistrationForm.registration_link);

			Log.log.info("Sucessfully click on Link");
			isClicked = true;

		}
		return isClicked;
	}

	
	/*Enter personal information like first and Last name.*/
	
	
	public boolean enterInputs( ) throws IOException {
		
		boolean isEntered = false;
		String firstNameData = ExcelRead.getObject("firstNameData");
		String lastNameData = ExcelRead.getObject("lastNameData");
		
		

		if (commonAction.isElementPresent(LocatorsofRegistrationForm.firstName)) {

			commonAction.sendKeysByInput(LocatorsofRegistrationForm.firstName, firstNameData);

			Log.log.info("First Name is Entered");

			if (commonAction.isElementPresent(LocatorsofRegistrationForm.lastName)) {
				commonAction.sendKeysByInput(LocatorsofRegistrationForm.lastName, lastNameData);

				Log.log.info("Last Name is Entered");

				isEntered = true;

			}

		}

		return isEntered;

	}
	
	
	/*Enter login deatils like email id ,password and confirm Password*/

	public boolean credentialsDeatils() throws IOException {
		boolean isSubmitted = false;
		
		String EmailData = ExcelRead.getObject("EmailData");
		String PasswordData = ExcelRead.getObject("PasswordData");
		String ConfirmPasswordData = ExcelRead.getObject("ConfirmPasswordData");
		
		

		if (commonAction.isElementPresent(LocatorsofRegistrationForm.email)) {
			commonAction.sendKeysByInput(LocatorsofRegistrationForm.email, EmailData);
			Log.log.info("Email id  is entered");

			if (commonAction.isElementPresent(LocatorsofRegistrationForm.checkBox)) {
				commonAction.selectCheckBox(LocatorsofRegistrationForm.checkBox);
				Log.log.info("Checkbox is selected");
			

				if (commonAction.isElementPresent(LocatorsofRegistrationForm.password)) {
					commonAction.sendKeysByInput(LocatorsofRegistrationForm.password, PasswordData);
					Log.log.info("Password   is entered");

					if (commonAction.isElementPresent(LocatorsofRegistrationForm.confirmPassword)) {
						commonAction.sendKeysByInput(LocatorsofRegistrationForm.confirmPassword, ConfirmPasswordData);
						Log.log.info("confirmPassword  is entered");

						commonAction.myClick(LocatorsofRegistrationForm.submit);
						Log.log.info("Registration form is submitted");
					}

				}

			}

		}
		return isSubmitted;

	}
}

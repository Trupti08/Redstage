package com.pagewiseFunctions;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.pagewiseLocators.LocatorsOfProductDetailsPage;

public class ProductDetailsPage {

	CommonActions commonAction = new CommonActions();

	/* This method is used to verify Product details Page */

	public boolean verifyProductDetailsPage() {

		boolean isverify = false;

		if (commonAction.isTextDisplay(LocatorsOfProductDetailsPage.productinfoText)) {

			Log.log.info("Text Displayed");

			if (commonAction.isTextDisplay(LocatorsOfProductDetailsPage.serachResultofText)) {

				Log.log.info("Search result displayed)");

				isverify = true;

			}

		} else {

			if (commonAction.isElementPresent(LocatorsOfProductDetailsPage.productDescription)) {

				Log.log.info("Product description is present");

				isverify = true;

			}
		}
		return isverify;

	}
	
	
	
	/* This method is used to verifyAdd To Cart Button */

	public boolean verifyAddToCartButton() {

		boolean isPresent = false;

		if (commonAction.isElementPresent(LocatorsOfProductDetailsPage.addToCartButton)) {
			Log.log.info("Add to Cart button is present");
			isPresent = true;
		} else {

			Log.log.info("Add To Cart button is not Present");
		}

		return isPresent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

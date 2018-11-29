package com.pagewiseFunctions;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.pagewiseLocators.LocatorsOfProductDetailsPage;

public class Cart {
	
	CommonActions commonActions = new CommonActions();
	
	/*This method is used to click on Add to Cart button from product details page*/
	
	public boolean clickonAddTocartButton() {
		
		boolean isclicked=false;
		
		if(commonActions.isElementPresent(LocatorsOfProductDetailsPage.addToCartButton)) {
			
			commonActions.myClick(LocatorsOfProductDetailsPage.addToCartButton);
			
			Log.log.info("Add To Cart button is Clicked");
			
			isclicked=true;
		}else
		{
			Log.log.info("Add To Cart button is not Clicked");
			
		}
		
		return isclicked;	
		
		
	}
	
	
	/*This method is used to verify that added item count displayed in mini cart*/
	
	public boolean verifyminicartnumber() {
		
		boolean isverified=false;
		
		
		if(commonActions.isElementPresent(LocatorsOfProductDetailsPage.addToCartButton)) {
			
		
		}	
		
		
		
		return isverified;
	}
	
	
	/*This method is used to verify that added item  displayed in mini cart*/
	
	public boolean verifyitemAddedInMiniCart() {
		
		boolean isverfied=false;
		
		if(commonActions.isElementPresent(LocatorsOfProductDetailsPage.minicartIcon)) {
			
			commonActions.myClick((LocatorsOfProductDetailsPage.minicartIcon));	
			
			Log.log.info("Click on mini cart icon");
			
			
			
		}
		
		
		return isverfied;
	}
	
	

}

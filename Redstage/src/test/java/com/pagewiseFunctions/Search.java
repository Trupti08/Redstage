package com.pagewiseFunctions;

import java.io.IOException;

import com.commonFunctions.CommonActions;
import com.log.Log;
import com.pagewiseLocators.LocatorofSignInPage;
import com.pagewiseLocators.LocatorsOfSearchPage;
import com.pagewiseLocators.LocatorsofRegistrationForm;

import net.bytebuddy.asm.Advice.Enter;
import testBase.ExcelRead;

public class Search {
	
	
	CommonActions commonAction = new CommonActions();
	
	
	
	
	
	public boolean clickonSearchBox() {
		
		boolean isClicked=false;
		
		
		try {
			
			if(commonAction.isElementPresent(LocatorsOfSearchPage.searchBox)) {
				
				commonAction.myClick(LocatorsOfSearchPage.searchBox);
				
				Log.log.info("Cursor is on Searchbox");
				
				isClicked=true;
			}
		}catch (Exception e) {
			
			Log.log.info("Searchbox is not visible");
			// TODO: handle exception
		}
		return isClicked;
		
		
	}
	
	/*Below method is used for Enter Product Name in serachBox*/
	
	public boolean enterProductInSearch() throws IOException {	
		
		boolean isEntered=true;;
		
		String productName = ExcelRead.getObject("productName");
		
		commonAction.sendKeysByInput(LocatorsOfSearchPage.searchBox, productName);
		
		Log.log.info("Product Name is Entered");
		
		return isEntered;
			
		
	}
	
	/*After entering product name directly click on search box Symbol*/

	public boolean clickonSearchIcon() throws IOException {
		boolean isClicked=false;
		enterProductInSearch();
		
		if(commonAction.isElementPresent(LocatorsOfSearchPage.serachIcon)) {
			
			commonAction.eClick(LocatorsOfSearchPage.serachIcon);
			Log.log.info("Click on Search Icon");
			isClicked=true;
			
		}
		return isClicked;
		
		}
	
	
	
	
	/*Below Method is used to Click on Enter button of Keyboard after*/
	
	public boolean pressEnterButton() {
		boolean isPress=false;
		if(commonAction.isElementPresent(LocatorsOfSearchPage.serachIcon)) {
		
		commonAction.eClick((LocatorsOfSearchPage.serachIcon));
		
		Log.log.info("Enter button is clicked");
		isPress=true;
		
		}
		
		return isPress;
		
		

	}
	
}

package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.SearchResultPage;


public class TC_ProductPageTest  extends BaseClass  {

	@Test(enabled=true)
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
		logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.clickSignIn();


		MyAccount pg = new MyAccount(driver);
		pg.enterEmail(emailAddress);
		logger.info("User Email and Password entered.");
		pg.enterPassword(password);

		pg.clickSignIn();
		
		logger.info("Sign In link clicked");

		//Enter searchkey in search box
		RegisteredUserAccount productPg = new RegisteredUserAccount(driver);
		
		productPg.EnterText(searchKey);
		productPg.Search();

		// Get Name of Searched Product
		SearchResultPage resultPg = new SearchResultPage(driver);

		String SearchResultProductname=resultPg.getSearchResultProductName();


		//Verify that correct Product is displaying after search

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);
			productPg.signOut();

		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureScreenshot(driver, "VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase Search Product ends*****************"); 

	}


	
}

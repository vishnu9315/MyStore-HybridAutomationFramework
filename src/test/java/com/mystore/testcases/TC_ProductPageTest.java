package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.SearchResultPage;


public class TC_ProductPageTest  extends BaseClass  {

	@Test(enabled=true, priority = 1)
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
	
	@Test(enabled = true, priority = 2)
	public void VerifyBuyProduct() throws IOException
	{

		logger.info("\n***************TestCase Buy Product started*****************"); 

		/*	driver.get(url);
		logger.info("Url opened");*/

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.clickSignIn();


		//Enter account details- email and password
		MyAccount pg = new MyAccount(driver);
		pg.enterEmail(emailAddress);

		logger.info("User Email and Password entered.");
		pg.enterPassword(password);

		pg.clickSignIn();
		logger.info("Sign In link clicked");

		RegisteredUserAccount prodCatPg = new RegisteredUserAccount(driver);
		prodCatPg.EnterText("T-shirts");
		logger.info("T-shirt entered in search box");

		prodCatPg.Search();
		logger.info("clicked on search button");

		SearchResultPage searchResultPg = new SearchResultPage(driver);
		searchResultPg.ClickOnMoreBtn();
		logger.info("Clicked on more button");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		ProductPage prodPg = new ProductPage(driver);
		prodPg.SelectSize("L");
		logger.info("size M entered");
		
		prodPg.setQuantity("2");
		logger.info("quantity 2 entereed");

		

//		prodPg.clickOnAddToCart();
//		logger.info("Clicked on add to cart");

		prodPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on product page");


		OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
		orderSumPg.cickOnProceedToCheckout(); 
		logger.info("Clicked on proceed to checkout on order summary page");

		OrderAddressPage orderAddPg = new OrderAddressPage(driver);
//		orderAddPg.EnterName("vishnu");
//		orderAddPg.LastName("kumar");
//		orderAddPg.EnterAddress("Address");
//		orderAddPg.EnterCity("Maharastra");
//		orderAddPg.SelectState("Arizona");
//		orderAddPg.EnterZip("74568");
//		orderAddPg.SelectCountry("United States");
//		orderAddPg.enterHomePhone("9851542665");
//		orderAddPg.enterPhone("9851542665");
//		orderAddPg.enterAlias("Blah Blah Blah");
//		orderAddPg.cickOnSaveBtn();
		orderAddPg.cickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order address page");

		OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
		orderShippingPg.selectTermsOfServices();
		logger.info("selecged term of service check box");

		orderShippingPg.cickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order shipping page");

		OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
		logger.info(orderPaymentPg.getPageTitle());

		orderPaymentPg.clickOnPayByCheque();
		logger.info("Clicked on pay by cheque");

		OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
		orderConfirmPg.cickOnConfirmOrder();

		logger.info("Clicked on confirmed order");

		String sucessMsg = orderConfirmPg.getOrderSucessMessage();

		//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

		if(sucessMsg.equals("Your order on My Shop is complete."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);
			orderConfirmPg.clickOnSignOut();

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenshot(driver,"VerifyBuyProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase BuyProduct ends*****************"); 

	}


	
}

package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.accountCreationDetails;

public class TC_MyAccountPageTest extends BaseClass {
	
	IndexPage page;
	
	@Test(enabled = false)
	public void verifyRegistrationAndLogin() {
		
		page = new IndexPage(driver);
		
		page.clickSignIn();
		logger.info("Clicked on Sign In button");
		MyAccount createAcc = new MyAccount(driver);
		createAcc.enterEmailAddress("vsp123@gmail.com");
		createAcc.clickSubmitButton();
		
		accountCreationDetails account = new accountCreationDetails(driver);
		account.selectGender();
		account.enterFirstName("raj");
		account.enterLastName("Mishra");
		account.enterEmail("kumar123@gmail.com");
		account.enterPassword("myPass@12");
		logger.info("Entered User Details");
		account.clickRegBtn();
		logger.info("Clicked on Register Button");
		
		RegisteredUserAccount reg = new RegisteredUserAccount(driver);
		String user = reg.verifyUserId();
		
		Assert.assertEquals("Raj Mishra", user);
		logger.info("Account verified..");
		
	}
	
	@Test(enabled = false)
	public void VerifyLogin() throws IOException {
		page = new IndexPage(driver);
		page.clickSignIn();
		logger.info("Clicked on Sign In button");
		MyAccount createAcc = new MyAccount(driver);
		createAcc.enterEmail("kumar123@gmail.com");
		createAcc.enterPassword("myPass@12");
		createAcc.clickSignIn();
		logger.info("Clicked on Sign In button..");
		RegisteredUserAccount reg = new RegisteredUserAccount(driver);
		String user = reg.verifyUserId();
		logger.info("Verifying User Id");
		if(user.equals("Raj Mishra")) {
			logger.info("VerifyLogin - Passed");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(true);
		}else {
			logger.info("VerifyLogin - Failed");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
		
		}
	
	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		IndexPage pg = new IndexPage(driver);

		pg.clickSignIn();
		logger.info("Clicked on sign in link");

		MyAccount myAcpg = new MyAccount(driver);

		myAcpg.enterEmail("kumar123@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("myPass@12");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");


		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		regUser.signOut();

		if(pg.getPageTitle().equals("Login - My Shop"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenshot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}

}

package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDriven extends BaseClass {
	
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
	
	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLogin(String userEmail, String userPwd, String userName) throws IOException {
		page = new IndexPage(driver);
		page.clickSignIn();
		logger.info("Clicked on Sign In button");
		MyAccount createAcc = new MyAccount(driver);
		createAcc.enterEmail(userEmail);
		createAcc.enterPassword(userPwd);
		createAcc.clickSignIn();
		logger.info("Clicked on Sign In button..");
		RegisteredUserAccount reg = new RegisteredUserAccount(driver);
		String user = reg.verifyUserId();
		logger.info("Verifying User Id");
		if(user.equals(userName)) {
			logger.info("VerifyLogin - Passed");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(true);
		}else {
			logger.info("VerifyLogin - Failed");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
		
		reg.signOut();
		
		}
	
	@DataProvider(name = "LoginDataProvider")
	
	public String[][] LoginDataProvider(){
		
		String fileName = System.getProperty("user.dir") + "\\mytestdata\\StoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}

package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
WebDriver ldriver;
	
	public RegisteredUserAccount(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@class = 'account']")
	WebElement verifyUserName;
	
	@FindBy(linkText =  "Sign out")
	WebElement signout;
	
	
	
	public String verifyUserId() {
		String userName = verifyUserName.getText();
		return userName;
	}
	
	public void signOut() {
		signout.click();
	}

}

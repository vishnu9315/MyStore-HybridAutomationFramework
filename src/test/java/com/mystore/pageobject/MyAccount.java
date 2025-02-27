package com.mystore.pageobject;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	//local and remote driver
	WebDriver ldriver;
	
	public MyAccount(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement Email;
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement submitCreate;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "passwd")
	WebElement passwd;
	
	
	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;
	
	
	
	
	
	public void enterEmailAddress(String email) {
		Email.sendKeys(email);
	}
	
	public void clickSubmitButton() {
		submitCreate.click();
	}
	
	public void enterEmail(String em) {
		email.clear();
		email.sendKeys(em);
	}
	
	public void enterPassword(String psw) {
		passwd.clear();
		passwd.sendKeys(psw);
	}
	
	public void clickSignIn() {
		SubmitLogin.click();
	}
}

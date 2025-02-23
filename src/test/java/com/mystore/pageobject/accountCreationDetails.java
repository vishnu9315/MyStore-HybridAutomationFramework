package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {
	
WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "id_gender1")
	WebElement gender;
	@FindBy(id = "customer_firstname")
	WebElement cust_f;
	@FindBy(id = "customer_lastname")
	WebElement cust_l;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "passwd")
	WebElement passwd;
	@FindBy(xpath = "//span[text() = 'Register']")
	WebElement regBtn;
	
	
	public void selectGender() {
		gender.click();
	}
	
	public void enterFirstName(String f_name) {
		cust_f.sendKeys(f_name);
	}
	public void enterLastName(String l_name) {
		cust_l.sendKeys(l_name);
	}
	public void enterEmail(String em) {
		email.clear();
		email.sendKeys(em);
	}
	public void enterPassword(String pass) {
		passwd.sendKeys(pass);
	}
	
	public void clickRegBtn() {
		regBtn.click();
	}
	
	
	

}

package com.mystore.pageobject;

import java.nio.channels.SelectableChannel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderAddressPage {

	WebDriver ldriver;

	//2. Create constructor
	public OrderAddressPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element

	}
	
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement id_state;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement id_country;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id = "alias")
	WebElement alias;

	//@FindBy(linkText = "Proceed to checkout")
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;
	
	@FindBy(id="submitAddress")
	WebElement submitAddress;
	
	@FindBy(name="processAddress")
	WebElement proceedfromAddressPage;
	
	public void cickOnSaveBtn()
	{
		submitAddress.click();
	}
	
	public void cickOnProceedToCheckout()
	{
		proceedfromAddressPage.click();
	}
	
	public void EnterName(String name) {
		firstname.clear();
		firstname.sendKeys(name);
	}

	public void LastName(String lname) {
		lastname.clear();
		lastname.sendKeys(lname);
	}

	public void EnterAddress(String addr) {
		address1.clear();
		address1.sendKeys(addr);
}
	
	public void EnterCity(String city1) {
		city.clear();
		city.sendKeys(city1);
} 
	public void SelectState(String st) {
		Select slSelect = new Select(id_state);
		slSelect.selectByVisibleText(st);
}
	
	public void EnterZip(String zip) {
		postcode.clear();
		postcode.sendKeys(zip);
} 
	
	public void SelectCountry(String cn) {
		Select slSelect = new Select(id_country);
		slSelect.selectByVisibleText(cn);
}
	public void enterHomePhone(String ph) {
		phone.clear();
		phone.sendKeys(ph);
} 
	public void enterPhone(String ph) {
		phone_mobile.clear();
		phone_mobile.sendKeys(ph);
} 
	public void enterAlias(String al) {
		alias.clear();
		alias.sendKeys(al);
} 
	
	
	
	
}

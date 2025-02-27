package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
	WebElement result;
	
	@FindBy(xpath = "//a[@title='View']")
	WebElement more;
	
	
	public String getSearchResultProductName() {
		
		return result.getText();
	}
	
	public void ClickOnMoreBtn() {
		more.click();
	}
	
	 

}

package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UserPage extends TestHelperUtility {
	public WebDriver driver;
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _addButton="//a[@class='btn btn-block btn-primary']";  
	@FindBy(xpath=_addButton)
	private WebElement addButton;
	private final String _searchField="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_searchField)
	private WebElement searchField;
	
	public String userPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}
	public AddUserPage clickOnAddUserButton()
	{
		page.clickOnElement(addButton);
		return new AddUserPage(driver);
	}
	public void enterSearch(String uname)
	{
		page.enterText(searchField,uname);
	}
	
}

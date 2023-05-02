package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class RolePage extends TestHelperUtility {
	public WebDriver driver;

	public RolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _addRolesButton="//div[@class='box-tools']//i[@class='fa fa-plus']";  
	@FindBy(xpath=_addRolesButton)
	private WebElement addRolesButton;
	public String rolesPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}
	public AddRolesPage clickOnaddRolesButton()
	{
		page.clickOnElement(addRolesButton);
		return new AddRolesPage(driver);
	}
}

package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility{
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _signOutButton="//a[text()='Sign Out']";
	@FindBy(xpath=_signOutButton)
	private WebElement signOutButton;
	private final String _signoutOption="//a[@class='dropdown-toggle']//span[text()='efg pqr']";  
	@FindBy(xpath=_signoutOption)
	private WebElement signoutOption;
	private final String _userSubTabOption="//span[@class='pull-right-container']";  
	@FindBy(xpath=_userSubTabOption)
	private WebElement userSubTabOption;
	private final String _usersTab="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a";  
	@FindBy(xpath=_usersTab)
	private WebElement usersTab;
	private final String _rolesSubTabOption="//span[@class='pull-right-container']";  
	@FindBy(xpath=_rolesSubTabOption)
	private WebElement rolesSubTabOption;
	private final String _rolesTab="/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a";  
	@FindBy(xpath=_rolesTab)
	private WebElement rolesTab;
	
	public String homePageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}
	
	
	
	public LoginPage clickOnSignOutButton()
	{
		page.clickOnElement(signOutButton);
		return new LoginPage(driver);
		
	}
	public void clickOnusersubtabs()
	{
		page.clickOnElement(userSubTabOption);
	}
	public void clickOnRolesSubTabs()
	{
		page.clickOnElement(rolesSubTabOption);
	}
	public UserPage clickOnUserTabs()
	{
		page.clickOnElement(usersTab);
		return new UserPage(driver);
	}
	public RolePage clickOnRoleTabs() {
		page.clickOnElement(rolesTab);
		return new RolePage(driver);
	}
	
	public void clickOnProfileButton() {
		page.clickOnElement(signoutOption);
	}
	


}
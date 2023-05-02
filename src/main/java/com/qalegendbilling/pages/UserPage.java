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
	private final String _editButton="//a[@class='btn btn-xs btn-primary']";  
	@FindBy(xpath=_editButton)
	private WebElement editButton;
	private final String _enterUsername="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_enterUsername)
	private WebElement enterUsername;
	private final String _updateButton="submit_user_button";  
	@FindBy(id=_updateButton)
	private WebElement updateButton;
	private final String _errorMessage="//td[@class='dataTables_empty']";  
	@FindBy(xpath=_errorMessage)
	private WebElement errorMessage;
	private final String _deleteButton="//button[@class='btn btn-xs btn-danger delete_user_button']";  
	@FindBy(xpath=_deleteButton)
	private WebElement deleteButton;
	private final String _deleteUsr="//input[@class='form-control input-sm']";  
	@FindBy(xpath=_deleteUsr)
	private WebElement deleteUsr;
	private final String _popupbutton="//button[text()='OK']";  
	@FindBy(xpath=_popupbutton)
	private WebElement popupbutton;
	private final String _viewbutton="//a[@class='btn btn-xs btn-info']";  
	@FindBy(xpath=_viewbutton)
	private WebElement viewbutton;
                                
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
	
	public EditUserPage clickOnEditUserButton()
	{
		page.clickOnElement(editButton);
		return new EditUserPage(driver);
	}
	public UserPage ClickOnUpdateButton()
	{
		page.clickOnElement(updateButton);
		return new UserPage(driver);
	}
	public void ClickOnDeleteButton()
	{
		page.clickOnElement(deleteButton);
		
	}
	public void ClickOnPopupButton()
	{
		page.clickOnElement(popupbutton);
		
	}
	public String getErrorMessage() {
		String errMessage=page.getElementText(errorMessage);
		return errMessage;
	}
	public void enterUserDelete(String delUsr) {
	page.enterText(deleteUsr, delUsr);
		
	}
	public void enterViewDetails(String viewUser) {
	    page.enterText(searchField, viewUser);
		
	}
	public ViewUserPage clickOnViewButton()
	{
		page.clickOnElement(viewbutton);
		return new ViewUserPage(driver);
	}
	
}

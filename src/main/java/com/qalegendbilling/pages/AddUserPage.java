package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddUserPage extends TestHelperUtility {
	public WebDriver driver;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _firstNameField="first_name";  
	@FindBy(id=_firstNameField)
	private WebElement firstNameField;
	private final String _emailField="email";  
	@FindBy(id=_emailField)
	private WebElement emailField;
	private final String _roleField="select2-role-container";  
	@FindBy(id=_roleField)
	private WebElement roleField;
	private final String _passwordField="password";  
	@FindBy(id=_passwordField)
	private WebElement passwordField;
	private final String _confirmPasswordField="confirm_password";  
	@FindBy(id=_confirmPasswordField)
	private WebElement confirmPasswordField;
	private final String _userNameField="username";  
	@FindBy(id=_userNameField)
	private WebElement userNameField;
	private final String _saveButton="submit_user_button";  
	@FindBy(id=_saveButton)
	private WebElement saveButton;

	public void enterFirstName(String fname)
	{
		page.enterText(firstNameField,fname);

	}
	public void enterEmail(String email)
	{
		page.enterText(emailField,email);

	}
	public void enterRole(String role)
	{
		page.enterText(roleField,role);

	}
	public void enterPassword(String pass)
	{
		page.enterText(passwordField,pass);

	}
	public void enterConfirmPassword(String cpass)
	{
		page.enterText(passwordField,cpass);

	}
	public void enterUserName(String uname)
	{
		page.enterText(userNameField,uname);

	}
	public void enterAddUserData(String fname ,String email,String role,String pass,String cpass,String uname)
	{
	page.enterText(firstNameField,fname);
	page.enterText(emailField,email);
	page.enterText(roleField,role);
	page.enterText(passwordField,pass);
	page.enterText(passwordField,cpass);
	page.enterText(userNameField,uname);
}
	public UserPage clickOnSaveButton()
	{
		page.clickOnElement(saveButton);
		return new UserPage(driver);
	}

}

package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _usernameField="username";
	@FindBy(id=_usernameField)
	private WebElement usernameField ;
	private final String _passwordField="password";
	@FindBy(id=_passwordField)
	private WebElement passwordField;
	private final String _loginButton="//button[@class='btn btn-primary']";
	@FindBy(xpath=_loginButton)
	private WebElement loginButton;
	private final String _remembermeCheckbox="//input[@type='checkbox']";
	@FindBy(xpath=_remembermeCheckbox)
	private WebElement remembermeCheckbox;
	private final String _forgotpswdMessage="//a[@class='btn btn-link']";
	@FindBy(xpath=_forgotpswdMessage)
	private WebElement forgotpswdMessage;
	private final String _endTour="//button[@class='btn btn-default btn-sm']";  
	@FindBy(xpath=_endTour)
	private WebElement endTour;
	private final String _errorMessage="//strong[text()='These credentials do not match our records.']";  
	@FindBy(xpath=_errorMessage)
	private WebElement errorMessage;
	
	

	public String loginPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}
	public boolean verifythecheckboxisunselected()
	{
		return page.verifyElementischecked(remembermeCheckbox);
	}
	public void enterUserName(String username)
	{
		page.enterText(usernameField,username);

	}
	public void enterPassword(String password)
	{
		page.enterText(passwordField,password);

	}
	public void enterEmail(String email)
	{
		page.enterText(endTour, email);
	}
	
	public HomePage clickOnLoginButton()
	{
		page.clickOnElement(loginButton);
		return new HomePage(driver);
		
	}
	public ResetPasswordPage clickOnforgotMessage()
	{
		page.clickOnElement(forgotpswdMessage);
		return new ResetPasswordPage(driver);
	}
	
	public void clickOnEndTourButton() {
		page.clickOnElement(endTour);
	}
	public String getErrorMessage() {
		String errMessage=page.getElementText(errorMessage);
		return errMessage;
	}
	
	}
	


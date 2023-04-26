package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ResetPasswordPage extends TestHelperUtility {
	public WebDriver driver;

	public ResetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _resetemailField="//input[@id='email']";
	@FindBy(xpath=_resetemailField)
	private WebElement resetemailField;
	private final String _resetButton="//button[@type='submit']";
	@FindBy(xpath=_resetButton)
	private WebElement resetButton;
	private final String _errorMessageReset="//span[@class='help-block']";
	@FindBy(xpath=_errorMessageReset)
	private WebElement errorMessageReset;
	private final String _resetEmail="email";  
	@FindBy(id=_resetEmail)
	private WebElement resetEmail;
	
	public ResetPasswordPage clickOnResetButton()
	{
		page.clickOnElement(resetButton);
		return new ResetPasswordPage(driver);
	}
	public String getErrorResetMessage() {
		String errMessage = page.getElementText(errorMessageReset);
		return errMessage;
	}
	public void enterEmail(String reEmail) {
		page.enterText(resetEmail,reEmail);
	}

}

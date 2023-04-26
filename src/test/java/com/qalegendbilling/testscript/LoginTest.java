package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPasswordPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class LoginTest extends Base {
	LoginPage login;
	HomePage home;
	ResetPasswordPage reset;
	@Test(priority = 1, enabled = true, description = "TC001 verify login page title",groups= {"Sanity"})
	public void TC001_verifyLoginPageTitle() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expectedLoginPageTitle = data.get(1).get(0);
		login= new LoginPage(driver);
		String actualLoginPageTitle = login.loginPageTitle();
		Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle, ErrorMessages.TITLE_FAILURE_MESSAGES);
	}
	@Test(priority=1, enabled=true,description="TC002 verify valid credentials",groups= {"Smoke"})
	public void TC002_verifyValidCredentials() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(1).get(1);
		String pwd=data.get(1).get(2);
		login=new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwd);
	    login.clickOnLoginButton();
	    login.clickOnEndTourButton();
	}
	@Test(priority=1, enabled=true,description="TC003 verify InInvalidUser credentials",dataProvider = "InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void TC003_verifyInValidUserCredentials(String emailId,String pass) {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expectedErrorMessage = data.get(1).get(3);
		login=new LoginPage(driver);
		login.enterUserName(emailId);
		login.enterPassword(pass);
		login.clickOnLoginButton();
		String actualErrorMessage = login.getErrorMessage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, ErrorMessages.LOGIN_FAILURE_MESSAGE);
	}
	@Test(priority=1, enabled=true,description="TC004 verify valid credentials",groups={"Regression"})
	public void TC004_verifyRemembermeCheckboxIsUnselected()
	{
		login=new LoginPage(driver);
		boolean actualResult=false;
		boolean expectedResult=login.verifythecheckboxisunselected();
		Assert.assertEquals(actualResult,expectedResult,ErrorMessages.REMEMBER_ME_CHECKBOX_MESSAGE);
	}
	@Test(priority=1, enabled=true,description="TC005 verify the reset password error in mailid",groups= {"Sanity"})
	public void TC005_verifyTheResetPasswordErrorInMailId()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetEmail");
		String expectedEmail = data.get(1).get(0);
		login=new LoginPage(driver);
		reset=login.clickOnforgotMessage();
		String resetEmail=RandomUtility.getRandomEmail();
		reset.enterEmail(resetEmail);
		reset.clickOnResetButton();
		String actualErrorMessage = reset.getErrorResetMessage();
		Assert.assertEquals( actualErrorMessage,expectedEmail, ErrorMessages.RESET_EMAIL_MESSAGE);
	}
	
	

}

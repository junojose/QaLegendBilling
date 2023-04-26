package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class HomeTest extends Base {
	LoginPage login;
	HomePage home;
	//ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	@Test(priority=1, enabled=true,description="TC005 verify the home page title",groups= {"Sanity"})
	public void TC006_verifyHomePageTitle()
	{
		//extentTest.get().assignCategory("Sanity");
		login= new LoginPage(driver);
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(1).get(1);
		String pwd=data.get(1).get(2);
		login=new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwd);
	    login.clickOnLoginButton();
	    //extentTest.get().log(Status.PASS,ExtentLogMessage.LOGIN_BUTTON_CLICKED);
	    login.clickOnEndTourButton();
		List<ArrayList<String>> dataHome = ExcelUtility.excelDataReader("HomePage");
		String expectedLoginPageTitle = dataHome.get(1).get(0);
		home=new HomePage(driver);
		String actualLoginPageTitle = home.homePageTitle();
		Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle, ErrorMessages.HOME_TITLE_FAILURE_MESSAGES);
	}
	
	@Test(priority=1, enabled=true,description="TC008 verify the functionality of logout button",groups= {"Regression"})
	public void TC008_verifyFunctionalityofLogoutButton()
	{
		login= new LoginPage(driver);
		home=new HomePage(driver);
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(1).get(1);
		String pwd=data.get(1).get(2);
		login=new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwd);
	    login.clickOnLoginButton();
	    login.clickOnEndTourButton();
		home.clickOnProfileButton();
	    home.clickOnSignOutButton();
		
		}
	@Test(priority=1, enabled=true,description="TC004 verify user mangement sub tabs",groups={"Smoke"})
	public void TC009_verifyTheUserManagementSubTabs()
	{
		login= new LoginPage(driver);
		home=new HomePage(driver);
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(1).get(1);
		String pwd=data.get(1).get(2);
		login=new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwd);
	    login.clickOnLoginButton();
	    login.clickOnEndTourButton();
	    home.clickOnusersubtabs();
		
	}
	
	
	

}

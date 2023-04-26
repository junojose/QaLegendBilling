package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class UserTest extends Base{
	LoginPage login;
	HomePage home;
	UserPage user;
	AddUserPage add;
	
	@Test(priority=1, enabled=true,description="TC010 user account page title")
	public void TC010_verifyTheUserAccountPageTitle()
	{
	login= new LoginPage(driver);
	List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
	String uname = data.get(1).get(1);
	String pwd=data.get(1).get(2);
	login.enterUserName(uname);
	login.enterPassword(pwd);
    home=login.clickOnLoginButton();
    login.clickOnEndTourButton();
    home.clickOnusersubtabs();
    user=new UserPage(driver);
    user=home.clickOnUserTabs();
    List<ArrayList<String>> dataTitle = ExcelUtility.excelDataReader("UserPage");
	String expectedTitle= dataTitle.get(1).get(0);
	String actualUserTitle=user.userPageTitle();
	Assert.assertEquals(expectedTitle, actualUserTitle, ErrorMessages.USER_TITLE_FAILURE_MESSAGES);
	}

	@Test(priority=1, enabled=true,description="TC011 verify user search with valid data")
	public void TC011_verifyUserSearchWithValidData()
	{
		login= new LoginPage(driver);
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(1).get(1);
		String pwd=data.get(1).get(2);
		login.enterUserName(uname);
		login.enterPassword(pwd);
	    home=login.clickOnLoginButton();
	    login.clickOnEndTourButton();
	    home.clickOnusersubtabs();
	    user=new UserPage(driver);
	    user=home.clickOnUserTabs();
	    user.clickOnAddUserButton();
	    List<ArrayList<String>> dataAdd = ExcelUtility.excelDataReader("AddUser");
		String firstName = dataAdd.get(1).get(0);
		String email = dataAdd.get(1).get(1);
		String roles = dataAdd.get(1).get(2);
		String password= dataAdd.get(1).get(3);
		String Confirmpassword= dataAdd.get(1).get(4);
		String userName= dataAdd.get(1).get(5);
	    add.enterAddUserData(firstName,email,roles,password,Confirmpassword,userName);
	    user=add.clickOnSaveButton();
	    user.enterSearch(userName);
	    
	}

}


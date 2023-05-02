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

public class AddUserTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage add;
	@Test(priority=1, enabled=true,description="TC015 verify the Add user title",groups= {"Sanity"})
	public void TC015_verifyAddUserPageTitle()
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
	    add=user.clickOnAddUserButton();
	    List<ArrayList<String>> dataTitle = ExcelUtility.excelDataReader("AddUserDetails");
		String expectedAddUserPageTitle = dataTitle.get(1).get(6);
		add=new AddUserPage(driver);
		String actualAddUserPageTitle = add.getAddUserPageTitle();
		Assert.assertEquals(expectedAddUserPageTitle, actualAddUserPageTitle,ErrorMessages.ADD_USER_TITLE_FAILURE_MESSAGES);
	    
	}
	
	@Test(priority=1, enabled=true,description="TC005 verify add user details ",groups= {"Sanity"})
	public void TC016_verifyAddUserDetails() {
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
	   add= user.clickOnAddUserButton();
	    List<ArrayList<String>> dataAddUser = ExcelUtility.excelDataReader("AddUserDetails");
	    String firstName = dataAddUser.get(1).get(0);
		String email = dataAddUser.get(1).get(1);
		//String roles = dataAddUser.get(1).get(2);
		String password= dataAddUser.get(1).get(3);
		String confirmpassword= dataAddUser.get(1).get(4);
		String userName= dataAddUser.get(1).get(5);
		add.enterFirstName(firstName);
		add.enterEmail(email);
		//add.enterRole(roles);
		add.enterPassword(password);
		add.enterConfirmPassword(confirmpassword);
		add.enterUserName(userName);
		user=add.clickOnSaveButton();
	}
	
	
}



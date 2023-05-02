package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class EditUserTest extends Base {
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage add;
	EditUserPage edit;
	@Test(priority=1, enabled=true,description="TC017 verify the edit user page title",groups= {"Sanity"})
	public void TC017_verifyEditUserPageTitle() throws InterruptedException
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
	    List<ArrayList<String>> dataEdit = ExcelUtility.excelDataReader("EditUser");
		String editUser = dataEdit.get(1).get(1);
		user.enterSearch(editUser);
		Thread.sleep(2000);
		edit=user.clickOnEditUserButton();
		List<ArrayList<String>> dataEditUser= ExcelUtility.excelDataReader("EditUser");
		String expectedEditUserPageTitle = dataEditUser.get(1).get(0);
		edit=new EditUserPage(driver);
		String actualEditUserPageTitle = edit.getEditUserPageTitle();
		Assert.assertEquals(expectedEditUserPageTitle, actualEditUserPageTitle,ErrorMessages.EDIT_USER_TITLE_FAILURE_MESSAGES);
	    
		}
	@Test(priority=1, enabled=true,description="TC017 verify the edit user details",groups= {"Sanity"})
	public void TC018_verifyUserEditDetails() throws InterruptedException
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
	    List<ArrayList<String>> dataEdit = ExcelUtility.excelDataReader("EditUser");
		String editUser = dataEdit.get(1).get(1);
		user.enterSearch(editUser);
		Thread.sleep(2000);
		edit=user.clickOnEditUserButton();
		edit=new EditUserPage(driver);
		List<ArrayList<String>> dataEditUser= ExcelUtility.excelDataReader("EditUser");
		String lastName = dataEditUser.get(1).get(2);
		edit.enterEditLastName(lastName);
		user=edit.ClickOnUpdateButton();
		
		
	}

}

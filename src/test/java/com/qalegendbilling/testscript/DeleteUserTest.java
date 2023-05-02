package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class DeleteUserTest  extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage add;
	EditUserPage edit;
	
	@Test(priority=1, enabled=true,description="TC017 verify the user can delete user",groups= {"Sanity"})
	public void TC019_verifyTheUserCanDeleteUser() throws InterruptedException
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
	    List<ArrayList<String>> dataDelete = ExcelUtility.excelDataReader("DeleteUser");
		String deleteUser = dataDelete.get(1).get(0);
		user.enterUserDelete(deleteUser);
		Thread.sleep(3000);
		user.ClickOnDeleteButton();
		user.ClickOnPopupButton();
		
	}

}

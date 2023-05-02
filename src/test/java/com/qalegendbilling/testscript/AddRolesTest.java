package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolePage;
import com.qalegendbilling.utilities.ExcelUtility;

public class AddRolesTest extends Base {
	
	HomePage home;
	LoginPage login;
	RolePage roles;
	AddRolesPage addrole;
	
	@Test(priority=1, enabled=true,description="TC022 verify add roles page title",groups= {"Sanity"})
	public void TC022_verifyAddRolesPageTitle() throws InterruptedException
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
    roles=new RolePage(driver);
    Thread.sleep(3000);
    roles=home.clickOnRoleTabs();
    addrole=roles.clickOnaddRolesButton();
    List<ArrayList<String>> dataTitle = ExcelUtility.excelDataReader("RolesPage");
	String expectedTitle= dataTitle.get(1).get(1);
	String actualRolesTitle=addrole.addRolesPageTitle();
	Assert.assertEquals(expectedTitle, actualRolesTitle, ErrorMessages.ADD_ROLES_TITLE_FAILURE_MESSAGES);
	}
}



package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class RolePage extends TestHelperUtility {
	public WebDriver driver;

	public RolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String rolesPageTitle() {
		String title = page.getPageTitle(driver);
		return title;
	}
}

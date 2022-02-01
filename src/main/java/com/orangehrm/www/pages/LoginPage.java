package com.orangehrm.www.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.www.Base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "txtUsername")
	WebElement userName;
	@FindBy(id = "txtPassword")
	WebElement password;
	@FindBy(id = "btnLogin")
	WebElement loginButton;

	public void enterUsername() {
		userName.sendKeys("Admin");
	}

	public void enterPassword() {
		password.sendKeys("admin123");
	}

	public DashboardPage clickLoginBtn() {
		enterUsername();
		enterPassword();
		loginButton.click();
		return new DashboardPage();
	}

}

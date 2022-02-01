package com.orangehrm.www.gurvir;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.www.Base.TestBase;
import com.orangehrm.www.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage lp;

	@BeforeMethod
	public void intialise() {
		setUp();
		lp = new LoginPage();
	}

	@Test
	public void verifyUserCanLoginTest() {

		lp.enterUsername();
		lp.enterPassword();
		lp.clickLoginBtn();
		Assert.assertEquals(wd.getTitle(), "OrangeHRM");

	}

	@AfterMethod
	public void quitDriver() {
		tearDown();
	}

}

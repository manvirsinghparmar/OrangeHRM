package com.orangehrm.www.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.www.Base.TestBase;

public class DashboardPage extends TestBase {

	public DashboardPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "menu_buzz_viewBuzz")
	WebElement buzzBtn;

	public BuzzPage clickBuzzBtn() {
		buzzBtn.click();
		return new BuzzPage();
	}
}

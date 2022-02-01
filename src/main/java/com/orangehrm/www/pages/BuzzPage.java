package com.orangehrm.www.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.www.Base.TestBase;

public class BuzzPage extends TestBase {

	public BuzzPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "createPost_content")
	WebElement postField;
	@FindBy(id = "postSubmitBtn")
	WebElement postButton;
	@FindBy(id = "postContent_15")
	WebElement textPosted;

	public void inputPost(String postText) {
		postField.sendKeys(postText);
	}

	public void clickPostBtn() {
		postButton.click();
	}

	public String getPostedText() {

		return textPosted.getText();
	}

}

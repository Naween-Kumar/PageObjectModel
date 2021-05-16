package com.hrm.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "txtUsername")
	WebElement Username;

	@FindBy(name = "txtPassword")
	WebElement Password;

	@FindBy(name = "Submit")
	WebElement btnLogin;

	
	// Initializtion of all objects
	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);

	}
	
	
	public String validationLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		btnLogin.click();
		
		return new HomePage();
	}

}

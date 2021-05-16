package com.hrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	
	public LoginPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		
		 loginpage = new LoginPage();
		
	}
	
	@Test
	public void titlevalidation() {
		
		String title = loginpage.validationLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}

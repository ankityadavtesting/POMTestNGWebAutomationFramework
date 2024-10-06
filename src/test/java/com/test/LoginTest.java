package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.driver.DriverFactory;
import com.pages.LoginPage;
import com.property.TestDataLoader;

public class LoginTest extends BaseTest {

	@Test
	public void loginWithValidUserNameAndValidPassword() {

		LoginPage loginPage = new LoginPage();

		loginPage.loginToApplication(TestDataLoader.getInstance().getUserName(),
				TestDataLoader.getInstance().getPassword());

	}

}

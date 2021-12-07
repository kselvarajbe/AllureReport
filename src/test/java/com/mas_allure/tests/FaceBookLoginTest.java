package com.mas_allure.tests;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mas_allure.factory.PageinstancesFactory;
import com.mas_allure.pages.FacebookLoginPage;
import com.mas_allure.util.TestProperties;
import com.mongodb.diagnostics.logging.Logger;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * The Class FaceBookLoginTest.
 *
 */
@Test(testName = "Facebook login test", description = "Facebook login test")
@Epic("Regression Tests")
@Feature("FB Login Tests")
public class FaceBookLoginTest extends BaseTest {

	@Test(groups = {"Regression"}, priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
	public void facebookLoginTest() {
		
		driver.get("https://www.facebook.com/");
		FacebookLoginPage facebookLoginPage = PageinstancesFactory.getInstance(FacebookLoginPage.class);
		facebookLoginPage.enterEmail("selvaraj").enterPassword("Password@741").clickSignIn();
		Assert.assertTrue(false, "Login failed : Test failed");
		Allure.addAttachment("FB Login Failed", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
}

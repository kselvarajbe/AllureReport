package com.mas_allure.tests;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mas_allure.factory.PageinstancesFactory;
import com.mas_allure.listeners.LogListener;
import com.mas_allure.pages.GooglePage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * The Class GoogleSearchTest.
 *
 */
@Test(testName = "Google search test", description = "Test description")
@Epic("Regression Tests")
@Feature("Google search Tests")
public class GoogleSearchTest extends BaseTest {

	/**
	 * Google search test.
	 */
	@Test(groups = {"Sanity"}, priority = 1, description = "Google search test")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Google search test.")
    @Story("Google search test {0}")
	public void googleSearchTest() {
		driver.get("https://www.google.co.in/");
		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		googlePage.searchText("Monetary Authority of singapore");
		Assert.assertTrue(driver.getTitle().contains("Monetary"), "Title doesn't contain 'Monetary' : Test Failed");
		Allure.addAttachment("Search results", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
}

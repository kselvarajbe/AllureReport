package com.mas_allure.tests;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mas_allure.factory.PageinstancesFactory;
import com.mas_allure.pages.GooglePage;
import com.mas_allure.util.TestProperties;

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
@Test(testName = "Google search test without page", description = "Test description")
@Epic("Regression Tests")
@Feature("Google search Tests without page")
public class GoogleSearchTest_withoutPage extends BaseTest {

	/**
	 * Google search test.
	 */
	@Test(priority = 1, groups= {"Regression"},description = "Google search test without page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Google search test without page.")
    @Story("Google search test {0}")
	public void googleSearchTest() {
		String app_URL = TestProperties.getProperty("url");
		driver.get(app_URL);
		//driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Monetary Authority of singapore");
		//Allure.addAttachment("Google search results", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
		Assert.assertTrue(driver.getTitle().contains("Monetary"), "Title doesn't contain 'Monetary' : Test Failed");
		//Allure.addAttachment("Search results", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
}

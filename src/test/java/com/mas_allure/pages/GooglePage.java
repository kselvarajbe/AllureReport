package com.mas_allure.pages;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

/**
 * The Class represents GooglePage.
 *
 */
public class GooglePage extends BasePage {
	
	/** The searchinput. */
	@FindBy(name = "q")
	private WebElement searchinput;

	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public GooglePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	@Step("Enter search Text {0}")
	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
		//Allure.addAttachment("Google search results", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}

}

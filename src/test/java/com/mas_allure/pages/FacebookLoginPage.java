package com.mas_allure.pages;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

/**
 * The Class represents FacebookLoginPage.
 *
 */
public class FacebookLoginPage extends BasePage {

	/** The email input. */
	@FindBy(id = "email")
	private WebElement emailInput;

	/** The pass. */
	@FindBy(id = "pass")
	private WebElement pass;

	/**
	 * Instantiates a new facebook login page.
	 *
	 * @param driver the driver
	 */
	public FacebookLoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter email.
	 *
	 * @param email the email
	 * @return the facebook login page
	 */
	@Step("Enter Username {0}")
	public FacebookLoginPage enterEmail(String email) {
		emailInput.sendKeys(email);
		//Allure.addAttachment("Entered Username", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		return this;
	}

	/**
	 * Enter password.
	 *
	 * @param password the password
	 * @return the facebook login page
	 */
	@Step("Enter Password {0}")
	public FacebookLoginPage enterPassword(String password) {
		pass.sendKeys(password);
		//Allure.addAttachment("Entered Password", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		return this;
	}

	/**
	 * Click sign in.
	 */
	@Step("Click SignIn button")
	public void clickSignIn() {
		pass.submit();
	}
}

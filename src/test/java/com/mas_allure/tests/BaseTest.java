package com.mas_allure.tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.mas_allure.context.WebDriverContext;
import com.mas_allure.listeners.LogListener;
import com.mas_allure.listeners.ReportListener;
import com.mas_allure.util.LoggerUtil;
import com.mas_allure.util.MailUtil;
import com.mas_allure.util.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Every test class should extend this calss.
 *
 */
@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.log("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * Wrap all up.
	 *
	 * @param context the context
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		boolean mailSent = MailUtil.sendMail(total, passed, failed, skipped);
		LoggerUtil.log("Mail sent : " + mailSent);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}
	
	@AfterSuite
	public static void generateAllureReport() {
	    String pattern = "dd-MM-yyyy_HH:mm:ss";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	    String reportfolder = "allure-report_" + simpleDateFormat.format(new Date());
	    executeShellCmd("allure generate allure-results");
	    executeShellCmd("mv allure-report " + reportfolder);
	    executeShellCmd("cp -R src/main/resources/config/allure-2.16.1 "+reportfolder);
	    //executeShellCmd("cp src/main/resources/config/open_report_mac.sh "+reportfolder);
	    executeShellCmd("cp src/main/resources/config/open_report_windows.bat "+reportfolder);
	}

	public static void executeShellCmd(String shellCmd) {
	    try {
	        Process process = Runtime.getRuntime().exec(shellCmd);
	        process.waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error in Executing the command " + shellCmd);
	    }
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {
//		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
	}

	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}

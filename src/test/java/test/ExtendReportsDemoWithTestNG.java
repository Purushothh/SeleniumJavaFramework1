package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	private static WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();

	}

	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://www.google.com/");

		test.log(Status.INFO, "This step shows usage of log(status, details)");

		test.info("This step shows usage of info(details)");

		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void teardown() {
		extent.flush();
	}

}

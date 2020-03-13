package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google search test one", "Svalidate google search functionlaity");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		test1.pass("navigation to google");

		driver.findElement(By.name("q")).sendKeys("automation Step by step");
		test1.pass("enter text in search bar");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressed search key");

		test1.info("test completed!");

		extent.flush();

	}

}

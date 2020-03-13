package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

class Demo {
	public String getText(String string) {
		return null;
	}
}

public class DecyphaMarketStatus {

	public static void main(String[] args) {
		DecyphaMarketStatus obj = new DecyphaMarketStatus();

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport2.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test1 = extent.createTest("Decypha Merket Status comparition",
				"validate Merket Status comparition functionlaity");

		test1.pass("Going to Market Status");
		obj.setUpTest();
		test1.pass("Check Market Change Success");
		System.out.println("");
		obj.valueCompare();
		test1.pass("Check Market Change Sucsess");
		System.out.println("");
		obj.changeCompare();
		test1.pass("Check Percentage Change Success");
		System.out.println("");
		obj.percentageChangeCompare();
		test1.info("Test completed!");
		extent.flush();
	}

	WebDriver driver = null;

	static Demo selenium1 = new Demo();
	static Demo selenium2 = new Demo();
	static Demo selenium3 = new Demo();

	String exchangesArray[] = { "ADX", "ASE", "BSE", "LBBSE", "BK", "CSE", "DFM", "EGX", "ISX", "LSM", "MSM",
			"NasdaqDubai", "PEX", "QE", "TDWL", "TNTSE" };

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 0)
	public void valueCompare() {

		for (String symbol : exchangesArray) {

			driver.get("https://www.decypha.com/en/stock-market/public/" + symbol);

			driver.manage().window().maximize();

			String value1 = selenium1.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]");
			String value2 = selenium2.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]");
			String value3 = selenium3.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/table[1]/tbody[1]/tr[4]/td[3]");

			if ((value1 == value2) && (value2 == value3) && (value1 == value3)) {
				System.out.println(symbol + " MarketStats values are same!");
//				System.out.println(value1);
			} else {
				System.out.println(symbol + " Values are not same");
			}
		}

	}

	@Test(priority = 1)
	public void changeCompare() {

		for (String symbol : exchangesArray) {

			String value1 = selenium1.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/span[2]");
			String value2 = selenium2.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/span[1]");
			String value3 = selenium3.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/table[1]/tbody[1]/tr[4]/td[5]/span[1]");

			if ((value1 == value2) && (value2 == value3) && (value1 == value3)) {
				System.out.println(symbol + " Change values are same!");
			} else {
				System.out.println(symbol + " Change values are not same");
			}

		}
	}

	@Test(priority = 2)
	public void percentageChangeCompare() {
		for (String symbol : exchangesArray) {

			String value1 = selenium1.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/span[1]");
			String value2 = selenium2.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]");
			String value3 = selenium3.getText(
					"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/table[1]/tbody[1]/tr[4]/td[4]/span[1]");

			if ((value1 == value2) && (value2 == value3) && (value1 == value3)) {
				System.out.println(symbol + " Percentage change values are same!");
			} else {
				System.out.println(symbol + " Percentage change values are not same");
			}

		}
	}

	@AfterTest
	public void tearDownTest() {
		System.out.println("Test Successful!");

	}

}

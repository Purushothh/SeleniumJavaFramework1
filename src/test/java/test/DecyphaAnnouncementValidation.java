package test;

import java.time.MonthDay;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DecyphaAnnouncementValidation {

	public static void main(String[] args) {

		DecyphaAnnouncementValidation obj = new DecyphaAnnouncementValidation();
		obj.setUpTest();
		obj.AnnouncementValidate();
	}

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 0)
	public void AnnouncementValidate() {

		driver.get("https://www.decypha.com/en/market-announcement/public/adx");

		driver.manage().window().maximize();

		WebElement a = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]"));

		ZoneId websiteTimeZone = ZoneId.of("Asia/Colombo");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM HH:mm", Locale.ENGLISH);

		String stringFromWebsite = "02-Mar 18:03";

		MonthDay today = MonthDay.now(websiteTimeZone);
		MonthDay date = MonthDay.parse(stringFromWebsite, formatter);
		if (date.equals(today)) {
			System.out.println("It’s up to date");
		} else {
			System.out.println("It’s not up to date");
		}

	}

	@AfterTest
	public void tearDownTest() {
		System.out.println("Test Successful!");

	}
}

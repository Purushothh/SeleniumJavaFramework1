package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo {

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test(priority = 0)
	public void googleSearch() {

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("automation Step by step");
//		driver.findElement(By.className("btnK")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

//		

	}

	@AfterTest
	public void tearDownTest() {
		System.out.println("Test Successful!");

	}

}

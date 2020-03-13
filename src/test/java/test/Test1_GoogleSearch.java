package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		googleSearch();
	}

	public static void googleSearch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

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
		System.out.println("Test Successful!");

	}

}

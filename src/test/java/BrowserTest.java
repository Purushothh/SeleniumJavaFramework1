import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	public static void main(String[] args) {

//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Projectpath" + projectPath);

//		System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\geckodriver\\geckodriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\purushotha\\eclipse-workspace\\SeleniumJavaFramework1\\drivers\\chromedriver\\chromedriver.exe");

//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.decypha.com/");

		driver.findElement(By.xpath("//input[@id='searchtxt']")).sendKeys("abcd");

//		List<WebElement> listOfInputElemetns = driver.findElements(By.xpath("//input"));
//
//		int count = listOfInputElemetns.size();
//
//		System.out.println(count);

//		WebElement textBox = driver.findElement(By.id("searchtxt"));
//
//		textBox.sendKeys("1010");

	}

}

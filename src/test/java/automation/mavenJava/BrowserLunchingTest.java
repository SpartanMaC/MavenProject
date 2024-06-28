package automation.mavenJava;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class BrowserLunchingTest {

	static WebDriver driver;

	@BeforeClass
	@Parameters("browserName")
	void lunchingBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications");
			driver = new ChromeDriver(op);
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

	}
	
	@Test
	void verifyingTitleOfPage() {
		System.out.println("**** " + driver.getTitle() + " ****");
	}
	
	@AfterTest
	void closingBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
}

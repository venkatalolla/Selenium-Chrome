package seleniumtest.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest {

	private WebDriver driver;
	String appURL = "http://tasks-tasks-dev.oseapps.levvel-labs.io/";

	@BeforeClass
	public void testSetUp() {
		String chromePath = "/var/lib/jenkins/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
	}

	@Test
	public void verifyOpenShiftTasksPageTittle() {
		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "OpenShift Demo Tasks");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

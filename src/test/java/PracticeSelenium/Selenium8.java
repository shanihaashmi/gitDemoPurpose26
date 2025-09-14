package PracticeSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium8 {

	public static void main(String[] args) {
		// getWindowHandles and getWindowHandle
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Click Here")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			System.out.println(win);
			System.out.println(driver.getTitle());
		}

	}

}

package PracticeSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium9 {

	public static void main(String[] args) {
		WebDriver  driver = new ChromeDriver();
		
		//implicitlyWait:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//explicitly wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("hello")));
		
		//Fluent wait
		//Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(exception.class));
	//desired capabilities:
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless");
		opt.addArguments("--incognito");
		opt.addArguments("--disable-notifications");
		
		FirefoxOptions fopt = new FirefoxOptions();
		fopt.setAcceptInsecureCerts(false);
		
	}

}

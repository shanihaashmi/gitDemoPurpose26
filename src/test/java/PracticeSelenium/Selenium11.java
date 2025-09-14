package PracticeSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium11 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		// Get Attribute of webelement
		WebElement element = driver.findElement(By.linkText("Checkboxes"));
		String att = element.getAttribute("href");
		System.out.println(att);

		// check whether a text is underlined or not
		driver.get("https://unogeeks.com/selenium-easy-test/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement underlinedElement = driver.findElement(By.linkText("UnoGeeks"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0]).getPropertyValue('text-decoration');", underlinedElement);
		if (text == "underline") {
			System.out.println("Text is underlined");
		} else {
			System.out.println("Text is not underlined");
		}

		// Hover mouse on element
		driver.navigate().to("https://the-internet.herokuapp.com/");
		Actions actions = new Actions(driver);
		WebElement element1 = driver.findElement(By.linkText("Hovers"));
		element1.click();
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		actions.moveToElement(element2).perform();
		WebElement element3 = driver.findElement(By.tagName("h5"));
		if (element3.isDisplayed()) {
			System.out.println("it works as expected");
		} else {
			System.out.println("check the code");
		}

		// GetOptions Method
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element4 = driver.findElement(By.linkText("Dropdown"));
		element4.click();
		WebElement element5 = driver.findElement(By.id("dropdown"));
		Select select = new Select(element5);
		List<WebElement> options = select.getOptions();
		for (WebElement text1 : options) {
			System.out.println(text1.getText());
		}

		// DeselectAll method
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element6 = driver.findElement(By.linkText("Checkboxes"));
		element6.click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
		driver.quit();
	}

}

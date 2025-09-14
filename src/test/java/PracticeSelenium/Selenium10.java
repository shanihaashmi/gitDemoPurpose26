package PracticeSelenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium10 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://the-internet.herokuapp.com/");

		// getNumberOf Frames

		driver.findElement(By.linkText("Frames")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Nested Frames")).click();
		List<WebElement> element = driver.findElements(By.tagName("frame"));
		int frameCount = element.size();
		System.out.println(frameCount);
		for (WebElement frame : element) {
			driver.switchTo().frame(frame);
			List<WebElement> nestedFrames = driver.findElements(By.tagName("frame"));
			int totalFrameCount = nestedFrames.size();
			System.out.println(totalFrameCount);
			driver.switchTo().defaultContent();
		}

		// ScrollDown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Done");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("window.scrollBy(1000,0)");
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		System.out.println("Done by actions class");

		// Read data from excel
		String filepath = "C:\\Users\\Ashmi\\eclipse-workspace\\SeleniumJavaFrameWork\\seleniumData.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Welcome");
		String text = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(text);
		workbook.close();

		// Write a new excel
		filepath = "C:\\Users\\Ashmi\\eclipse-workspace\\SeleniumJavaFrameWork\\ReadData.xlsx";
		FileOutputStream fos = new FileOutputStream(filepath);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Hello");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Ashmi");
		workbook.write(fos);
		workbook.close();

		driver.quit();
	}

}

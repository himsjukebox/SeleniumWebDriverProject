package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement fileUpload = driver.findElement(By.id("uploadfile_0"));
		fileUpload.sendKeys("C:\\Users\\hm8\\Desktop\\Indian Flag.docx");
		
		WebElement tnc = driver.findElement(By.id("terms"));
		tnc.click();
		
		WebElement submit = driver.findElement(By.id("submitbutton"));
		submit.click();
		

	}

}

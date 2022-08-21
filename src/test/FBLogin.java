package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement userName = driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
		WebElement userPass = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));

//		Thread.sleep(5000);
		
		userName.sendKeys("himsjukebox@yahoo.co.in");
		userPass.sendKeys("Adresa1!");
		loginBtn.click();

		driver.close();
	}

}

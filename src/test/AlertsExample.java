package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement alertbtn1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
		alertbtn1.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(3000);
		WebElement alertbtn2 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		alertbtn2.click();
		Thread.sleep(3000);
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		Thread.sleep(3000);
		WebElement alertbtn3 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		alertbtn3.click();
		Thread.sleep(3000);
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Himanshu");
		alert.accept();
		
	}

}

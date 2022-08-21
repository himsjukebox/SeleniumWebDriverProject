package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsnTabsExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String parentWindow = driver.getWindowHandle();
		
		System.out.println("Before clicking tab button, the window is "+ parentWindow);
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		
		System.out.println("After clicking on tab button");
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows) {
			System.out.println(window);
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println(childHeader.getText());
		
		driver.close();
		driver.switchTo().window(parentWindow);
		
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		newWindow.click();
		
	}
	
}

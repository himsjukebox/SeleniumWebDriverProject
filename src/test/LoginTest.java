package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("anc@xyz.com");
		WebElement userpwd = driver.findElement(By.id("password"));
		userpwd.sendKeys("Test@1234");
		Thread.sleep(2000);
		WebElement rememberCheckbox = driver.findElement(By.className("rememberMe"));
		rememberCheckbox.click();
		
		WebElement loginButton = driver.findElement(By.name("btn_login"));
		loginButton.click();
		
		
		WebElement actMessage = driver.findElement(By.id("msg_box"));
		String expMessage = "The email or password you have entered is invalid.";
		if (actMessage.getText().equalsIgnoreCase(expMessage)) {
			System.out.println("Proper error message is shown");
		} else {
			System.out.println("Error is not shown which is not expected");
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (int i=0; i<links.size(); i++) {
		 System.out.println(links.get(i).getAttribute("href"));
		}
		System.out.println(links.size());
		
		
	}

}

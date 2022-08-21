package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class FBSignup {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement createAcc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		
		createAcc.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		firstName.sendKeys("Krishaan");
		
		WebElement surName = driver.findElement(By.xpath("//input[@name='lastname']"));
		surName.sendKeys("Maurya");
		
		WebElement mobileOrEmail = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));	
		mobileOrEmail.sendKeys("krishaan.maurya@gmail.com");
		
		WebElement reEntermobileOrEmail = driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']"));
		reEntermobileOrEmail.sendKeys("krishaan.maurya@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@aria-label='New password']"));
		password.sendKeys("mauryakrishaan");
		
		WebElement bdayDate = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select selDob = new Select(bdayDate);
		selDob.selectByValue("31");
		
		WebElement bdayMonth = driver.findElement(By.name("birthday_month"));
		Select selMonth = new Select(bdayMonth);
//		selMonth.selectByValue("Dec");
		selMonth.selectByIndex(11);
		
		WebElement bdayYear = driver.findElement(By.name("birthday_year"));
		Select selYear = new Select(bdayYear);
		selYear.selectByVisibleText("2015");
		
		WebElement maleCheckbox = driver.findElement(By.xpath("//label[text()='Male']"));
		maleCheckbox.click();
		
//		List<WebElement> Months = selMonth.getOptions();
//		
//		for(WebElement elm : Months) {
//			System.out.println(elm.getText());
//		}
		
		List<WebElement> allMonths = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		
		for (WebElement elm: allMonths) {
			System.out.println(elm.getText());
		}
		
		String Gender = "Custom";
		
//		WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
//		WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
//		WebElement Custom = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
//		
//		if(Gender.equals("Female")) {
//			Female.click();
//		}else if(Gender.equals("Male")) {
//			Male.click();
//		}else {
//			Custom.click();
//		}
		
//		WebElement GenderRadioBtn = driver.findElement(By.xpath("//label[text()='"+Gender+"']/following-sibling::input"));
//		GenderRadioBtn.click();
		
		String XPath = "//label[text()='PlaceHolder']/following-sibling::input";
		String newxpath = XPath.replace("PlaceHolder", Gender);
		WebElement GenderRadioBtn1 = driver.findElement(By.xpath(newxpath));
		GenderRadioBtn1.click();
		
		
		
		
		
	}

}

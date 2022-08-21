package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total numbers of rows in table is " +rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total number of columns in the table is "+columns.size());
		
//		Name on 3rd row and 1st column
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println("The required data is "+data.getText());
		
//		Print all names in the table
//		for(int row=1; row<=rows.size(); row++){
//			
//			for (int column=1; column<=columns.size();column++) {
//				WebElement data1 = driver.findElement(By.xpath("//table[@id='customers']//tr["+row+"]/*["+column+"]"));
//				System.out.print(data1.getText() + " | ");
//			}
//			System.out.println(" ");
//		}
		
		for(WebElement row: rows){
			
			List<WebElement> allCells = row.findElements(By.tagName("td"));
			List<WebElement> allHead = row.findElements(By.tagName("th"));
			for (WebElement cell: allHead) {
				
				System.out.print(cell.getText()+ " | ");
			}
			
			for (WebElement cell: allCells) {
				
				System.out.print(cell.getText()+ " | ");
			}
			System.out.println(" ");
			
		}
		
//	Based on Company variable; find out the country
		String company = "Magazzini Alimentari Riuniti";
		
		WebElement xPathComp = driver.findElement(By.xpath("//td[text()='"+ company +"']/following-sibling::td[2]"));
		System.out.println(""+company+ " is located in "+ xPathComp.getText());
	
	
	
	}

}

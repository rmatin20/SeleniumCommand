package dropdowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericFunctionWithSelectTag {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//launch url, passing parameters as String
		driver.get("https://www.facebook.com");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text() = 'Create New Account']")).click();
		System.out.println("lands on sign up page");
		Thread.sleep(2000);//had to use this wait as the test was failing
		
		WebElement selectMonth = driver.findElement(By.id("month"));
				
		WebElement selectDay = driver.findElement(By.id("day"));
				
		WebElement selectYear = driver.findElement(By.id("year"));
		
		selectFromDropDown(selectMonth,"Feb"); //call the static method from the main method
		selectFromDropDown(selectDay, "3");
		selectFromDropDown(selectYear, "2018");
		
		driver.quit();
	}
				
		public static void selectFromDropDown (WebElement element, String value ) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		}
	
}

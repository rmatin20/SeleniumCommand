package dropdowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WithSelectTag {

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
		//driver.switchTo().frame(0);
		
		WebElement month = driver.findElement(By.id("month")); //returns webelement
		WebElement day = driver.findElement(By.id("day"));
		WebElement year = driver.findElement(By.id("year"));
	
		//create object of Select class and pass the web element in it or write driver.findElementById....
		Select selectMonth = new Select(month);
		Select selectDay = new Select (day);
		Select selectYear = new Select (year);
		
		selectMonth.selectByValue("10");//when you expand HTML code, after options you'll see vale = "  "
		selectDay.selectByIndex(3);//index starts from 0. Not recommended 'cos if more values are added, index will change
		selectYear.selectByVisibleText("2007");//recommended to use as visible text doesn't change
		System.out.println("month, day and year were flled correctly");
		
		driver.quit();
		
		
	}

}

package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//launch url, passing parameters as String
		driver.get("https://classic.crmpro.com");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("landed on home page");
		
		//Contacts link is inside a frame, so we have to switch to frame first before mouse hover on Contacts
		driver.switchTo().frame("mainpanel");
		
		//create the object of Actions class so that you can mouse hover Contacts
		Actions mouseHover = new Actions(driver);
		WebElement contactsLink = driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]"));//returns webelement
		mouseHover.moveToElement(contactsLink).perform();
	//	Thread.sleep(2000);
		System.out.println("submenu visible now under Contacts");
		
		driver.close();

	}

}

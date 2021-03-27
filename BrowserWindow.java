package popUps;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindow {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//launches another browser with popup windows
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		//this method will get the id of the parent window, so store as String
		/*String webpage = driver.getWindowHandle();
		System.out.println(webpage);*/
		
		//click on Open New Tab
		driver.findElement(By.id("newTabBtn")).click();
			
		Thread.sleep(2000);
		
		/*getWindowHandles() will get the ids of ALL windows opened by the driver.*/
		Set<String> ids = driver.getWindowHandles(); // will return a Set of ids. Store as String
		System.out.println(ids.size());
		
		Iterator<String>it = ids.iterator();//
		String parentWindowID = it.next().toString();//returns the next element in the iteration which is the parent window. Store as String
		System.out.println(parentWindowID);
		
		String childWindowID = it.next().toString();//returns the next element in the iteration which is the child window
		System.out.println(childWindowID);
		
		driver.switchTo().window(childWindowID);//driver's focus is on parent window. So, switch to child window
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());//do some action on child window
		
		driver.close();//will close the child window. Don't use quite() as it will close all the windows that were opened.
		
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
		/*Unlike arrayList where objects are stored on the basis of index, and we get the values by using forloop, in SET, values are not stored in order, so we use Iterator.*/
		
		


	}

}

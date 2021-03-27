package javaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Click {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//launch url, passing parameters as String
		driver.get("https://www.facebook.com");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//js..executeScript(script, args);// no need to pass args. Script refers to driver.findElementBy(id).click(); in Selenium
		js.executeScript("document.getElementById('email').click()");
		
		System.out.println("test passed");
		
		driver.close();
	}
}
/*find the element in javascript and perform the action on the element in javascript
 * FindElement(Javascript) + Click(Javascript)
 * Copy from the developer console (ctrl+shift+j) and paste it on the script*/
 
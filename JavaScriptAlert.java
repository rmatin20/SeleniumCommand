package popUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlert {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//click the link for the popup to appear		
		driver.findElement(By.id("alertBox")).click();
		Thread.sleep(2000);
		
		//wait for the alert and store it 
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();// press OK. This is a simple alert
		
		driver.quit();
	}
}
/*JavaScript popups cannot be handled by locator as we cannot inspect elements. When the popup appears, the parent window becomes disabled, 
 * so we have to switch the focus from background screen to popup screen. This is achieved by Alert Interface. Use driver.switchTo().alert() method.
 * 4 ways to handle alert - 
 * alert.accept()        //press OK
 * alert.dismiss()       //cancel the popup
 * alert.sendKeys()      //write something
 * alert.getText()*/     //gets the text from the popup

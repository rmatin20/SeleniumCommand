package javaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TypeTextAndGetText {

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
		
		//2 ways text can be written
		js.executeScript("document.getElementById('email').value = 'Matt@gmail.com'");
		//js.executeScript("document.getElementById('email').setAttribute('value','Matt@gmail.com')");
		
		System.out.println("email typed");
		
		//to get the text from email box
		String text = (String) js.executeScript("return document.getElementById('email').value ");
		System.out.println(text); //prints the above email
		
		driver.close();
	}
}

/*Selenium has SendKeys () method to send any text in a text box. Sometimes, this command may not work. So, use JavaScriptExecutor.
 * Like Selenium, JSE has also methods to identify the unique property of an element, document.getElementById, ..
 * Insert the text that you want to write as value.
 * In developer console (ctrl shift j), you write line 25 and press enter, the email will be displayed on the webpage of Facebook*/
 //to retrieve a text, have to write return statement which will be stored as String.
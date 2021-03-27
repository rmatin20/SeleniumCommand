package javaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElement {

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
		
		//find the email textbox in JS and highlight in JS. 2 ways - highlight border only or highlight border and background
		//1. highlight border
		js.executeScript("document.getElementById('email').style.border = '2px solid yellow'");
		
		System.out.println("email border became yellow");
		
		//2. highlight the entire box
		js.executeScript("document.getElementById('email').style.background = 'green'");
		System.out.println("email textbox became green");
		
		driver.close();
	}
}
/*when you want to highlight, it refers to changing the style, that's why in the code it's style*/

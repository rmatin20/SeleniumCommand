package get;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GetAndNavigate {

	public static void main(String[] args) {
		
		//launch chrome and set path of chrome driver exe file (key-value pair)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();/*cannot create the object of WebDriver since it's an Interface. So, create the obj of the class implementing WD.
		 										driver is the name of the object not the object itself. new ChromeDriver() is the object. 
		//driver = new FirefoxDriver(); 		We create the driver as	reference variable so that the same driver can be used with other browsers, don't have to 
		 * 										create separate driver*/
		
		//launch url, passing parameters as String
		driver.get("https://www.google.com");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
				
		//get current url
		driver.getCurrentUrl();
		System.out.println("currentUrl test passed");
		
		//get title
		String title = driver.getTitle(); //this method returns a String, so store the value as String
		System.out.println(title);
		//Assert.assertTrue(title.contains("google")); //if there's no title, will return null String
		
		//getText - gets the innertext of the element
		String text = driver.findElement(By.xpath("//*[text()='Gmail']")).getText();
		System.out.println(text);
		if (text.equals("Gmail")) {
			System.out.println("test passed");
		}
		
		//getAttribute gets the attribute of a value
		String text1 = driver.findElement(By.xpath("//*[text()='Gmail']")).getAttribute("class");
		System.out.println(text1);
		
		//gets the entire HTML code in DOM
		String pgsource = driver.getPageSource();
		System.out.println(pgsource);
		
		//navigate methods
		driver.navigate().to("https://www.facebook.com"); //will go from google to facebook page
		driver.navigate().back(); //needs no parameters, will return to google.com, like the back arrow on a browser
		driver.navigate().refresh(); //will refresh google page
		driver.navigate().forward();//no parameters, will go forward by one page on the browser's history, like the forward arrow of a browser
		
		
		driver.close();


	}

}

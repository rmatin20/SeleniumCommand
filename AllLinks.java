package links;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinks {      //links have tag "a"

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rmati\\eclipse-workspace\\Feb202021\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//launch url, passing parameters as String
		driver.get("https://www.google.com");
		System.out.println("url test passed");
		
		//wait times & maximize window
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List<WebElement>allLinks = driver.findElements(By.tagName("a")); //findElements method will return a list of web elements
		
		//to get the total # of links
		System.out.println(allLinks.size());//prints 19
		
		//to get the text of all links, start a forloop since elements are stored on the basis of index, ordered elements
		for(int i = 0; i<allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getAttribute("href"));
		}
		driver.quit();
	}
	
	
	

}

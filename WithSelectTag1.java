package dropdowns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WithSelectTag1 {

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
		
		Select selectMonth = new Select (driver.findElement(By.id("month")));
		selectMonth.selectByVisibleText("Feb");//for visible text, it's string. Recommended as it never changes
		//ensure that October month is selected. getFirstSelectedOption method will return the month selected
		WebElement monthSelected = selectMonth.getFirstSelectedOption(); //returns the selected option as web element
		System.out.println(monthSelected.getText());//prints Feb
		
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByIndex(3); //not recommended. If more elements are added, then the index will shift
		//ensure that day 10 is selected. getFirstSelectedOption method will return the day selected
		WebElement daySelected = selectDay.getFirstSelectedOption();
		System.out.println(daySelected.getText());//prints 3
		
		Select selectYear = new Select(driver.findElement(By.id("year")));
		selectYear.selectByValue("2018"); //for value, it's String
		//ensure that 2019 is selected. getFirstSelectedOption method will return the year selected
		WebElement yearSelected = selectYear.getFirstSelectedOption();//returns the year selected as web element
		System.out.println(yearSelected.getText());//prints 2018
				
		//**********************************************//
		//total no. of months in dropdown list
		List<WebElement> totalNoMonth = selectMonth.getOptions();
		//System.out.println(totalNoMonth.size()); // will print 13 as 1st index month is also included.
		System.out.println(totalNoMonth.size()-1); //subtract 1, so it print 12
		
		driver.quit();
	}
}

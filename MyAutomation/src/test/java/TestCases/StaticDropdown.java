package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\AutomationI\\MyAutomation\\Drivers\\chromedriver.exe");
		
WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/login.html");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath(".//input[@id='passwd']")).sendKeys("asdfgh");
		driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
		driver.findElement(By.xpath("//div[@id='navbar-brand-centered']/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='navbar-brand-centered']/ul/li[1]/ul/li[2]/a")).click();
		
		System.out.println(driver.findElements(By.xpath(".//input[@type='radio']")).size());
		
		int sizeOfRad=driver.findElements(By.xpath(".//input[@type='radio']")).size();
		
	//	String attrb=driver.findElements(By.xpath(".//input[@type='radio']")).get(0).getAttribute("value");
	//	System.out.println("attribute is:- " +attrb);
		
	//	driver.findElements(By.xpath(".//input[@type='radio']")).get(0).click();
		
		for(int i=0;i< sizeOfRad;i++)
			{
				String names=driver.findElements(By.xpath(".//input[@type='radio']")).get(i).getAttribute("id");
			    System.out.println(names);
				
				if (names=="vfb-7-3")
				{
					driver.findElements(By.xpath(".//input[@type='radio']")).get(i).click();
					driver.findElements(By.xpath(".//input[@type='radio']")).get(i).getAttribute("value");
					
				}
				
			}
		
		
		
		
		

	}
}

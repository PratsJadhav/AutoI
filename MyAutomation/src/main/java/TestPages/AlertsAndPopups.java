package TestPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class AlertsAndPopups extends TestBase{
	Alert alert;
	
	@FindBy(xpath=".//input[@name='cusid']")
	WebElement cust_id_txt;
	
	@FindBy(xpath= ".//input[@name='submit']")
	WebElement submit_btn;
	
	@FindBy(xpath=".//*[contains(text(),'Click Here')]")
	WebElement click_here;
	
	@FindBy(xpath="//html/body/form/table/tbody/tr[5]/td[2]/input")
	WebElement email;
	
	@FindBy(xpath="//input[contains(@name,'btnLogin')]")
	WebElement submit;
	
	public AlertsAndPopups(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void alertAccept()
	{
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		cust_id_txt.sendKeys("1234");
		submit_btn.click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertDismiss()
	{
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		cust_id_txt.sendKeys("1234");
		submit_btn.click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	
	public void popupHandling() throws InterruptedException
	{
		driver.get("http://demo.guru99.com/popup.php");
		click_here.click();
		
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		
		while(iterator.hasNext())
		{
			String s = iterator.next();
			if(!parentWindow.equalsIgnoreCase(s))
			{
			driver.switchTo().window(s);
			if(driver.getTitle().equals("Guru99 Badfgnk Home Page"))
			{
			email.sendKeys("dfg@gmail.com");
	    	submit.click();
			driver.close();
			
					}
			}
		}
		
	
		driver.switchTo().window(parentWindow);
		
	}
	public void learnActions()
	{
		driver.get("https://www.facebook.com/");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("email"))).keyDown(Keys.SHIFT).sendKeys("ssd").keyUp(Keys.SHIFT);
		act.perform();
		
		act.clickAndHold().release();
		
	}
	
	public void openNewTab()
	{
		driver.get("https://www.guru99.com/");
		((JavascriptExecutor)driver).executeScript("window.open();");
		//driver.findElement(By.xpath(".//*[@id='java_technologies']/li[1]/a[contains(text(),'Software Testing')]")).sendKeys(Keys.CONTROL+"t");
	
	   Actions act = new Actions(driver);
	   act.moveToElement(driver.findElement(By.xpath(".//*[@id='java_technologies']/li[1]/a[contains(text(),'Software Testing')]"))).keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();

	   
	}
	
	public void scrolling()
	{
		driver.get("https://www.guru99.com/");
	//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500);");	
	//	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,500);");	
		WebElement ele = driver.findElement(By.xpath(".//*[@id='g-utility']/div/div/div/div/div/div/div/div/div/div[4]/div[1]/div/div/div/a/i"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ele);	
	}

	public void fileUpload() throws IOException
	{
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.xpath("//html/body/form/input[1]")).click();
		Runtime.getRuntime().exec("C:\\Users\\Akshay\\Documents\\b.exe");
	}
	
	public void findBrokenLink()
	{
		driver.get("http://www.zlti.com");
		String url ="";
		HttpURLConnection huc = null;
		int code = 200;
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> iterator = links.iterator();
		
		while(iterator.hasNext())
		{
			url = iterator.next().getAttribute("href");
			
			System.out.println(url);
			
			try
			{
				huc = (HttpURLConnection)(new URL(url).openConnection());
huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                code = huc.getResponseCode();
                
                if(code >=400)
                	System.out.println("brokeen....");
                else
                	System.out.println("valid....");
			}catch(Exception e)
			{
				
			}
		}
		
	}
}

package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;



public class TestBase {

	public static WebDriver driver;
	public static Properties Config = null;
	public File file;
	public FileInputStream fis;
    public static Logger log = null;
	
    
	public void init() throws IOException
	{
		log = Logger.getLogger("devpinoyLogger");
		loadPropertiesFile();
		selectBrowser(Config.getProperty("browser"));
		getURL(Config.getProperty("url"));
		
	}


	public void loadPropertiesFile() throws IOException 
	{
	  Config = new Properties();
	  fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\Config.properties");
	  Config.load(fis);
	  log.debug("properties file loaded successfully...");
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			log.debug("opening chrome browser...");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			log.debug("opening firefox browser...");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
    public void getURL(String url) 
    {
    	driver.manage().window().maximize();
		driver.get(url);
		log.debug("url opened = "+url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    
    public void highlightElement(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "border: 5px solid red;");
    }
    
    
}

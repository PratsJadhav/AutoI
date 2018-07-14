package TestPages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class GridProgram{
	static WebDriver driver;
	static String nodeUrl;
	 
	@Test()
	public void m1() throws MalformedURLException
	{
		 nodeUrl = "http://192.168.43.19:5555/wd/hub";
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 capabilities.setBrowserName("chrome");
		 capabilities.setPlatform(Platform.WINDOWS);
		 driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
		 
		 driver.get("https://www.edureka.co/");
		
	}

}

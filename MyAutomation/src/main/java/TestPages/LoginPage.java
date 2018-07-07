package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin_btn;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement username_txt;
	
	@FindBy(xpath =".//*[@id='passwd']")
	WebElement password_txt;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout_btn;
	
	public LoginPage(WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToOrangeHRM(String username, String password) throws InterruptedException
	{
		System.out.println("Entered login hrm method!");
						
		signin_btn.click();
		username_txt.sendKeys(username);
		password_txt.sendKeys(password);
		logout_btn.click();
	}
}

package TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.TestBase;

public class addNewUser extends TestBase{
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin_btn;
	
	@FindBy (xpath=".//*[@id='email_create']")
	WebElement input_email;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement create_btn;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement title;
	
	@FindBy(xpath="//*[@name='customer_firstname']")
	WebElement fname;
	
	@FindBy(xpath="//*[@name='customer_lastname']")
	WebElement lname;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement pass;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement years;
	
	@FindBy(xpath=".//*[@id='address1']")
	WebElement address;
	
	@FindBy(xpath=".//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath=".//*[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath=".//*[@id='postcode']")
	WebElement code;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	WebElement phone;
	
	@FindBy(xpath=".//*[@id='submitAccount']")
	WebElement register_btn;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout_btn;
	
	public addNewUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void registration()
	{
		signin_btn.click();
		input_email.sendKeys("53hd9dh3@gmail.com");
		create_btn.click();
		
		title.click();
		fname.sendKeys("PVJ");
		lname.sendKeys("PVJ");
		pass.sendKeys("12345");
		
		Select dropdown = new Select(days);
		dropdown.selectByValue("1");
		
		dropdown = new Select(months);
		dropdown.selectByIndex(3);
		
		dropdown = new Select(years);
		dropdown.selectByIndex(2);
		
		address.sendKeys("My Address");
		city.sendKeys("Pune");
		
		dropdown = new Select(state);
		dropdown.selectByIndex(3);
		
		code.sendKeys("33333");
		
		phone.sendKeys("333333333");
		
		register_btn.click();
		logout_btn.click();
	}

}

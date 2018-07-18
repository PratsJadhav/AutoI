package TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.LoginPage;
import TestPages.addNewUser;
import Utilities.ExcelReader;

//@Listeners(Utilities.Listener.class)

public class TestCase01 extends TestBase {

	LoginPage login_page;
	addNewUser add_new;
	ExcelReader excel;
	
/*	@DataProvider(name="loginData")
    public String[][] loginDataProvider() throws IOException
    {
		excel = new ExcelReader();
    	String [][] data = excel.getExcelData();
    	
		return data;
    	
    }
    
    */
	@Test(priority=1)
	public void initialize() throws IOException
	{
		init();
		System.out.println("test case 1 from maven");
	}
	
/*	@Test(priority =3, dataProvider ="loginData", dependsOnMethods ="register")
	public void login(String username, String password) throws InterruptedException
	{
		login_page = new LoginPage(driver);
		System.out.println("username = "+username);
		System.out.println("password = "+password);
		
		login_page.loginToOrangeHRM(username, password);
	}
	*/
	@Test(priority= 2)
	public void register()
	{
		add_new = new addNewUser(driver);
		add_new.registration();
	}
	
}

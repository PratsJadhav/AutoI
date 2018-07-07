package TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.LoginPage;
import Utilities.ExcelReader;

public class TestCase01 extends TestBase {

	LoginPage login_page;
	ExcelReader excel;
	
	@DataProvider(name="loginData")
    public String[][] loginDataProvider() throws IOException
    {
		excel = new ExcelReader();
    	String [][] data = excel.getExcelData();
    	
		return data;
    	
    }
	@BeforeTest
	public void initialize() throws IOException
	{
		init();
	}
	
	@Test(priority =1, dataProvider ="loginData")
	public void login(String username, String password) throws InterruptedException
	{
		login_page = new LoginPage(driver);
		System.out.println("username = "+username);
		System.out.println("password = "+password);
		
		login_page.loginToOrangeHRM(username, password);
	}
}

package TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.AlertsAndPopups;

public class TestCase02 extends TestBase{
	AlertsAndPopups obj;
	
	@Test
	public void initialization() throws IOException
	{
		init();
		int a = 333;
		double b = a;
	}

	@Test
	public void t() throws InterruptedException, IOException
	{
		obj = new AlertsAndPopups(driver);
		System.out.println("execution from maven");

	}
	
	@BeforeGroups
	public void as()
	{
		
	}
	
}

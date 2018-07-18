package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.TestBase;

public class TC03 extends TestBase{

	@Test
	public void m1() throws IOException
	{
		init();
		System.out.println("m1 method");
	}
	
	@Test
	public void m2()
	{
		System.out.println("m2 method");
	}
}

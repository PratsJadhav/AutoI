package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import TestBase.TestBase;

public class Listener extends TestBase implements ITestListener {

	Calendar calendar;
	SimpleDateFormat dateformat;
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("finished ...\n");
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Started...\n");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed ...\n");
		
		String filename = new SimpleDateFormat("dd_mm_yy_hh_mm_ss'.png'").format(new Date());
		String filepath = System.getProperty("user.dir")+"\\Screenshots\\failed"+filename;
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		
		if(!result.isSuccess())
		{
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Started Execution...\n");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Success!!! \n");
	
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		String filepath = System.getProperty("user.dir")+"\\Screenshots\\"+fileName;
		
		if(result.isSuccess())
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(filepath);
			try {
				System.out.println("for adding screenshots...");
				FileUtils.copyFile(srcFile,destFile);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
/*
		
		Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	
       	if(result.isSuccess())
    	{
    		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		
    		try
    		{
    			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\Screenshots\\";
            	File destFile = new File((String)reportDirectory +formater.format(calendar.getTime())+".png");
            	FileUtils.copyFile(scrFile, destFile);
                
            }catch(Exception e)
            {
            	e.printStackTrace();
            }
    		
    	}
	*/
	}
		
		
}

package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class BaseTest
{
	public static Map<String,Object>  testMap = new HashMap<String,Object>();

	@BeforeMethod
	public void getMethod()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName(), "inside method");
	}
	
	@BeforeMethod
	public void afterMethod()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName(), "extingi method");
	}

}

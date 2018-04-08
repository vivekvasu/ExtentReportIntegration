package pages;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentTestManager;

public class HomePage
{
	public void methodOne()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName(), "inside method");
	}
}

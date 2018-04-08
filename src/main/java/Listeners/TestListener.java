package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentManager;
import reports.ExtentTestManager;
import tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener 
{

	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext)
	{
		System.out.println("I am in onStart method " + iTestContext.getCurrentXmlTest().getName());
	}

	@Override
	public void onFinish(ITestContext iTestContext)
	{
		System.out.println("I am in onFinish method " + iTestContext.getName());
		ExtentTestManager.endTest();
		ExtentTestManager.getTest().log(LogStatus.INFO, iTestContext.getCurrentXmlTest().getName() ,"Test finished");
		ExtentManager.getReporter().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) 
	{
		System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName() ,iTestResult.getMethod().getDescription());
		ExtentTestManager.getTest().log(LogStatus.INFO, iTestResult.getMethod().getMethodName() ,"Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult)
	{
		System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
		ExtentTestManager.getTest().log(LogStatus.PASS, iTestResult.getName(), "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult)
	{
		System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

		//Get driver from BaseTest and assign to local webdriver variable.
		/*Object testClass = iTestResult.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getDriver();

		//Take base64Screenshot screenshot.
		String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
				getScreenshotAs(OutputType.BASE64);*/

		ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(iTestResult), "Test Failed");
		ExtentTestManager.getTest().log(LogStatus.ERROR, getTestMethodName(iTestResult), iTestResult.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult)
	{
		System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult)
	{
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}

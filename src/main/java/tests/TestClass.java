package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestClass extends HomePage
{
	@Test (description = "verify the test one")
	public void TestOne()
	{
		HomePage homePage = new HomePage();
		homePage.methodOne();
		Assert.assertTrue(1>2);
	}

	@Test (description = "verify the test two")
	public void TestTwo()
	{
		Assert.assertTrue(3 > 2);
	}

	@Test (description = "verify the test three")
	public void TestThree()
	{
		Assert.assertTrue(3 > 2);
	}



}

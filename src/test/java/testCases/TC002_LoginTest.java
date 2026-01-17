package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*******Starting TC_002_Login test*******");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Loginpage
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//Myaccount
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
	 
		Assert.assertTrue(targetpage);
		//Assert.assertEquals(targetpage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*******Finished TC_002_Login test*******");

	}
	
	
}

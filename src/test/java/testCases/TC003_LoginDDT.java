package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;





public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")// getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		
		logger.info("****** Starting TC_003_Login DDT****");
		
		try
		{
		//HomePage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//Loginpage
				Loginpage lp=new Loginpage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//Myaccount
				
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetpage=macc.isMyAccountPageExists();
		
		          /*DATA IS VALID  == Login success -- test pass -- logout
				 *DATA IS VALID  == login failed  -- test fail
				 *
				 * DATA IS INVALID  == Login success -- test fail  -- logout
				 * DATA IS INVALID == Login failed  -- test pass
						 */
				
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetpage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
						
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetpage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
						
					}
					else
					{
						Assert.assertTrue(true);

					}
				}
		}
				catch(Exception e)
				{
					Assert.fail();
				}
		Thread.sleep(3000);
		logger.info("****** Finished TC_003_Login DDT****");
	}
	
	
	
	
}

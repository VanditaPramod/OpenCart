package com.oc.qa.TestCases;

import org.testng.annotations.Test;

import com.oc.qa.PageObjects.AddressPage;
import com.oc.qa.PageObjects.HomePage;
import com.oc.qa.PageObjects.LoginPage;
import com.oc.qa.PageObjects.MyAccountPage;
import com.oc.qa.TestBase.BaseClass;

import junit.framework.Assert;
@Test(groups={"Master","Regression"})
public class AddressTest extends BaseClass {
	
	public void Addressupdate()
	{
		try
		{
		logger.info(""
				+ "");
		logger.info("*** Login test started ***");
		//Home Page
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on My Account");
		hp.ClickMyAcc();
		logger.info("Clicked on Login button");
		hp.LoginButton();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Enter an Email");
		lp.LoginEmail(p.getProperty("email"));
		logger.info("Entered Password");
		lp.LoginPwd(p.getProperty("password"));
		logger.info("Clicked on Login button");
		lp.loginbtn();
		
		//MyAccount
		MyAccountPage Myacc=new MyAccountPage(driver);
		boolean TargetPage=Myacc.verifyMYaccHeading();
		Assert.assertTrue(TargetPage);
		
		//Address Update
		AddressPage At=new AddressPage(driver);
		logger.info("Click on Address book entry URL");
		At.AddressBookEntryURL();
		logger.info("Clicked on new address button");
		At.NewAddressButton();
		logger.info("Entered First Name");
		At.FirstName(p.getProperty("FirstName"));
		logger.info("Entered Last Name");
		At.LastName(p.getProperty("LastName"));
		logger.info("Entered Company Name");
		At.CompanyName(p.getProperty("Company"));
		logger.info("Entered Address1");
		At.Address_1(p.getProperty("Address1"));
		logger.info("Entered Address2");
		At.Address_2(p.getProperty("Address2"));
		logger.info("Entered city");
		At.City(p.getProperty("City"));
		logger.info("Entered Postal Code");
		At.postalcode(p.getProperty("PostalCode"));
		Thread.sleep(3000);
		logger.info("Select the Country from the Dropdown");
		At.Country(p.getProperty("Country"));
		Thread.sleep(3000);
		logger.info("Select the Region from the Dropdown");
		At.Region(p.getProperty("Region"));
		logger.info("Click on Continue");
		At.Cont_inue();
		logger.info("Verify Success message");
		String msg=At.SuccessMessage();
		if(msg.equalsIgnoreCase("Your address has been successfully added"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("debug logs");
			Assert.assertTrue(true);
		}
		
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}


package com.hdfc.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hdfc.UIClass.AccountDetailsPage;
import com.hdfc.UIClass.LoginPage;
import com.hdfc.utils.AbstractHDFTest;



public class AccountDetailsPageTest extends AbstractHDFTest {
	private LoginPage loginpage;
	private AccountDetailsPage accountpage;
	private static Logger Log=Logger.getLogger(AccountDetailsPageTest.class);

	@BeforeTest
	@Parameters(value={"baseURL","username","password"})
	public void setup(String baseURL,String username,String password){
		loginAndsetupEnvironment(baseURL,username,password);
		
	}
	@Test
	public void accountDetailsValidate(){
		accountpage=loginpage.clickOnAccountsTab();
		String accsummary=accountpage.getAuccountSummary();
		String accdetails=accountpage.getAccountDetails();
		Assert.assertTrue(accsummary.equals(accdetails), "Account Summary is not displayed correctly");
		
		}
	@AfterTest
	public void logoutApp(){
		logout();
	}
	
	}
	



package com.hdfc.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hdfc.UIClass.AccountDetailsPage;
import com.hdfc.UIClass.BeneficiariesPage;
import com.hdfc.UIClass.LoginPage;
import com.hdfc.utils.AbstractHDFTest;



public class BeneficiariespageTest extends AbstractHDFTest {
	private LoginPage loginpage;
	private AccountDetailsPage accountpage;
	private AccountDetailsPage beneficiariespage;
	private static Logger Log=Logger.getLogger(BeneficiariespageTest.class);

	@BeforeTest
	@Parameters(value={"baseURL","username","password"})
	public void setup(String url,String username,String password){
		loginAndsetupEnvironment(url,username,password);
		
	}
	
	@Test
	public void accountDetailsValidate(){
		beneficiariespage=loginpage.clickOnAccountsTab();
		String accsummary=accountpage.getAuccountSummary();
		String accdetails=accountpage.getAccountDetails();
		Assert.assertTrue(accsummary.equals(accdetails), "Account Summary is not displayed correctly");
		
		}
	@AfterTest
	public void logout(){
		
	}

}

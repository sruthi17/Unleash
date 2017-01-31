package com.hdfc.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hdfc.UIClass.AccountDetailsPage;
import com.hdfc.UIClass.BeneficiariesPage;
import com.hdfc.UIClass.LoginPage;
import com.hdfc.utils.AbstractHDFTest;


public class addBeneficiaryPageTest extends AbstractHDFTest {
	private LoginPage loginpage;
	private AccountDetailsPage accountpage;
	private BeneficiariesPage beneficiariespage;	
	private static Logger Log=Logger.getLogger(addBeneficiaryPageTest.class);

	@BeforeTest
	@Parameters(value={"baseURL","username","password"})
	public void setup(String url,String username,String password){
		loginAndsetupEnvironment(url,username,password);
		
	}
	/*@Test
	public void loginwithValidCredentials(){
		accountpage=loginpage.viewAccountDetails();
		//assertion
	}*/
	
	@Test(priority=1)
	public void viewBeneficiariesList(){
		beneficiariespage=loginpage.beneficiariesList();
		//assertion
	}
	@AfterTest
	public void logout(){
		
	}
}

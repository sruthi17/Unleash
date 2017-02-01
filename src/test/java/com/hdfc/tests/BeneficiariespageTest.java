package com.hdfc.tests;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;
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
	private BeneficiariesPage beneficiariespage;
	private static Logger Log=Logger.getLogger(BeneficiariespageTest.class);

	@BeforeTest
	@Parameters(value={"baseURL","username","password"})
	public void setup(String baseURL,String username,String password){
		loginAndsetupEnvironment(baseURL,username,password);
		
	}
	
	@Test
	public void validateBeneficiaries() throws InterruptedException{
		beneficiariespage=loginpage.clickOnFundTransferTab().clickOnEnquireMenu().selectViewListOfBeneficiaries().clickViewbtnforNEFT();
		ArrayList<String> beneficiaryNames = new ArrayList<String>();
		ArrayList<String> beneficiaryNamesfromdropdn = new ArrayList<String>();
		beneficiaryNames=beneficiariespage.getBeneficiariesList();
		beneficiariespage=loginpage.clickOnFundTransferTab().clickOnTransactMenu().clickOnThirdPartyTransfer().clickGobtnforNEFT();
		beneficiaryNamesfromdropdn=beneficiariespage.getBeneficiariesfromdropDown();
		boolean status=beneficiariespage.areTwoListsEqual(beneficiaryNames, beneficiaryNamesfromdropdn);
		Assert.assertTrue(status, "List of Beneficiaries does not match with the list from the drop down");
	
		
		}
	@AfterTest
	public void logoutApp(){
		logout();
	}

}

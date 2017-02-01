package com.hdfc.UIClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.tests.BeneficiariespageTest;
import com.hdfc.utils.UtilItems;


public class LoginPage extends UtilItems{
	private WebDriver driver;
	private static Logger Log=Logger.getLogger(LoginPage.class);
	WebDriverWait wait;
	
	public LoginPage(WebDriver dirver){
		Log.info("Navigating to Login page");
		Log.info("Navigating to Login page");
		this.waitForWaitDialogClose(dirver, 5);
		wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.titleContains("NetBanking"));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[contains(@href,'netbanking')]/img")));
		Log.info("Navigted to Continue to NetBanking Page");
		this.driver=driver;
	}
	
	
	public void clickOnContinueNetBanking(){
		driver.findElement(By.xpath("//a[contains(@href,'netbanking')]/img")).click();
		this.waitForAjaxComplete(driver, By.xpath("//input[@name='fldCustId']"), 1);
	}
	
	/*public void enterUserName(){
		driver.findElement(By.xpath("//input[@name='fldCustId']")).sendKeys(username);
	}*/
	
	public void clickOnContinueButton(){
		driver.findElement(By.xpath("//a[contains(@href,'netbanking')]/img")).click();
	}
	
	public void enterPasswordandOtherDetais(){
		driver.findElement(By.xpath("//a[contains(@href,'netbanking')]/img")).click();
	}
	
	public void clickOnLoginButton(){
		driver.findElement(By.xpath("//a[contains(@href,'netbanking')]/img")).click();
	}

	
	public AccountDetailsPage clickOnAccountsTab(){
		try{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
		driver.findElement(By.id("")).click();
		}catch(Exception e){
			Log.error("Cannot find Accounts Tab\n",e);
			throw new IllegalStateException("Cannot find Accounts Tab \n",e);
		}
	return new AccountDetailsPage(driver);
}
	
	public BeneficiariesPage clickOnFundTransferTab(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'s_fund')]")));
			driver.findElement(By.xpath("//img[contains(@src,'s_fund')]")).click();
			}catch(Exception e){
				Log.error("Cannot find Funds Transfer Tab\n",e);
				throw new IllegalStateException("Cannot find Funds Transfer Tab \n",e);
			}
		return new BeneficiariesPage(driver);
	}

public BeneficiariesPage beneficiariesList(){
	try{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
		driver.findElement(By.id("")).click();
		}catch(Exception e){
			Log.error("Cannot find Funds Transfer Tab\n",e);
			throw new IllegalStateException("Cannot find Funds Transfer Tab \n",e);
		}
	return new BeneficiariesPage(driver);

}
}

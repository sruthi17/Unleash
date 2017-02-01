package com.hdfc.UIClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//test
public class AccountDetailsPage extends com.hdfc.utils.UtilItems{
	private WebDriver driver;
	private static Logger Log=Logger.getLogger(AccountDetailsPage.class);
	WebDriverWait wait;
	
	public AccountDetailsPage(WebDriver dirver){
		Log.info("Navigating to Login page");
		Log.info("Navigating to Login page");
		this.waitForWaitDialogClose(dirver, 5);
		wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.titleContains("accountsummary"));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("divUserCredentials"),"User Credentials"));
		Log.info("Navigted to Account Dashboard Page");
		this.driver=driver;
	}
	
	public boolean isTabPresent(String tabName) throws InterruptedException{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id(""))));
		WebElement tab=driver.findElement(By.xpath(""));
		if(tab.getAttribute("ïd").contains(tabName)){
			return true;
		}
		
		return false;
	}
	
	public String getAuccountSummary(){
		String accountsummary=driver.findElement(By.xpath("//*[@id='SavingTotalSummary']")).getText();
		String acc[]=accountsummary.split("INR");
		accountsummary=acc[1];
		return accountsummary;
	}
	
	public String getAccountDetails(){
		String accountdetails=driver.findElement(By.xpath("//*[@id='SavingTotalSummary']")).getText();
		String acctdt="return document.getElementByXPath('//span[@class='othcurr']').getText();";
		String acc[]=acctdt.split("INR");
		acctdt=acc[1];
		return acctdt;
	}

}

package com.hdfc.UIClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.utils.UtilItems;


public class addBeneficiaryPage extends UtilItems{
	private WebDriver driver;
	private static Logger Log=Logger.getLogger(addBeneficiaryPage.class);
	WebDriverWait wait;
	
	public addBeneficiaryPage(WebDriver dirver){
		Log.info("Navigating to Login page");
		this.waitForWaitDialogClose(dirver, 5);
		wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.titleContains("addbeneficiary"));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("divUserCredentials"),"User Credentials"));
		Log.info("Navigted to Add Beneficiary Page");
		this.driver=driver;
	}
	public BeneficiariesPage clickOnTransactMenu(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='menu-drop']/ul/li/a/strong[contains(text(),'Transact')]")));
			driver.findElement(By.xpath("//div[@class='menu-drop']/ul/li/a/strong[contains(text(),'Transact')]")).click();
			}catch(Exception e){
				Log.error("Cannot find Transact Menu\n",e);
				throw new IllegalStateException("Cannot find Transact Menu \n",e);
			}
		return new BeneficiariesPage(driver);
	}
	
}

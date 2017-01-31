package com.hdfc.UIClass;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.utils.UtilItems;

public class BeneficiariesPage extends UtilItems{
	private WebDriver driver;
	private static Logger Log=Logger.getLogger(BeneficiariesPage.class);
	WebDriverWait wait;
	public By exportButton=By.xpath("//button[@id=\"btnExcelExport\"]");
	public BeneficiariesPage(WebDriver dirver){
		Log.info("Navigating to Login page");
		this.waitForWaitDialogClose(dirver, 5);
		wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.titleContains("addbeneficiary"));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("divUserCredentials"),"User Credentials"));
		Log.info("Navigted to View list of Beneficiaries Page");
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
	
	public <List> void viewBeneficiariesList(){
		ArrayList<String>beneficiaries=new ArrayList<String>();
		java.util.List<WebElement> beneficiarieslist=driver.findElements(By.xpath(""));
		for(WebElement benflst:beneficiarieslist){
			
		}
		
	
	}
	
	public ArrayList<String> viewfBeneficiariesListdropDown(){
		ArrayList<String>beneficiaries=new ArrayList<String>();
		java.util.List<WebElement> beneficiarieslist=driver.findElements(By.xpath(""));
		for(WebElement benflst:beneficiarieslist){
			
		}
		return beneficiaries;
	}

}

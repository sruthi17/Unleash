package com.hdfc.UIClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.utils.UtilItems;

public class BeneficiariesPage extends UtilItems{
	private WebDriver driver;
	private static Logger Log=Logger.getLogger(BeneficiariesPage.class);
	WebDriverWait wait;
	
	public BeneficiariesPage(WebDriver dirver){
		Log.info("Navigating to Login page");
		this.waitForWaitDialogClose(dirver, 5);
		wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.titleContains("addbeneficiary"));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("divUserCredentials"),"User Credentials"));
		Log.info("Navigted to View list of Beneficiaries Page");
		this.driver=driver;
	}
	
	public BeneficiariesPage clickOnEnquireMenu(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='menu-drop']/ul/li/a/strong[contains(text(),'Enquire')]")));
			driver.findElement(By.xpath("//div[@class='menu-drop']/ul/li/a/strong[contains(text(),'Enquire')]")).click();
			}catch(Exception e){
				Log.error("Cannot find Enquire Menu\n",e);
				throw new IllegalStateException("Cannot find Enquire Menu \n",e);
			}
		return new BeneficiariesPage(driver);
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
	
	public BeneficiariesPage clickOnThirdPartyTransfer(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TPT_nohref']/a/span")));
			driver.findElement(By.xpath("//*[@id='TPT_nohref']/a/span")).click();
			}catch(Exception e){
				Log.error("Cannot find Third Party Transfer\n",e);
				throw new IllegalStateException("Cannot find Third Party Transfer \n",e);
			}
		return new BeneficiariesPage(driver);
	}
	public BeneficiariesPage selectViewListOfBeneficiaries(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TPI_nohref']/a/span")));
			driver.findElement(By.xpath("//*[@id='TPI_nohref']/a/span")).click();
			}catch(Exception e){
				Log.error("Cannot find View List of Beneficiaries\n",e);
				throw new IllegalStateException("View List of Beneficiaries is not clicked\n",e);
			}
		return new BeneficiariesPage(driver);
	}
	
	
	public BeneficiariesPage clickViewbtnforNEFT(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='borTopGrey']/a[contains(@onclick,'BOTH')]/img")));
			driver.findElement(By.xpath("//td[@class='borTopGrey']/a[contains(@onclick,'BOTH')]/img")).click();
			}catch(Exception e){
				Log.error("Cannot find View List of Beneficiaries\n",e);
				throw new IllegalStateException("View List of Beneficiaries is not clicked\n",e);
			}
		return new BeneficiariesPage(driver);
	}
	
	public BeneficiariesPage clickGobtnforNEFT(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='borTopGrey']/a[contains(@onclick,'NEFT')]/img")));
			driver.findElement(By.xpath("//td[@class='borTopGrey']/a[contains(@onclick,'NEFT')]/img")).click();
			}catch(Exception e){
				Log.error("Cannot find View List of Beneficiaries\n",e);
				throw new IllegalStateException("View List of Beneficiaries is not clicked\n",e);
			}
		return new BeneficiariesPage(driver);
	}
	
	public <List> ArrayList<String> getBeneficiariesList(){
		ArrayList<String>beneficiaries=new ArrayList<String>();
		java.util.List<WebElement> beneficiarieslist=driver.findElements(By.xpath("//table[@class='datatable']//tr[*]/td[5]"));
		for(WebElement benflst:beneficiarieslist){
			String temp=benflst.getText().trim();
			beneficiaries.add(temp);
		}
		
		return beneficiaries;
	
	}
	
	public ArrayList<String> getBeneficiariesfromdropDown(){
		ArrayList<String>beneficiariesls=new ArrayList<String>();
		WebElement selectAccount=driver.findElement(By.xpath("//select[@name='selAcct']"));
		Select accountsel=new Select(selectAccount);
		accountsel.selectByIndex(1);
		WebElement viewBeneficiaries=driver.findElement(By.xpath(".//*[@id='fldBeneId']"));
		Select viewBenef=new Select(viewBeneficiaries);
		List<WebElement> allOptions = viewBenef.getOptions();
		for(WebElement allopt:allOptions){
			String temp=allopt.getText().trim();
			beneficiariesls.add(temp);
		}
		return beneficiariesls;
	}
	
	public boolean areTwoListsEqual(ArrayList<String> list1,ArrayList<String> list2) throws InterruptedException{
		
	    for (String string : list2) {
	        if (list1.contains(string)) {
	          
	        } else {
	        	return false;
	           
	        }
	    }
	    return true;
	}
	
	public BeneficiariesPage addBeneficiary(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class,'formtable')]/tbody/tr/td/a[contains(text(),'Add')]")));
			driver.findElement(By.xpath("//table[contains(@class,'formtable')]/tbody/tr/td/a[contains(text(),'Add')]")).click();
			}catch(Exception e){
				Log.error("Cannot find Add Beneficiary\n",e);
				throw new IllegalStateException("Add Beneficiary is not clicked\n",e);
			}
		return new BeneficiariesPage(driver);
	}

}

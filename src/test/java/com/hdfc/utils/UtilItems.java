package com.hdfc.utils;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public abstract class UtilItems {
	private static Logger Log=Logger.getLogger(UtilItems.class);
	public static int MAX_TRIES=10;
	
	
	
	protected boolean isElementPresent(By by,WebDriver driver){
		try{
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			return driver.findElement(by).isEnabled();
			
		}catch(NoSuchElementException e){
			return false;
			
		}
	}
	
	protected boolean isElementDisplayed(By by,WebDriver driver){
		try{
			return driver.findElement(by).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}catch(Exception e){
			return false;
		}
		
		
	}
	protected void actionClick(WebElement element,WebDriver driver){
		Actions action=new Actions(driver);
		action.perform();
		
	}
	
	protected void jsClick(WebElement element,WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
		
		
	}
	
	protected boolean waitForPageLoad(WebDriver driver,By pageSpinnerImage){
		boolean waitDialog=this.waitForWaitDialogClose(driver);
	return this.waitForAjaxComplete(driver,pageSpinnerImage,1);	
	}
	
	protected boolean waitForWaitDialogClose(WebDriver driver){
		return this.waitForWaitDialogClose(driver);
	}
	
	protected boolean waitForWaitDialogClose(WebDriver driver,int waitMinutes){
		return this.waitForAjaxComplete(driver,By.id("divWaitDialog"),waitMinutes);
	}
	
	protected boolean waitForAjaxComplete(WebDriver driver,By waitspinnerLoc){
		return this.waitForAjaxComplete(driver, waitspinnerLoc,1);
	}
	
	protected boolean waitForAjaxComplete(WebDriver driver,By waitspinnerLoc,int waitMinutes){
		boolean isWaitingComplete=false;
		try{
			int sleepTimeSeconds=3;
			int maxNumberOfTrials=waitMinutes*60/sleepTimeSeconds;
			for(int i=0;!isWaitingComplete&&i<maxNumberOfTrials;i++){
				Thread.sleep(sleepTimeSeconds*1000);
				isWaitingComplete=!(isElementDisplayed(waitspinnerLoc,driver));
			}
		}catch(InterruptedException e){
			
		}catch(NoSuchElementException e){
			
		}catch(Exception e){
			
		}
		
		if(!isWaitingComplete){
			Log.warn("Waited for"+waitMinutes+"minutes, But still the page load is in progress");
			return false;
		}
		return true;
	}
	
	protected void turnOffimplicitWaits(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	}
	
	protected void turnOnImplicitWaits(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	public boolean isProblemFound(WebDriver driver){
		turnOffimplicitWaits(driver);
		WebElement alertBox;
		try{
			alertBox=driver.findElement(By.id("divAlertBox"));
		}catch(NoSuchElementException e){
			alertBox=null;
		}
		return false;
	}
	public boolean checkAndCloseProblemAlert(WebDriver driver){
		if(isProblemFound(driver)){
	driver.findElement(By.id("btnAlertClose")).click();
	return true;
		}
		return false;
	}
	
	public String getProblemMessage(WebDriver driver){
		if(isProblemFound(driver)){
			return driver.findElement(By.id("divAlertMessage")).getText();
		}
		return null;
	}

	public boolean isModelPopupFound(WebDriver driver){
		turnOffimplicitWaits(driver);
		WebElement modelPopup;
		try{
			modelPopup=driver.findElement(By.xpath("//div[@class='modalPopup' and not(contains(@style,'display:none'))]"));
			
		}catch(NoSuchElementException e){
			modelPopup=null;
		}
		turnOnImplicitWaits(driver);
		if(modelPopup!=null && modelPopup.isDisplayed()){
			return true;
		}
		return false;
	}
	
	
	public boolean checkAndCloseModelpopups(WebDriver driver){
		if(isModelPopupFound(driver))
		{
			driver.findElement(By.xpath("//div[@class='modalPopup' and not contains(@style,'display:none'))]//div[contains(@class,'modalpopupButtons')]/button[@class='cancel' or contains(@id,'Cancel')]")).click();
			Log.warn("Open Popup Modal found. Closed the Modal.");
			return true;
		}
		return false;
	}
	
	public void switch_to_window(WebDriver driver,String window_title) throws Exception{
		try{
			Set<String>windows=driver.getWindowHandles();
			for(String window:windows){
				driver.switchTo().window(window);
				if(driver.getTitle().contains(window_title)){
					break;
				}
				driver.manage().window().maximize();
			}
			
				
			}catch(Exception e){
				Log.error("Error while switching to window title->"+window_title+":"+e);
				e.printStackTrace();
				throw new IllegalStateException("Ërror while switching to window with title->"+window_title+":"+e );
		}
	}
	
	
	public void close_window(WebDriver driver,String window_title) throws Exception{
		try{
			this.switch_to_window(driver, window_title);
			driver.close();
		}
		catch(Exception e){
			Log.error("Error while closing the window with title->"+window_title+":"+e);
			e.printStackTrace();
			throw new IllegalStateException("Ërror while closing window with title->"+window_title+":"+e );
		}
	}
	public void logout(){
		
	}
	

}

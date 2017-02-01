package com.hdfc.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractHDFTest extends UtilItems{ 
	private WebDriver driver;
	WebDriverWait wait;
	public void loginAndsetupEnvironment(String url,String username,String passwor){
		driver=new FirefoxDriver();
		driver.get(url);
		this.clickOnContinueNetBanking();
		this.waitForAjaxComplete(driver, By.xpath("//input[@name='fldCustId']"));
		driver.findElement(By.xpath("//input[@name='fldCustId']")).sendKeys(username);
		this.clickOnContinueButton();
		this.waitForAjaxComplete(driver, By.xpath("//a[contains(@href,'netbanking')]/img"));
		driver.findElement(By.xpath("//input[@name='fldPassword']")).sendKeys(passwor);
		this.clickOnSecureImage();
		this.clickOnLoginButton();
				
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
	
	public void clickOnSecureImage(){
		driver.findElement(By.xpath("//*[@id='chkrsastu']")).click();
	}
	public void clickOnLoginButton(){
		driver.findElement(By.xpath("//img[contains(@src,'login')]")).click();
	}
	
	public void logout(){
		driver.findElement(By.xpath("//img[contains(@src,'logout')]")).click();
	}

}

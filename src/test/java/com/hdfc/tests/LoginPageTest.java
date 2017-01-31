package com.hdfc.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hdfc.UIClass.LoginPage;
import com.hdfc.utils.AbstractHDFTest;



public class LoginPageTest extends AbstractHDFTest {
private LoginPage loginpage;
private static Logger Log=Logger.getLogger(LoginPageTest.class);
private static String baseURL;
private static String username;
private static String password;
@BeforeTest
@Parameters(value={"baseURL","username","password"})
public void setup(String baseURL,String username,String password){
	this.baseURL=baseURL;
	this.username=username;
	this.password=password;
	loginAndsetupEnvironment(baseURL,username,password);
	
}
@Test
public void clickOn(){
	
}

@AfterTest
public void logout(){
	
}
}

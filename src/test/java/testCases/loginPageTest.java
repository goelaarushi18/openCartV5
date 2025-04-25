package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.baseClass;

public class loginPageTest  extends baseClass{
	
	@Test(groups= {"Master","Regression"})
	public void login() {
	//homepage
	homePage hp=new homePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	//loginPage
	loginPage lp=new loginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//myacc page
	myAccountPage ap=new myAccountPage(driver);
	boolean targer=ap.macc();
	Assert.assertTrue(targer);
	
	}
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.accountRegistrationPage;
import pageObjects.homePage;
import testBase.baseClass;

public class AccountRegistrationPageTest extends baseClass{
	
	
	@Test(groups= {"Master","Sanity"})
	public void AccRegisteration()  {
		
		logger.info("*** Starting account registration ***");
		homePage hp=new homePage(driver);
		
		//logger.info("click on my account");
		hp.clickMyAccount();
		
		logger.info("click on my register");

		hp.clickRegister();
		accountRegistrationPage ap=new accountRegistrationPage(driver);

		ap.setFirstName(randomString().toUpperCase());
		ap.setLastName(randomString().toUpperCase());
		ap.setEmail(randomString()+"@gmail.com");
		ap.setTelephone(randomenum());
		
		String Pwd=randomealphanum();
		ap.setPassword(Pwd);
		ap.setConfirmPwd(Pwd);
		ap.clickchkbox();
		ap.clickContinueButton();
		String msg=ap.getConfirmationMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		logger.info("validating expected message");
		
	
	}


}

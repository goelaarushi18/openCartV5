package testCases;
 
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.baseClass;
import utilities.DataProviders;
 
public class loginDDT extends baseClass {
    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
    public void verify_loginDDT(String email, String password, String exp) {
        logger.info("**** Starting TC_003_LoginDDT *****");
 
        try {
            // Home page
            homePage hp = new homePage(driver);
            hp.clickMyAccount();
            hp.clickLogin(); // Login link under MyAccount
 
            // Login page
            loginPage lp = new loginPage(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin(); // Login button
 
            // My Account Page
            myAccountPage mp = new myAccountPage(driver);
            
            boolean targetPage = mp.macc();
 
            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    Assert.assertTrue(true);
                    mp.clickLogout();
                } else {
                    Assert.assertTrue(false);
                }
            }
 
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    mp.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }
 
        logger.info("**** Finished TC_003_LoginDDT *****");
    }
}
 
 
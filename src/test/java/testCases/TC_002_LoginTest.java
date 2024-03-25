package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClas;

public class TC_002_LoginTest extends BaseClas {

    @Test(groups = {"sanity", "master"})
    public void loginTest() {

        logger.info("*** TC_002_LoginTest Started ***");
        logger.debug("Application Debug Logs Started");

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            MyAccountPage myAccountPage = new MyAccountPage(driver);

            homePage.clickMyAccount();
            homePage.clickLogin();
            logger.info("Clicked My Account and Login on HomePage");

            loginPage.pageConfirmation();
            logger.info("Landed on Login Page");
            loginPage.setEmail(p.getProperty("email"));
            loginPage.setPassword(p.getProperty("password"));

            loginPage.selectLogin();
            logger.info("Parsed email and pass. Selected Login button");

            boolean myAccountPageValidation = myAccountPage.pageValidation();

            //Assert.assertTrue(myAccountPage.pageValidation(), "LoginTest Failed");
            //logger.info("LoginTest Passed");

            if (myAccountPageValidation) {
                logger.info("LoginTest Passed");
                Assert.assertTrue(true);
            } else {
                logger.error("LoginTest Failed");
                Assert.fail();
            }

        } catch (Exception e) {
            logger.error("Test Failed due to following: " + e);
            Assert.fail();
        }

        logger.info("*** TC_002_LoginTest Finished ***");

    }


}



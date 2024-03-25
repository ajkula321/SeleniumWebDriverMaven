package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClas;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClas {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyLoginDDT(String email, String pass, String expected) {

        logger.info("*** Starting TC_003_LoginDDT ***");

        try {

            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            MyAccountPage myAccountPage = new MyAccountPage(driver);

            homePage.clickMyAccount();
            homePage.clickLogin();

            loginPage.pageConfirmation();
            loginPage.setEmail(email);
            loginPage.setPassword(pass);

            loginPage.selectLogin();

            boolean myAccountPageValidation = myAccountPage.pageValidation();

            if (expected.equalsIgnoreCase("Valid")) {

                if (myAccountPageValidation) {
                    myAccountPage.selectLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }

            if (expected.equalsIgnoreCase("Invalid")) {

                if (myAccountPageValidation) {
                    myAccountPage.selectLogout();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("*** Test Finished ***");

    }

}

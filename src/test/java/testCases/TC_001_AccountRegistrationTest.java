package testCases;

import testBase.BaseClas;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClas {

    @Test(groups = {"regression", "master"})
    public void testAccountRegistration() {

        logger.info("*** Starting TC_001_AccountRegistrationTest ***");
        logger.debug("Application Logs Started");

        try {

            HomePage hp = new HomePage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on My Account");

            hp.clickRegister();
            logger.info("Clicked on Register");

            AccountRegistrationPage acr = new AccountRegistrationPage(driver);
            acr.setFirstName(randomString());
            acr.setLastName(randomString());
            acr.setEmail(randomString() + "@gmail.com");
            acr.setTelephone(randomNumber());
            logger.info("Populated User Details");

            String pass = randomAlphaNumeric();
            acr.setPassword(pass);
            acr.setConfirmPass(pass);
            logger.info("Assigned Password");

            acr.agreeWithTerms();
            acr.continueSelect();
            logger.info("Clicked on Continue");

            String confMessage = acr.validateMessage();

            if (confMessage.equals("Your Account Has Been Created!")) {
                logger.info("Validated expected message");
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test Failed");
                Assert.fail();
            }

            acr.continueAfterRegistration();
            logger.info("Proceeding after registration");


        } catch (Exception e) {
            logger.error("Test Failed due to following exception: " + e);
            Assert.fail();
        }

        logger.debug("Application Logs Finished");

        logger.info("*** Finished TC_001_AccountRegistrationTest ***");

    }


}

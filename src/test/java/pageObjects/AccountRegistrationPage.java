package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    WebDriver driver;

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    //@FindBy(name="firstname")
    @FindBy(id = "input-firstname")
    WebElement firstName_txt;

    @FindBy(id="input-lastname")
    WebElement lastName_txt;
    @FindBy(name="email")
    WebElement email_txt;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone_txt;

    @FindBy(name="password")
    WebElement password_txt;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement passConfirm_txt;

    @FindBy(name="agree")
    WebElement termsAgreement_checkbox;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continue_btn;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountConfirmation_msg;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continue2_btn;

    public void setFirstName(String fname) {
        firstName_txt.sendKeys(fname);
    }

    public void setLastName(String lname) {
        lastName_txt.sendKeys(lname);
    }

    public void setEmail(String email) {
        email_txt.sendKeys(email);
    }

    public void setTelephone(String tel) {
        telephone_txt.sendKeys(tel);
    }

    public void setPassword(String password) {
        password_txt.sendKeys(password);
    }

    public void setConfirmPass(String password) {
        passConfirm_txt.sendKeys(password);
    }

    public void agreeWithTerms() {
        termsAgreement_checkbox.click();
    }

    public void continueSelect() {
        continue_btn.click();
    }

    public String validateMessage() {
        try {
            return accountConfirmation_msg.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void continueAfterRegistration() {
        continue2_btn.click();
    }

}

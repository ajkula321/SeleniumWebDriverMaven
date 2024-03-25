package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement heading_msg;

    @FindBy(id = "input-email")
    WebElement email_txt;

    @FindBy(id = "input-password")
    WebElement password_txt;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement login_btn;

    public void setEmail(String email){
        email_txt.sendKeys(email);
    }

    public void setPassword(String password) {
        password_txt.sendKeys(password);
    }

    public void selectLogin(){
        login_btn.click();
    }

    public boolean pageConfirmation(){
        try {
            return heading_msg.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }




}

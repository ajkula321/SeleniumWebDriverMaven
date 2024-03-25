package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    WebDriverWait mywait;

    // Constructor

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    By img_logo_loc = By.xpath("//img[@alt='company-branding']");
    By txt_username_loc = By.xpath("//input[@placeholder='username']");
    By txt_password_loc = By.xpath("//input[@placeholder='password']");
    By btn_login_loc = By.xpath("//button[normalize-space()='Login']");


    // Action Methods

    public boolean validateLogo() {
        mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean status = mywait.until(ExpectedConditions.visibilityOfElementLocated(img_logo_loc)).isDisplayed();
        return status;
    }

    public void setUserName(String userName) {
        driver.findElement(txt_username_loc).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(txt_password_loc).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btn_login_loc).click();
    }



}

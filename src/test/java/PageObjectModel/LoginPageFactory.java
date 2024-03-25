package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPageFactory {

    WebDriver driver;

    WebDriverWait mywait;

    // Constructor

    LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements

    @FindBy (xpath = "//img[@alt='company-branding']")
    WebElement logo_img;

    @FindBy (name = "username")
    WebElement username_txt;

    @FindBy (xpath = "//input[@placeholder='password']")
    WebElement password_txt;

    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement login_btn;

    //@FindBy (tagName = "a") CAPTURE MULTIPLE ELEMENTS
    //List<WebElement> links;

    // Action Methods

    public boolean validateLogo() {
        mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean status = mywait.until(ExpectedConditions.visibilityOf(logo_img)).isDisplayed();
        return status;
    }

    public void setUserName(String userName) {
        username_txt.sendKeys(userName);
    }

    public void setPassword(String password) {
        password_txt.sendKeys(password);
    }

    public void clickLogin() {
        login_btn.click();
    }




}

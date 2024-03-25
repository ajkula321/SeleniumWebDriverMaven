package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement my_account_link;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register_link;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement login_link;

    public void clickMyAccount() {
        my_account_link.click();
    }

    public void clickRegister() {
        register_link.click();
    }

    public void clickLogin() {
        login_link.click();
    }
}

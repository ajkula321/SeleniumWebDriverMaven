package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement heading_msg;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logout_link;

    public boolean pageValidation() {
        try {
            return mywait.until(ExpectedConditions.visibilityOf(heading_msg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectLogout() {
        logout_link.click();
    }

}

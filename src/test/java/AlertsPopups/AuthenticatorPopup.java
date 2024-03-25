package AlertsPopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuthenticatorPopup {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //"https://the-internet.herokuapp.com/basic_auth"
        //"https:admin:admin@the-internet.herokuapp.com/basic_auth"

        driver.get("https:admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement textValidation = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations!')]"));

        if (textValidation.isDisplayed()) {
            System.out.println("Test is PASS");
        }
        else {
            System.out.println("Test is FAIL");
        }

    }
}

package AlertsPopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputBoxAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Thread.sleep(1500);

        Alert textboxAlert = driver.switchTo().alert();

        textboxAlert.sendKeys("Handling Alerts");
        textboxAlert.accept();

        WebElement textValidation = driver.findElement(By.xpath("//p[@id='result']"));

        if (textValidation.getText().equals("You entered: Handling Alerts")) {
            System.out.println("Test is PASS");
        }
        else {
            System.out.println("Test is FAIL");
        }

    }
}

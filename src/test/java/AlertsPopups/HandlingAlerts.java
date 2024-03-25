package AlertsPopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlerts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        //Alert alertWindow = driver.switchTo().alert();
        Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alertWindow.getText());

        //alertWindow.accept();
        alertWindow.dismiss();


        System.out.println("Test is a PASS");

    }
}

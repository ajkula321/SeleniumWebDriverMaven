package MouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

        driver.switchTo().frame("iframeResult");

        Actions action = new Actions(driver);
        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        field1.clear();
        field1.sendKeys("Vera");
        action.doubleClick(button).perform();

        if (field2.getAttribute("value").equals("Vera")) {
            System.out.println("Test is PASS");
        }







    }
}

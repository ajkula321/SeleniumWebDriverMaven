package MouseOperations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        Actions action = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        action.contextClick(button).perform();

        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();


        System.out.println("Test is PASS");






    }
}

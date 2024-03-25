package MouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        Actions action = new Actions(driver);

        WebElement sourceBox = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
        WebElement targetBox = driver.findElement(By.xpath("//div[@id='droppable']"));

        action.dragAndDrop(sourceBox, targetBox).perform();
    }
}

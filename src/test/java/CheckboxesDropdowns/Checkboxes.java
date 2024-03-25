package CheckboxesDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Checkboxes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Specific Checkbox
        //driver.findElement(By.xpath("//input[@id='sunday']")).click();

        // Select All Checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println("Total Number of checkboxes: " + checkboxes.size());

        /*for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }*/

        // Select last two checkboxes / Total number of checkboxes minus number you want to select. Number you get is starting index
        /*for (int i = 5; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }

        // Select first two checkboxes
        for (int i = 0; i < 2; i++) {
            checkboxes.get(i).click();
        }*/

        // Clear All Checkboxes
        for (int i = 2; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }

        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }




        System.out.println("Test is PASS");
        //driver.quit();
    }
}

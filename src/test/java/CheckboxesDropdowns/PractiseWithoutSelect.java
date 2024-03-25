package CheckboxesDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class PractiseWithoutSelect {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        dropdown.click();

        List<WebElement> dropdownValues = driver.findElements(By.xpath("//select[@id='country']//child::option"));
        for (WebElement value : dropdownValues) {
            if (value.getText().equals("Japan")) {
                value.click();
                break;
            }
        }

        System.out.println("Test is PASS");

    }
}

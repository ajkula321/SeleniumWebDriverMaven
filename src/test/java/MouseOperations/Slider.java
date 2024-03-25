package MouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Slider {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        Actions action = new Actions(driver);

        WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
        WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));

        // MinSlider Management
        System.out.println("MinSlider location: " + minSlider.getLocation());
        action.dragAndDropBy(minSlider, +100, 250).perform();
        System.out.println("MinSlider location: " + minSlider.getLocation());

        // MaxSlider Management
        System.out.println("MaxSlider location: " + maxSlider.getLocation());
        action.dragAndDropBy(maxSlider, -100, 250).perform();
        System.out.println("MaxSlider location: " + maxSlider.getLocation());



    }
}

package BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php?");
        driver.manage().window().maximize();

        driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
        driver.findElement(By.name("submit_search")).click();

        // Link Text - used only for links. <a> with href's
        driver.findElement(By.linkText("Blouse")).click();
        //driver.findElement(By.partialLinkText("Blous")).click();

        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        // Class Name locator
        List<WebElement> sliders = driver.findElements(By.className("homeslider-container")); // Finding number of sliders
        System.out.println("Number of sliders: " + sliders.size());

        // Tag Name locator
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Number of images: " + images.size());

        //Find Total Number of Links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + links.size());



        System.out.println("Test PASS");
        driver.quit();
    }
}

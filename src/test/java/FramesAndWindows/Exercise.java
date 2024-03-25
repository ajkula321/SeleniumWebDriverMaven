package FramesAndWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Exercise {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> searchList = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));

        for (WebElement result : searchList) {
            result.click();
        }

        Set<String> tabsSet = driver.getWindowHandles();
        List<String> tabsList = new ArrayList<>(tabsSet);

        for (String tab : tabsList) {
            driver.switchTo().window(tab);
            driver.close();
        }


        System.out.println("Test is PASS");
    }
}

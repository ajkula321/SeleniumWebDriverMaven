package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().fullscreen();

        System.out.println("Title of the page is: " + driver.getTitle());
        System.out.println("URL of the page is: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // open new browser window

        Set<String> windowIds  = driver.getWindowHandles();

        for (String winId : windowIds) {
            System.out.println(winId);
        }




        System.out.println("Test PASS");
        driver.quit();

    }
}

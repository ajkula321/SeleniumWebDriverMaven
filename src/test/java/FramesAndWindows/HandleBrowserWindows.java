package FramesAndWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        // capturing Browser Windows IDs

        Set<String> windowIDs = driver.getWindowHandles();

        // Approach 1
        /*
        //Converting Set to List
        List<String> windowsIDsList = new ArrayList<>(windowIDs);

        String parentWindowId = windowsIDsList.get(0);
        String childWindowId = windowsIDsList.get(1);

        driver.switchTo().window(childWindowId);

        driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();

        driver.switchTo().window(parentWindowId);

        driver.findElement(By.name("username")).sendKeys("Admin");
        */

        // Approach 2

        for (String winIDs : windowIDs) {

           String title = driver.switchTo().window(winIDs).getTitle();

           if (title.equals("OrangeHRM HR Software | OrangeHRM")) {
                driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
           }
        }

        for (String winIDs : windowIDs) {

            String title = driver.switchTo().window(winIDs).getTitle();

            if (title.equals("Book Your Free OrangeHRM Demo Now | OrangeHRM")) {
                driver.close();
            }
        }


        System.out.println("Test is Pass");


    }
}

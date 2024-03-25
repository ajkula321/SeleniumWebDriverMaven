package TestNG;

// 1. Open Application
// 2. Login to application
// 3. Close application

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SecondTest {

    WebDriver driver;

    @BeforeClass
    //@Test (priority = 1)
    void openApp() {
        System.out.println("This is test 1. Open Application");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @Test (priority = 2)
    void login() {
        System.out.println("This is test 2. Login to Application");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
    @AfterClass
    //@Test (priority = 3)
    void closeApp() {
        System.out.println("This is test 3. Close Application");
        driver.quit();
    }

}

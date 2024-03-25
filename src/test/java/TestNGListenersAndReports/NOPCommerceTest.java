package TestNGListenersAndReports;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NOPCommerceTest {

    SoftAssert sa = new SoftAssert();

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setup(String br, String url) throws InterruptedException {
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
    }

    @Test(priority = 1, invocationCount = 3)
    public void validation() {
        try {
            boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
            Assert.assertTrue(status);
        }
        catch (NoSuchElementException e) {
            Assert.fail();
        }
    }

    @Test(priority = 2)
    public void login() {
        try {
            driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
            driver.findElement(By.id("Email")).sendKeys("ajkula123@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("toaletpapir123");
            driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
            boolean status = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
            Assert.assertEquals(status, true);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Test(priority = 3, dependsOnMethods = "login")
    public void logout() {
        driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
        boolean status = driver.findElement(By.xpath("//a[normalize-space()='Log in']")).isDisplayed();
        Assert.assertEquals(status, true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}

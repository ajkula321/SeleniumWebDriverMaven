package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


public class ParallelTesting {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String br, String url) throws InterruptedException {  // br variable hold value from "browser" parameter in xml
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    void logoTest() {
        try {
            Boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
            Assert.assertEquals(status, true);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test(priority = 2)
    void testHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM", "Titles are not matching");
    }

    @AfterClass
    void closeApp() {
        driver.quit();
    }

}

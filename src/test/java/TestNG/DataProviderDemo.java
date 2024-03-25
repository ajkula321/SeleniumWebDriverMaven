package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class DataProviderDemo {

    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
    }

    @Test (dataProvider = "dp")
    void testLogin(String email, String pwd) throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        String exp_title = "nopCommerce demo store";
        String act_title = driver.getTitle();

        Assert.assertEquals(exp_title, act_title);
    }

    @AfterTest
    void tearDown() {
        driver.close();
    }

    //@DataProvider(name = "dp", indices = {0, 3})
    String[][] loginData() {
        String data[][] = {
                { "abc@gmail.com", "test123" },
                { "pavanol@gmail.com", "test@123" },
                { "pavanoltraining@gmail.com", "test3" },
                { "ajkula123@gmail.com", "toaletpapir123" },
                { "ajkula123@gmail.com", "toaletpapir123" },
        };
        return data;
    }
}

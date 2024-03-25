package Beginning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAssignement {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        WebElement username = driver.findElement(By.id("Email"));
        username.clear();
        username.sendKeys("admin@yourstore.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
        loginButton.click();

        Thread.sleep(3000);

        String t = driver.getTitle();

        String expTitle = "Dashboard / nopCommerce administration";

        if (t.equals(expTitle)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

        driver.quit();

    }
}

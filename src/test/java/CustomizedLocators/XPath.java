package CustomizedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        String elementText = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
        System.out.println(elementText);

        System.out.println("Test is PASS");
        driver.quit();

    }
}

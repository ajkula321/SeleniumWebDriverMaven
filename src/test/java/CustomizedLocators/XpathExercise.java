package CustomizedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathExercise {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        // text(), contains() & starts-with() Xpath functions
        driver.findElement(By.xpath("//a[text()='Terms & Conditions']"));
        driver.findElement(By.xpath("//a[contains(text(),'Conditions')]"));
        driver.findElement(By.xpath("//a[starts-with(text(), 'Terms')]"));

        // Multiple attributes locating
        driver.findElement(By.xpath("//nav[@id='menu' or @class='navbar navbar-expand-lg navbar-light bg-primary']"));
        driver.findElement(By.xpath("//nav[contains(@class, 'bg-primary') or @id='menu']"));
        driver.findElement(By.xpath("//nav[contains(@class, 'bg-primary') and @id='menu']"));

        //







        System.out.println("Test Pass");
        driver.quit();

    }
}

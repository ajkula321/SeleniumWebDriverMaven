package CustomizedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxis {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        // Xpath Axis - Parent - //i[@class='fas fa-search']/parent::button"
        // /parent::*  / Syntax if more than one parent. Considering both
        // /..  Syntax if only one parent
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Phone");
        driver.findElement(By.xpath("//i[@class='fas fa-search']/parent::button")).click();

        Thread.sleep(1000);
        driver.navigate().back();

        // Xpath Axis - Child - //div[@id='search']/child::button"
        // /child::*  / Syntax if more than one child. Considering both
        // /..   / Syntax if only one child
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Phone");
        driver.findElement(By.xpath("//div[@id='search']/child::button")).click();

        Thread.sleep(1000);
        driver.navigate().back();
        driver.findElement(By.xpath("//input[@name='search']")).clear();

        // Xpath Axis - Descendant - //div[@id='search']/descendant::button"
        // /descendant::*  / Syntax if more than one descendant. Considering both
        // /..   / Syntax if only one descendant
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Phone");
        driver.findElement(By.xpath("//div[@class='col-md-5']/descendant::button")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//input[@name='search']")).clear();

        // Xpath Axis - Ancestor - //div[@id='search']/ancestor::button"
        // /ancestor::*  / Syntax if more than one ancestor. Considering both
        // /..   / Syntax if only one ancestor
        driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']/ancestor::div"));

        // Xpath Axis - Following Sibling - //div[@id='search']/following::button"
        // /following::*  / Syntax if more than one sibling. Considering both
        // /..   / Syntax if only one sibling
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Phone");
        driver.findElement(By.xpath("//input[@name='search']/following::button")).click();
        // ITS THE SAME FOR PRECEDING JUST BACKWARDS
        // ITS THE SAME FOR Following/Preceding Siblings. RULE: Siblings have same parent
        // preceding-sibling:: / following-sibling::

        System.out.println("Test Pass");
        driver.quit();

    }
}

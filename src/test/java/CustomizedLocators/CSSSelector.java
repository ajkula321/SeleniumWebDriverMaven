package CustomizedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {
    public static void main(String[] args) {


        /*
        tag#id - Example: input#small-searchterms
        tag.class - Example: button.button-1.search-box-button
        tag[attribute] - Example: By.cssSelector("input[type='text']")
        tag.class[attribute] - Example: By.cssSelector("input.search-box-text.ui-autocomplete-input[type='text']")
        XPath
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Tag & ID
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");

        // Tag & Class
        driver.findElement(By.cssSelector("button.button-1.search-box-button")).click();
        driver.navigate().back();

        // Tag & Attribute
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Galaxy");

        // Tag & Class & Attribute
        driver.findElement(By.cssSelector("input.search-box-text.ui-autocomplete-input[type='text']")).clear();
        driver.findElement(By.cssSelector("input.search-box-text.ui-autocomplete-input[type='text']")).sendKeys("Class & Attribute");



        System.out.println("Test is PASS");
        driver.quit();

    }

}

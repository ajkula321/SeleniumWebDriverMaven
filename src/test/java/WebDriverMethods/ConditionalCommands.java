package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// isDisplayed, isSelected, isEnabled - methods are returning boolean

public class ConditionalCommands {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().fullscreen();

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println("Display status of logo: " + logo.isDisplayed());

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Is Search Box Displayed: " + searchBox.isDisplayed());
        System.out.println("Is Search Box Enabled: " + searchBox.isEnabled());

        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-female']"));

        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
        System.out.println("Is male radio button selected: " + maleRadioButton.isSelected());

        maleRadioButton.click();
        System.out.println("Is male radio button selected: " + maleRadioButton.isSelected());

        femaleRadioButton.click(); // clicking female radio button
        System.out.println("Is male radio button selected: " + maleRadioButton.isSelected());

        System.out.println("Test PASS");
        driver.close(); // closing only one browser tab
        //driver.quit(); // closing whole browser
    }
}

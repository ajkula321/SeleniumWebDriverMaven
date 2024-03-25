package CheckboxesDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropdownSelect {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Select Class for handling dropdowns with <Select> Tag

        WebElement drpCountryElement = driver.findElement(By.xpath("//select[@id='country']"));

        Select drpCountrySelect = new Select(drpCountryElement);

        // Selecting an option from Dropdown

        drpCountrySelect.selectByVisibleText("Canada");

        drpCountrySelect.selectByValue("france");

        drpCountrySelect.selectByIndex(6);

        // Find total options in dropdown

        List<WebElement> allOptions = drpCountrySelect.getOptions();
        System.out.println("Total number of options: " + allOptions.size());

        for (WebElement option: allOptions) {
            System.out.print(option.getText() + ", ");
        }




        System.out.println("Test is PASS");
    }
}

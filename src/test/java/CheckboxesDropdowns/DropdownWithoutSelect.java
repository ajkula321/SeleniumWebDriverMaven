package CheckboxesDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropdownWithoutSelect {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@type='button']")).click();

        // Find all options in the dropdown
        List<WebElement> dopdownValues = driver.findElements(By.xpath("//ul[contains(@class, multiselect)]//li//label"));
        System.out.println("Total Number of options: " + dopdownValues.size());

        /*for (WebElement opt : dopdownValues) {
            System.out.println(opt.getText());
        }*/

        // Select options from dropdown

        for (int i = 0; i < dopdownValues.size(); i++) {

            String option = dopdownValues.get(i).getText();

            if (option.equals("Java") || option.equals("Python")){
                dopdownValues.get(i).click();
            }
        }


        System.out.println("Test is PASS");



    }
}

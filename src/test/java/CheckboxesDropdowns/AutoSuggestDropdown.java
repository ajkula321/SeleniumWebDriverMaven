package CheckboxesDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class AutoSuggestDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
        Thread.sleep(1500);

        List<WebElement> valueList = driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
        System.out.println("Number of values find: " + valueList.size());

        /*for (WebElement value : valueList) {
            System.out.print(value.getText() + " ,");
        }*/

        for (int i = 0; i < valueList.size(); i++) {
            System.out.println(valueList.get(i).getText());
        }

        for (int i = 0; i < valueList.size(); i++) {
            String text = valueList.get(i).getText();

            if (text.equals("selenium sulfide")) {
                valueList.get(i).click();
                break;
            }
        }




        System.out.println("Test is PASS");

    }
}

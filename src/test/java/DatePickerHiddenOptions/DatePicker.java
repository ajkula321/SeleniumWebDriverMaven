package DatePickerHiddenOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        String year = "1999";
        String month = "May";
        String day = "27";

        while (true) {
            String calendarYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String calendarMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (calendarYear.equals(year) && calendarMonth.equals(month)) {
                break;
            }

            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

        }

        List<WebElement> allDates = driver.findElements(By.xpath("//tbody//td"));

        for (WebElement date : allDates) {
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }

        System.out.println("Test is PASS");
    }
}

package DatePickerHiddenOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePickerWithDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        Thread.sleep(2500);

        driver.findElement(By.xpath("//input[@id='dob']")).click();

        String year = "2024";
        String month = "May";
        String day = "27";

        //List<WebElement> allYears = driver.findElements(By.xpath(""));
        //List<WebElement> allMonths = driver.findElements(By.xpath(""));

        // DROPDOWNS YEAR/MONTH
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        WebElement yearDropdown = driver.findElement(By.cssSelector("select[aria-label='Select year']"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);


        List<WebElement> allDates = driver.findElements(By.xpath("//body[1]/div[5]/table[1]/tbody[1]/tr/td"));

        for (WebElement date : allDates) {
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }

        System.out.println("Test is PASS");
    }


}

package DatePickerHiddenOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://blazedemo.com/");

        WebElement departureDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departureOptions = new Select(departureDropdown);
        departureOptions.selectByIndex(1);

        WebElement destinationDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select destinationOptions = new Select(destinationDropdown);
        destinationOptions.selectByIndex(5);

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        int rowsNum = driver.findElements(By.xpath("//tbody//tr")).size();

        ArrayList<Float> floatValues = new ArrayList<>();

        for (int i = 1; i <= rowsNum; i++) {
            String stringValue = driver.findElement(By.xpath("//tbody//tr["+i+"]/td[6]")).getText();
            float value = Float.parseFloat(stringValue.substring(1));
            floatValues.add(value);
        }

        Collections.sort(floatValues);
        String minValue = "$" + String.valueOf(floatValues.get(0));

        for (int i = 1; i < rowsNum; i++) {
            String cellString = driver.findElement(By.xpath("//tbody//tr["+i+"]/td[6]")).getText();
            if (cellString.equals(minValue)) {
                driver.findElement(By.xpath("//tbody//tr["+i+"]/td[1]")).click();
                break;
            }
        }

        if (driver.getTitle().equals("BlazeDemo Purchase")) {
            System.out.println("Test is PASS");
        }
        else {
            System.out.println("Test is FAIL");
        }


    }
}

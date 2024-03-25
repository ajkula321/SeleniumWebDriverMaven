package Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        int rowsNum = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Total Number of Rows: " + rowsNum);

        int columnsNum = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
        System.out.println("Total Number of Columns: " + columnsNum);

        String specificData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[3]")).getText();
        System.out.println("This is specific data: " + specificData);

        // Read all table data
        for (int r = 2; r <= rowsNum; r++) {
            for (int c = 1; c <= columnsNum; c++) {
                String cellData = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(cellData + " |");
            }
            System.out.println("");
        }

        // Print Book Names from Author: Amit

        for (int r = 2; r <= rowsNum; r++) {
            String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if (author.equals("Mukesh")) {
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println("Author of the " + bookName + " book is: " + author);
            }
        }

        // Sum all the book prices

        int sum = 0;
        for (int r = 2; r <= rowsNum; r++) {
            String priceString = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
            sum = sum + Integer.parseInt(priceString);
        }
        System.out.println("Sum of all book prices is: " + sum);






        System.out.println("Test is PASS");
    }
}

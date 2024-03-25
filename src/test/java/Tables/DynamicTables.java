package Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicTables {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.opencart.com/admin/");

        // Logging in and navigation
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        }

        driver.findElement(By.cssSelector("a.parent[href='#collapse-5']")).click();
        //driver.findElement(By.xpath("//a[@class='parent'][normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//li[@id='menu-customer']//li//a[text()='Customers']")).click();

        // Get Text Pagination Numbers
        String paginationText = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        System.out.println(paginationText);

        // Get Int Pagination data
        int paginationNumber = Integer.parseInt(paginationText.substring(paginationText.indexOf("(")+1, paginationText.indexOf("pageObjects")-1));
        System.out.println(paginationNumber);

        int[] tableColumns = {2, 3, 6};

        for (int i = 1; i <= paginationNumber; i++) {

            if (i > 1) {
                driver.findElement(By.xpath("//a[normalize-space()="+i+"]")).click();
                Thread.sleep(1500);
            }

            int tableRows = driver.findElements(By.xpath("//tbody/tr")).size();

            for (int r = 1; r <= tableRows; r++) {
                for (int c : tableColumns) {
                    String cellText = driver.findElement(By.xpath("//tbody/tr["+r+"]/td["+c+"]")).getText();
                    System.out.print(cellText + " |");
                }
                System.out.println("");
            }

            System.out.println("THIS IS END OF TABLE PAGE");





        }





        System.out.println("Test is PASS");

    }
}

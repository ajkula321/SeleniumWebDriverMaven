package Beginning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.NoSuchElementException;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {

        //1. Launch Browser
        ChromeDriver driver;
        driver = new ChromeDriver();

        //2. Open URL https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        //3. Provide Username - Admin
        WebElement txtUSername = driver.findElement(By.name("username"));
        txtUSername.sendKeys("Admin");
        //driver.findElement(By.name("username")).sendKeys("Admin"); Second way, all in one line without variable

        //4. Provide the password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //5. Click on the Login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        Thread.sleep(3000);

        //6. Verify Dashboard page
        /*String act_title = driver.getTitle();
        String exp_title = "OrangeHRM";

        if (act_title.equals(exp_title)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }*/
        String act_label = "";
        try {
            act_label = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        }
        catch (NoSuchElementException e) {
            System.out.println("Element is not present on the current page");
        }

        String exp_label = "Dashboard";

        if (act_label.equals(exp_label)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

        //7. Close Browser
        driver.quit();





    }
}

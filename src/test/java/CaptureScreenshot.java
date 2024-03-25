import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshot {
    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.nopcommerce.com/");

        // Full Page Screenshot

        TakesScreenshot ts = driver;

        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File("C:\\QA Automation Java\\JAVA\\SeleniumWebDriverMaven\\Screenshots\\fullpage.png");

        FileUtils.copyFile(src, trg);

        // Specific Area of Page

        WebElement pageArea = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

        File src1 = pageArea.getScreenshotAs(OutputType.FILE);
        File trg1 = new File("C:\\QA Automation Java\\JAVA\\SeleniumWebDriverMaven\\Screenshots\\fullpage1.png");

        FileUtils.copyFile(src1, trg1);


        System.out.println("Test is PASS");
    }
}

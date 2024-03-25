import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptExecute {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        JavascriptExecutor js = driver;

        WebElement firstName = driver.findElement(By.id("name"));

        js.executeScript("arguments[0].setAttribute('value','Vera')", firstName); // sending text with js script

        WebElement radioButton = driver.findElement(By.xpath("//input[@id='male']"));

        js.executeScript("arguments[0].click();", radioButton); // clicking with js script

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://en.wikipedia.org/wiki/Gallery_of_sovereign_state_flags");

        //js.executeScript("window.scrollBy(0, 3000)", ""); // scrolling using js script and pixels

        WebElement denmarkFlag = driver.findElement(By.xpath("//img[@alt='Denmark']"));

        //js.executeScript("arguments[0].scrollIntoView(0)", denmarkFlag); // js script scrolling until element is visible

        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        Thread.sleep(500);

        js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");




        System.out.println("Test is PASS");


    }
}

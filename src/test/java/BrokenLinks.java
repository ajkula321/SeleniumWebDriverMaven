import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        int brokenLinks = 0;

        for (WebElement link : allLinks) {
            String hrefAttValue = link.getAttribute("href");

            if (hrefAttValue == null || hrefAttValue.isEmpty()) {
                continue;
            }

            URL linkUrl = new URL(hrefAttValue);
            HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
            conn.connect();

            if (conn.getResponseCode() >= 400) {
                System.out.println(hrefAttValue + " " + "Broken Link");
                brokenLinks++;
            }
            else {
                System.out.println(hrefAttValue + " " + "Not Broken Link");
            }


        }

        System.out.println("We have totally " + brokenLinks + "broken links");









        System.out.println("Test is PASS");
    }
}

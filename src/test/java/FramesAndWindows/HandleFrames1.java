package FramesAndWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // driver.switchTo().frame(This can be used Frame "name", "index" and WebElement);

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("This is Frame 1");

        driver.switchTo().defaultContent();

        WebElement frame2 = driver.findElement(By.cssSelector("frame[src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        //driver.switchTo().frame(1);
        //driver.findElement(By.name("mytext2")).sendKeys("This is Frame 2");

        driver.switchTo().defaultContent();

        //driver.switchTo().frame(0);
        //driver.switchTo().frame(0);


        System.out.println("Test is PASS");


    }

}

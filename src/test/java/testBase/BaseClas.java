package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.Remote;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseClas {

    static public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"sanity", "regression", "master"})
    @Parameters({"browser", "os"})
    public void setup(String browser, String os) throws IOException, URISyntaxException {

        // Loading Properties File
        FileReader file = new FileReader(".//src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        //Loading log4j2 file
        logger = LogManager.getLogger(this.getClass());

        // GRID Example - Choosing if test will be run Locally or Remotely
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

            String nodeURL = "http://192.168.0.24:4444";

            URI uri = new URI(nodeURL);

            DesiredCapabilities cap = new DesiredCapabilities();

            if (os.equalsIgnoreCase("Windows")) {
                cap.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("Mac")) {
                cap.setPlatform(Platform.MAC);
            }
            else {
                System.out.println("No matching Operating System");
                return;
            }

            switch (browser.toLowerCase()) {
                case "chrome": cap.setBrowserName("chrome"); break;
                case "edge": cap.setBrowserName("MicrosoftEdge"); break;
                default:
                    System.out.println("No Matching Browser");
                    return;
            }
            driver = new RemoteWebDriver(uri.toURL(), cap);

        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            //Launching Browser based on XML Parameter
            switch (browser.toLowerCase()) {
                case "chrome": driver = new ChromeDriver(); break;
                case "edge": driver = new EdgeDriver(); break;
                default:
                    System.out.println("No Matching Browser");
                    return;
            }
        }

        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }
    @AfterClass(groups = {"sanity", "regression", "master"})
    public void teardown() {
        driver.quit();
    }

    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    public String randomNumber() {
        String generatedString = RandomStringUtils.randomNumeric(10);
        return generatedString;
    }
    public String randomAlphaNumeric() {
        String str = RandomStringUtils.randomAlphabetic(3);
        String num = RandomStringUtils.randomNumeric(3);
        return (str + "$" + num);
    }

    public static String captureScreen(String tname) throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + " " + timestamp + " .png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;


    }



}

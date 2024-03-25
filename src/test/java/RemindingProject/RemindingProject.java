package RemindingProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RemindingProject {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        // Name Text Box Interaction
        WebElement nameTextBox = driver.findElement(By.id("name"));
        if (nameTextBox.isDisplayed()) {
            System.out.println("Name Text Box is displayed");
        }
        nameTextBox.sendKeys("This is Name Text Box");

        // Male Radio Button Interaction
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='male']"));
        if (maleRadioButton.isEnabled()) {
            System.out.println("Male Radio Button is enabled");
        }
        maleRadioButton.click();
        if (maleRadioButton.isSelected()) {
            System.out.println("Male Radio Button is selected");
        }

        // Monday - Sunday Check Boxes Interaction
        List<WebElement> weekCheckboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println(weekCheckboxes.size());
        for (WebElement checkbox : weekCheckboxes) {
            checkbox.click();
        }

        // Country Dropdown Interaction - Select Class
        WebElement countryDropdown = driver.findElement(By.cssSelector("select#country"));
        Select countryOptions = new Select(countryDropdown);
        countryOptions.selectByVisibleText("France");
        countryOptions.selectByIndex(0);
        countryOptions.selectByValue("canada");

        // Auto Suggest Dropdown Interaction
        WebElement autoSuggest = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
        autoSuggest.sendKeys("tug of war");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/div/a"));
        System.out.println("Number of search results: " + searchResults.size());
        for (WebElement result : searchResults) {
            if (result.getText().equals("Tug of war")) {
                result.click();
                break;
            }
        }

        // Swap Between Tabs - Handle Browser Windows
        Set<String> windowIDs = driver.getWindowHandles();
        List<String> windowsIDsList = new ArrayList<>(windowIDs);
        String parentWindowID = windowsIDsList.get(0);
        String childWindowID = windowsIDsList.get(1);
        driver.switchTo().window(childWindowID);
        // Title Check
        String childWindowTitle = "Tug of war - Wikipedia";
        if (driver.getTitle().equals(childWindowTitle)) {
            System.out.println("You are on expected Window - Confirmed By Title");
        }
        // Element Check
        WebElement validationDropdown = driver.findElement(By.xpath("//input[@id='p-lang-btn-checkbox']"));
        if (validationDropdown.isEnabled()) {
            System.out.println("You are on expected Window - Validated by enabled element");
        }
        else {
            System.out.println("element not found");
        }

        // Return to Parent Window and Close Child one
        driver.close();
        driver.switchTo().window(parentWindowID);
        // Title Check
        String parentWindowTitle = "Automation Testing Practice";
        if (driver.getTitle().equals(parentWindowTitle)) {
            System.out.println("You are on expected Window - Confirmed By Title");
        }

        // Handle Alerts
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
        alertButton.click();
        Alert alertWindow = driver.switchTo().alert();
        alertWindow.accept();
        // Handle Ok-Cancel Alert
        WebElement yesNoAlertButton = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
        yesNoAlertButton.click();
        Alert yesNoAlertWindow = driver.switchTo().alert();
        yesNoAlertWindow.dismiss();
        if (driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).isDisplayed()) {
            System.out.println("Ok-Cancel Alert Is Handled Properly");
        }
        // Handle Text Box Alert
        WebElement textBoxAlertButton = driver.findElement(By.xpath("//button[text()='Prompt']"));
        textBoxAlertButton.click();
        Alert textBoxAlertWindow = driver.switchTo().alert();
        textBoxAlertWindow.sendKeys("Milos");
        textBoxAlertWindow.accept();
        if (driver.findElement(By.xpath("//p[text()='Hello Milos! How are you today?']")).isDisplayed()) {
            System.out.println("Text Box Alert Is Handled Properly");
        }

        // Handle Frames
        WebElement frame = driver.findElement(By.id("frame-one796456169"));
        driver.switchTo().frame(frame);
        WebElement frameTextBox = driver.findElement(By.id("RESULT_TextField-0"));
        frameTextBox.sendKeys("This is Frame Text Box");
        //driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-1_1']/..")).click(); // CONSULT WITH SAVO
        WebElement jobsDropdown = driver.findElement(By.id("RESULT_RadioButton-3"));
        jobsDropdown.click();
        Select jobs = new Select(jobsDropdown);
        jobs.selectByVisibleText("QA Engineer");
        driver.switchTo().defaultContent();

        // validating if element on default page visible
        if (nameTextBox.isDisplayed()) {
            System.out.println("We are out of IFrame successfully!");
        }







        System.out.println("Test is PASS");

    }
}

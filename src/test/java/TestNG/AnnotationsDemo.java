package TestNG;

import org.testng.annotations.*;

public class AnnotationsDemo {

    @BeforeSuite
    void beforeSuite() {
        System.out.println("Executing Before Suite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("This is before test method");
    }

    @BeforeMethod
    void login() {
        System.out.println("Login...");
    }

    @Test (priority = 0)
    void search() {
        System.out.println("Search...");
    }

    @Test (priority = 1)
    void advancedSearch() {
        System.out.println("Advanced Search...");
    }

    @AfterMethod
    void logout() {
        System.out.println("Logout...");
    }
}

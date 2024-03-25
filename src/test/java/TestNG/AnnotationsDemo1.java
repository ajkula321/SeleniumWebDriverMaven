package TestNG;

import org.testng.annotations.*;

public class AnnotationsDemo1 {

    @BeforeClass
    void login() {
        System.out.println("Login...");
    }

    @Test(priority = 0)
    void search() {
        System.out.println("Search...");
    }

    @Test (priority = 1)
    void advancedSearch() {
        System.out.println("Advanced Search...");
    }

    @AfterClass
    void logout() {
        System.out.println("Logout...");
    }

    @AfterTest
    void afterTest() {
        System.out.println("This is after test");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("Executing After Suite");
    }

}

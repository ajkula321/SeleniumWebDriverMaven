package TestNG;

import org.testng.annotations.Test;

public class InvocationCount {

    @Test (invocationCount = 10) // Good for exhaustive testing // testing same thing multiple cuz sometimes fail sometimes pass
    void test() {
        System.out.println("This is test");
    }
}

package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardSoftAssertions {

    SoftAssert sa = new SoftAssert();

    @Test
    void test() {
        int x = 10;
        int y = 15;

        //Assert.assertEquals(x,y);
        //Assert.assertTrue();
        //Assert.assertEquals(x<y, true, "a should not be greater than b");

        // If Hard Assert fails, code will not be executed after failed Assert

        String s1 = "string one";
        String s2 = "string two";

        sa.assertEquals(s1,s2, "strings are not equal");
        // If Soft Assert fails, code will be executed after it

        Assert.assertNotEquals(s1, s2);

        System.out.println("Soft Assertion is executed properly");

        sa.assertAll();
    }

}

package TestNGListenersAndReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener { // or extends TestListenerAdapter Class

    public void onTestStart(ITestResult result) {
        System.out.println("Test is started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is Pass");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test is Fail");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is Skipped");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test is Finished");
    }

}

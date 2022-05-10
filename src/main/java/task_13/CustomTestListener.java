package task_13;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class CustomTestListener implements ITestListener {
    public static final Logger LOGGER = Logger.getLogger(String.valueOf(CustomTestListener.class));

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("CustomTestListener: onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("CustomTestListener: onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("CustomTestListener: onTestFailure");
    }

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("CustomTestListener: onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("CustomTestListener: onFinish");
    }
}

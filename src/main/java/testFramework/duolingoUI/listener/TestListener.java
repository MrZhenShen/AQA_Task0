package testFramework.duolingoUI.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestListener implements ITestListener {
    public static final Logger LOGGER = Logger.getLogger(String.valueOf(TestListener.class));

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info(result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info(context.getName());
    }
}

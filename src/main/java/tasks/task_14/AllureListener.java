package tasks.task_14;

import testFramework.duolingoUI.util.BrowserFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        addScreen();
        addDOM();
        addCurrentURL();
    }

    @Attachment(value = "Page Screen", type = "image/png")
    private byte[] addScreen() {
        return ((TakesScreenshot) BrowserFactory.getSafariDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page Source", type = "text/plain")
    private String addDOM() {
        return BrowserFactory.getSafariDriver().getPageSource();
    }

    @Attachment(value = "Page URL", type = "text/plain")
    private String addCurrentURL() {
        return BrowserFactory.getSafariDriver().getCurrentUrl();
    }
}

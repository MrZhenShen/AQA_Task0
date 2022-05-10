package task_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();

    public static WebDriver getSafariDriver() {
        if(INSTANCE.get() == null) {
            INSTANCE.set(new SafariDriver());
        }
        return INSTANCE.get();
    }
    public static WebDriver getChromeDriver() {
        if(INSTANCE.get() == null) {
            System.setProperty("webdriver.chrome.driver", "driver" + File.separator + "chromedriver");
            INSTANCE.set(new ChromeDriver());
        }
        return INSTANCE.get();
    }
}

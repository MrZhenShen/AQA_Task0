package testFramework.duolingoUI.util;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();

    public static WebDriver setupSafariDriver() {
        if(INSTANCE.get() == null) {
            INSTANCE.set(new SafariDriver());
        }
        return INSTANCE.get();
    }

    public static WebDriver setupChromeDriver() {
        if(INSTANCE.get() == null) {
            ChromeDriverManager.getInstance().setup();
            INSTANCE.set(new ChromeDriver());
        }
        return INSTANCE.get();
    }

    public static WebDriver getWebDriver() {
        if(INSTANCE.get() == null) {
            System.err.println("Web Driver was not set");
            throw new WebDriverException();
        }
        return INSTANCE.get();
    }
}

package task_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();

    public static WebDriver getSafariDriver() {
        if(INSTANCE.get() == null) {
            INSTANCE.set(new SafariDriver());
        }
        return INSTANCE.get();
    }
}

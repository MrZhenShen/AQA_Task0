package testFramework.duolingoUI.decorator;

import testFramework.duolingoUI.util.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DecorElement {
    WebElement webElement;

    public DecorElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMe() {
        new WebDriverWait(BrowserFactory.getWebDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(webElement))
                .isEnabled();
    }

    public String getAttribute(String attribute) {
        return webElement.getAttribute(attribute);
    }

    public boolean isEnable() {
        return webElement.isEnabled();
    }
}

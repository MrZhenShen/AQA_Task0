package duolingoTestFramework.decorator;

import duolingoTestFramework.util.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.function.Consumer;

public class DecorElement {
    WebElement webElement;

    public DecorElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMeVisible(long timesOutInMS) {
        long start = new Date().getTime();
        while (!webElement.isDisplayed() && new Date().getTime() - start < timesOutInMS) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Wait for [%s]\n", webElement);
        }
    }

    public void waitForMe() {
        new WebDriverWait(BrowserFactory.getSafariDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(webElement))
                .isEnabled();
//        measureTime(start -> {
//            Wait wait = new FluentWait(BrowserFactory.getSafariDriver())
//                    .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
//                    .pollingEvery(Duration.of(10, ChronoUnit.SECONDS))
//                    .ignoring(Exception.class);
//            webElement = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
//        });
    }

    private void measureTime(Consumer<Long> apply) {
        long start = new Date().getTime();
        apply.accept(start);
        System.out.printf("Wait: %sms\n", new Date().getTime() - start);
    }

    public String getAttribute(String attribute) {
        return webElement.getAttribute(attribute);
    }

    public boolean isEnable() {
        return webElement.isEnabled();
    }
}

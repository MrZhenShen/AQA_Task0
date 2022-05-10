package task_12.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import task_12.BrowserFactory;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

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
        measureTime(start -> {
            Wait wait = new FluentWait(BrowserFactory.getSafariDriver())
                    .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                    .pollingEvery(Duration.of(10, ChronoUnit.SECONDS))
                    .ignoring(Exception.class);
            webElement = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
        });
    }

    private void measureTime(Consumer<Long> apply) {
        long start = new Date().getTime();
        apply.accept(start);
        System.out.printf("Wait: %sms\n", new Date().getTime() - start);
    }
}

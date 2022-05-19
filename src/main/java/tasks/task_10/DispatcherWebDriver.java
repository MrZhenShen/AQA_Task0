package tasks.task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DispatcherWebDriver {
    static WebDriver driver = new SafariDriver();
    static WebElement element;

    public static void main(String[] args) {
        try {
            driver.get("https://www.duolingo.com/");

            auth("mrzhenshen@gmail.com", "union1908");
            System.out.println("next");
            takeTask();
            play();

        } finally {
            driver.close();
        }
    }

    static void auth(String login, String password) {
        click("//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button");

        sendKeys("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[1]/label/div/input", login, 20);
        sendKeys("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[2]/label/div[1]/input", password, 20);

        click("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/button");
    }

    public static void takeTask() {
        click("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div", 20);
        click("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div[1]/div[5]/a[2]");
    }

    private static void play() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/span/div")))
                .isEnabled();
        String xPathSentence = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/span/div";
        List<WebElement> elements = driver.findElements(By.xpath(xPathSentence));
        System.out.println("Sentence size: " + elements.size());

        StringBuilder sentence = new StringBuilder();

        for (int wordsIndex = 1; wordsIndex < elements.size() + 1; wordsIndex++) {
            element = driver.findElement(By.xpath(xPathSentence + "[" + wordsIndex + "]"));
            sentence.append(element.getText()).append(" ");
        }

        System.out.println(sentence);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/textarea"))
                .sendKeys(sentence);

        driver.findElement(By.xpath("//*[@id=\"session/PlayerFooter\"]/div/div[2]/button"))
                .click();
    }


    static void click(String xPath, int maxDelay) {
        new WebDriverWait(driver, Duration.ofSeconds(maxDelay))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
                .isEnabled();
        driver.findElement(By.xpath(xPath))
                .click();
    }

    static void click(String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
                .isEnabled();
        driver.findElement(By.xpath(xPath))
                .click();
    }

    static void sendKeys(String xPath, String text, int maxDelay) {
        new WebDriverWait(driver, Duration.ofSeconds(maxDelay))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
                .isEnabled();
        driver.findElement(By.xpath(xPath))
                .sendKeys(text);
    }
}
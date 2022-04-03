package task_10;

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

            auth(" ", " ");
            System.out.println("next");
            takeTask();
            play();

        } finally {
            driver.close();
        }
    }

    public static void auth(String login, String password) {
        String loginXPath = "//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginXPath))).isEnabled();
        driver.findElement(By.xpath(loginXPath))
                .click();

        driver.findElement(By.xpath("//*[@id=\"overlays\"]/div[5]/div/div/form/div[1]/div[1]/div[1]/label/div/input"))
                .sendKeys(login);

        driver.findElement(By.xpath("//*[@id=\"overlays\"]/div[5]/div/div/form/div[1]/div[1]/div[2]/label/div[1]/input"))
                .sendKeys(password);

        driver.findElement(By.xpath("//*[@id=\"overlays\"]/div[5]/div/div/form/div[1]/button"))
                .click();
    }

    public static void takeTask() {
        String quizXPath = "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div";
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(quizXPath)))
                .isEnabled();
        driver.findElement(By.xpath(quizXPath))
                .click();

        String takeQuizBtnXPath = "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div[1]/div[5]/a[2]";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(takeQuizBtnXPath)))
                .isEnabled();
        driver.findElement(By.xpath(takeQuizBtnXPath))
                .click();
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
}
package task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ElementTest {
    WebDriver driver;

    @BeforeSuite
    void init() {
        driver = new SafariDriver();
        driver.get("https://www.duolingo.com/");
    }

    @AfterSuite
    void end() {
        driver.close();
    }

    @DataProvider
    Object[][] xPathProvider() {
        return new Object[][]{
                {"//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button"},
                {"//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[1]/a"},
                {"//*[@id=\"root\"]/div/div/div[1]/div/div"},
                {"//*[@id=\"root\"]/div/div/div[1]/div/a"}
        };
    }

    @Test(dataProvider = "xPathProvider")
    void elementTest(String xPath) {
        Assert.assertTrue(driver.findElement(By.xpath(xPath)).isEnabled(), "No such xPath");
    }

    @Test
    void validateTest() {
        auth("mrzhenshen@gmail.com", "union1908");
        String quizXPath = "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div";
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(quizXPath)))
                .isEnabled();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.duolingo.com/learn", "invalid result URL");
    }

    void auth(String login, String password) {
        click("//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button");

        sendKeys("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[1]/label/div/input", login, 20);
        sendKeys("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[2]/label/div[1]/input", password, 20);

        click("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/button");
    }

    void click(String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))).isEnabled();
        driver.findElement(By.xpath(xPath))
                .click();
    }

    void sendKeys(String xPath, String text, int maxDelay) {
        new WebDriverWait(driver, Duration.ofSeconds(maxDelay))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))).isEnabled();
        driver.findElement(By.xpath(xPath))
                .sendKeys(text);
    }
}

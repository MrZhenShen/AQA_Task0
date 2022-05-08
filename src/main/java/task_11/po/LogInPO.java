package task_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPO {
    private final WebDriver driver;

    public LogInPO(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLogin(String login) {
        sendKeys("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[1]/label/div/input", login, 20);
    }

    public void fillPassword(String password) {
        sendKeys("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[2]/label/div[1]/input", password, 20);
    }

    public LearnDashboardPO clickLogIn() {
        click("//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/button");
        return new LearnDashboardPO(driver);
    }

    void sendKeys(String xPath, String text, int maxDelay) {
        new WebDriverWait(driver, Duration.ofSeconds(maxDelay))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
                .isEnabled();
        driver.findElement(By.xpath(xPath))
                .sendKeys(text);
    }

    void click(String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
                .isEnabled();
        driver.findElement(By.xpath(xPath))
                .click();
    }
}

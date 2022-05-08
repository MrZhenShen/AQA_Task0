package task_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePO {
    private final WebDriver driver;

    public WelcomePO(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.duolingo.com/");
    }

    public LogInPO clickLogIn() {
        click("//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button");
        return new LogInPO(driver);
    }

    void click(String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
                .isEnabled();
        driver.findElement(By.xpath(xPath))
                .click();
    }
}

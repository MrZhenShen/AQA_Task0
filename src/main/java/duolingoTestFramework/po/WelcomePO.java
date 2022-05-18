package duolingoTestFramework.po;

import duolingoTestFramework.decorator.ButtonElement;
import duolingoTestFramework.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePO {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button")
    private ButtonElement logInButton;

    public WelcomePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
        driver.get("https://www.duolingo.com/");
    }

    public LogInPO clickLogIn() {
        logInButton.click();
        return new LogInPO(driver);
    }
}

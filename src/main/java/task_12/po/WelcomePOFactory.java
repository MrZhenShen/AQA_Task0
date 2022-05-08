package task_12.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task_12.decorator.ButtonElement;
import task_12.decorator.MyFieldDecorator;

public class WelcomePOFactory {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button")
    private ButtonElement logInButton;

    public WelcomePOFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
        driver.get("https://www.duolingo.com/");
    }

    public LogInPOFactory clickLogIn() {
        logInButton.click();
        return new LogInPOFactory(driver);
    }
}

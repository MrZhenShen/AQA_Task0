package duolingoTestFramework.po;

import duolingoTestFramework.decorator.ButtonElement;
import duolingoTestFramework.decorator.InputElement;
import duolingoTestFramework.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPO {
    private final WebDriver driver;

    public LogInPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[1]/label/div/input")
    private InputElement loginInput;

    @FindBy(xpath = "//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/div[1]/div[2]/label/div[1]/input")
    private InputElement passwordInput;

    @FindBy(xpath = "//*[@id=\"overlays\"]/div[4]/div/div/form/div[1]/button")
    private ButtonElement logInButton;

    public void fillLogin(String login) {
        loginInput.input(login);
    }

    public void fillPassword(String password) {
        passwordInput.input(password);
    }

    public LearnDashboardPO clickLogIn() {
        logInButton.click();
        return new LearnDashboardPO(driver);
    }

}

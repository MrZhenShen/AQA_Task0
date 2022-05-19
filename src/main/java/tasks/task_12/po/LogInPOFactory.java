package tasks.task_12.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tasks.task_12.decorator.ButtonElement;
import tasks.task_12.decorator.InputElement;
import tasks.task_12.decorator.MyFieldDecorator;

public class LogInPOFactory {
    private final WebDriver driver;

    public LogInPOFactory(WebDriver driver) {
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

    public LearnDashboardPOFactory clickLogIn() {
        logInButton.click();
        return new LearnDashboardPOFactory(driver);
    }

}

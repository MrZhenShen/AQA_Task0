package testFramework.duolingoUI.bo;

import testFramework.duolingoUI.po.LogInPO;
import testFramework.duolingoUI.po.WelcomePO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AuthBO {
    private final WebDriver driver;
    private WelcomePO welcomePO;
    private LogInPO logInPO;

    public AuthBO(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public AuthBO goToDuolingo() {
        welcomePO = new WelcomePO(driver);
        return this;
    }

    @Step
    public AuthBO goToLogIn() {
        logInPO = welcomePO.clickLogIn();
        return this;
    }

    @Step
    public AuthBO fillLogin(String login) {
        logInPO.fillLogin(login);
        return this;
    }

    @Step
    public AuthBO fillPassword(String password) {
        logInPO.fillPassword(password);
        return this;
    }

    @Step
    public DashboardBO clickLogIn() {
        logInPO.clickLogIn();
        return new DashboardBO(driver);
    }
}

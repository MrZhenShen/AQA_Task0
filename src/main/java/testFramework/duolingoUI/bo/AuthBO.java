package testFramework.duolingoUI.bo;

import testFramework.duolingoUI.po.LearnDashboardPO;
import testFramework.duolingoUI.po.LogInPO;
import testFramework.duolingoUI.po.WelcomePO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AuthBO {
    private final WebDriver driver;
    private WelcomePO welcomePO;
    private LogInPO logInPO;
    private LearnDashboardPO learnDashboardPO;

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
    public AuthBO clickLogIn() {
        learnDashboardPO = logInPO.clickLogIn();
        return this;
    }

    @Step
    public void validateLogIn() {
        Assert.assertEquals(learnDashboardPO.getPageTitle(), "Duolingo - Найкращий у світі спосіб вивчити англійську мову", "Unsuccessful auth");
    }
}

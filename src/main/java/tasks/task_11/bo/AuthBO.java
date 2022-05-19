package tasks.task_11.bo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tasks.task_11.po.LearnDashboardPO;
import tasks.task_11.po.LogInPO;
import tasks.task_11.po.WelcomePO;

public class AuthBO {
    private final WebDriver driver;
    private WelcomePO welcomePO;
    private LogInPO logInPO;
    private LearnDashboardPO learnDashboardPO;

    public AuthBO(WebDriver driver) {
        this.driver = driver;
    }

    public AuthBO goToDuolingo() {
        welcomePO = new WelcomePO(driver);
        return this;
    }

    public AuthBO goToLogIn() {
        logInPO = welcomePO.clickLogIn();
        return this;
    }

    public AuthBO fillLogin(String login) {
        logInPO.fillLogin(login);
        return this;
    }

    public AuthBO fillPassword(String password) {
        logInPO.fillPassword(password);
        return this;
    }

    public AuthBO clickLogIn() {
        learnDashboardPO = logInPO.clickLogIn();
        return this;
    }

    public void validateLogIn() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(learnDashboardPO.getPageTitle(), "Duolingo - The world's best way to learn Polish", "unsuccessful auth");
    }
}

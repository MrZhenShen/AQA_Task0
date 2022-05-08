package task_12.bo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import task_12.po.LearnDashboardPOFactory;
import task_12.po.LogInPOFactory;
import task_12.po.WelcomePOFactory;

public class AuthBOFactory {
    private final WebDriver driver;
    private WelcomePOFactory welcomePO;
    private LogInPOFactory logInPO;
    private LearnDashboardPOFactory learnDashboardPO;

    public AuthBOFactory(WebDriver driver) {
        this.driver = driver;
    }

    public AuthBOFactory goToDuolingo() {
        welcomePO = new WelcomePOFactory(driver);
        return this;
    }

    public AuthBOFactory goToLogIn() {
        logInPO = welcomePO.clickLogIn();
        return this;
    }

    public AuthBOFactory fillLogin(String login) {
        logInPO.fillLogin(login);
        return this;
    }

    public AuthBOFactory fillPassword(String password) {
        logInPO.fillPassword(password);
        return this;
    }

    public AuthBOFactory clickLogIn() {
        learnDashboardPO = logInPO.clickLogIn();
        return this;
    }

    public void validateLogIn() {
        Assert.assertEquals(learnDashboardPO.getPageTitle(), "Duolingo - The world's best way to learn Polish", "Unsuccessful auth");
    }
}

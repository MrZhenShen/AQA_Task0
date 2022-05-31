package testFramework.duolingoUI.bo;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import testFramework.duolingoUI.po.CoachPO;

public class SettingsBO {
    private final WebDriver driver;
    private CoachPO coachPO;

    private int xpExpected;

    public SettingsBO(WebDriver driver) {
        this.driver = driver;
    }

    public int getXpExpected() {
        return xpExpected;
    }

    @Step
    public SettingsBO selectGoal(String name) {
        coachPO = new CoachPO(driver);
        xpExpected = coachPO.clickOnGoal(name);
        return this;
    }

    @Step
    public SettingsBO save() {
        coachPO.clickSave();
        return this;
    }

    @Step
    public void goToDashboard() {
        coachPO.clickHomePage();
    }
}

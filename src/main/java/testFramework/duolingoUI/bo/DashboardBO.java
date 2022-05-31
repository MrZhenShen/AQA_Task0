package testFramework.duolingoUI.bo;

import io.qameta.allure.Step;
import testFramework.duolingoUI.po.LearnDashboardPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardBO {
    private final WebDriver driver;
    private LearnDashboardPO learnDashboardPO;

    public DashboardBO(WebDriver driver) {
        this.driver = driver;
        learnDashboardPO = new LearnDashboardPO(driver);
    }

    @Step
    public SettingsBO goToCoachPage() {
        learnDashboardPO.clickEditGoal();
        return new SettingsBO(driver);
    }

    @Step
    public DashboardBO selectQuiz(String quizTitle) {
        learnDashboardPO.clickQuiz(quizTitle);
        return this;
    }

    @Step
    public QuizBO takeQuiz() {
        learnDashboardPO.selectQuizMode();
        return new QuizBO(driver);
    }

    @Step
    public void validateLogIn() {
        Assert.assertTrue(learnDashboardPO.isHeaderDisplayed(), "Unsuccessful auth");
    }

    @Step
    public void validateGoal(int expectedXP) {
        Assert.assertEquals(learnDashboardPO.getGoal(), expectedXP, "Unexpected goal");
    }

    @Step
    public void validateQuizExistence(String quizTitle) {
        Assert.assertTrue(learnDashboardPO.findQuiz(quizTitle), "Such [" + quizTitle + "] does not exist");
    }
}

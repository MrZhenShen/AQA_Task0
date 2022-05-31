package testFramework.duolingoUI;

import testFramework.duolingoUI.bo.AuthBO;
import testFramework.duolingoUI.bo.DashboardBO;
import testFramework.duolingoUI.bo.QuizBO;
import testFramework.duolingoUI.bo.SettingsBO;
import testFramework.duolingoUI.listener.SuiteListener;
import testFramework.duolingoUI.listener.TestListener;
import testFramework.duolingoUI.util.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testFramework.duolingoUI.listener.AllureListener;

import static testFramework.credentials.DuolingoCredentials.*;

@Listeners({
        AllureListener.class,
        TestListener.class,
        SuiteListener.class
})
public class DuolingoTest {
    private WebDriver driver;

    private AuthBO authBO;
    private DashboardBO dashboardBO;
    private SettingsBO settingsBO;
    private QuizBO quizBO;

    @BeforeSuite
    void init() {
        driver = BrowserFactory.getSafariDriver();
    }

    @AfterSuite
    void end() {
        driver.close();
    }

    @Test
    void authTest() {
        authBO = new AuthBO(driver);

        dashboardBO = authBO
                .goToDuolingo()
                .goToLogIn()
                .fillLogin(LOGIN.data)
                .fillPassword(PASSWORD.data)
                .clickLogIn();

        dashboardBO
                .validateLogIn();
    }

    @Test(dependsOnMethods = "authTest")
    void changeGoal() {
        settingsBO = dashboardBO
                .goToCoachPage();

        settingsBO
                .selectGoal("Regular")
                .save()
                .goToDashboard();

        dashboardBO
                .validateGoal(settingsBO.getXpExpected());
    }

    @Test(dependsOnMethods = "changeGoal")
    void findQuizTest() {
        dashboardBO
                .validateQuizExistence("Basics 1");
    }

    @Test(dependsOnMethods = "findQuizTest")
    void checkQuizTypes() {
        quizBO = dashboardBO
                .selectQuiz("Basics 1")
                .takeQuiz();

        quizBO.validateDiffQuizTypes(10);
    }

    @Test(dependsOnMethods = "checkQuizTypes")
    void isEnableAnswerInputAfterSkipTest() {
        quizBO
                .skipTask()
                .validateIsEnableAnswerInput();
    }

    @Test(dependsOnMethods = "isEnableAnswerInputAfterSkipTest")
    void languageQuizTest() {
        quizBO
                .goToNextTask()
                .readTask()
                .checkLanguage()
                .translate()
                .fillAnswer()
                .submitAnswer()
                .validateCorrectAnswer();
    }
}

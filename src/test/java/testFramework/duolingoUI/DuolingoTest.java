package testFramework.duolingoUI;

import testFramework.credentials.CredentialsFileReader;
import testFramework.credentials.DuolingoCredentials;
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
import testFramework.duolingoUI.util.QuizType;

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

    private String skill;
    private String goal;

    @BeforeSuite
    void init() {
        goal = System.getProperty("goal", "Basic");
        skill = System.getProperty("skill", "Basics 1");
        CredentialsFileReader.setupCredentials(DuolingoCredentials.class);
        driver = BrowserFactory.setupSafariDriver();
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
                .selectGoal(goal)
                .save()
                .goToDashboard();

        dashboardBO
                .validateGoal(settingsBO.getXpExpected());
    }

    @Test(dependsOnMethods = "changeGoal")
    void findQuizTest() {
        dashboardBO.validateQuizExistence(skill);
    }

    @Test(dependsOnMethods = "findQuizTest")
    void languageQuizTest() {
        quizBO = dashboardBO
                .selectQuiz(skill)
                .takeQuiz();

        quizBO
                .goToNextTask(QuizType.TRANSLATE)
                .readTask()
                .checkLanguage()
                .translate()
                .fillAnswer()
                .submitAnswer()
                .validateCorrectAnswer();
    }

    @Test(dependsOnMethods = "languageQuizTest")
    void checkQuizTypes() {
        quizBO
                .goToNextTask()
                .validateDiffQuizTypes(10);
    }

    @Test(dependsOnMethods = "checkQuizTypes")
    void isEnableAnswerInputAfterSkipTest() {
        quizBO.validateIsDisableAnswerInput();
    }
}

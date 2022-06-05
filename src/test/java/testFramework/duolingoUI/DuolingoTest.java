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
import testFramework.duolingoUI.util.QuizType;
import testFramework.hibernate.HibernateClient;
import testFramework.model.DuolingoCred;

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

    @DataProvider
    private Object[][] credentials() {
        int id = 0;
        try {
            id = Integer.parseInt(System.getProperty("credId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        DuolingoCred duolingoCred = HibernateClient.read(DuolingoCred.class, id);

        return new Object[][]
                {
                        {duolingoCred.getLogin(), duolingoCred.getPassword()}
                };
    }

    @BeforeSuite
    void init() {
        goal = System.getProperty("goal", "Basic");
        skill = System.getProperty("skill", "Basics 1");
        driver = BrowserFactory.setupSafariDriver();
    }

    @AfterSuite
    void end() {
        driver.close();
    }

    @Test(dataProvider = "credentials")
    void authTest(String[] credentials) {
        authBO = new AuthBO(driver);

        dashboardBO = authBO
                .goToDuolingo()
                .goToLogIn()
                .fillLogin(credentials[0])
                .fillPassword(credentials[1])
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

package duolingoTestFramework;

import duolingoTestFramework.bo.AuthBO;
import duolingoTestFramework.bo.DashboardBO;
import duolingoTestFramework.bo.QuizBO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DuolingoTest {
    WebDriver driver;

    @BeforeTest
    void init() {
        driver = BrowserFactory.getSafariDriver();
    }

    @AfterTest
    void end() {
        driver.close();
    }

    @DataProvider
    Object[][] credentials() {
        return new Object[][] {
                {"mrzhenshen@gmail.com", "union1908"}
        };
    }

    @Test(dataProvider = "credentials")
    void authTest(String[] credentials) {
        AuthBO authBO = new AuthBO(driver);

        authBO.goToDuolingo()
                .goToLogIn()
                .fillLogin(credentials[0])
                .fillPassword(credentials[1])
                .clickLogIn()
                .validateLogIn();
    }

    @Test(dataProvider = "credentials")
    void findQuizTest(String[] credentials) {
        AuthBO authBO = new AuthBO(driver);

        authBO.goToDuolingo()
                .goToLogIn()
                .fillLogin(credentials[0])
                .fillPassword(credentials[1])
                .clickLogIn();

        DashboardBO dashboardBO = new DashboardBO(driver);
        dashboardBO.printQuizzes()
                .validateQuizExistence("Basics 1");
    }

    @Test(dataProvider = "credentials")
    void languageQuizTest(String[] credentials) {
        AuthBO authBO = new AuthBO(driver);

        authBO.goToDuolingo()
                .goToLogIn()
                .fillLogin(credentials[0])
                .fillPassword(credentials[1])
                .clickLogIn();

        DashboardBO dashboardBO = new DashboardBO(driver);
        dashboardBO
                .initDashboardPage()
                .selectQuiz("Basics 1")
                .takeQuiz();

        QuizBO quizBO = new QuizBO(driver);
        quizBO
                .initQuizPage()
                .readTask()
                .checkLanguage()
                .translate()
                .fillAnswer()
                .submitAnswer()
                .validateCorrectAnswer();
    }

    @Test(dataProvider = "credentials")
    void isEnableAnswerInputAfterSkipTest(String[] credentials) {
        AuthBO authBO = new AuthBO(driver);

        authBO.goToDuolingo()
                .goToLogIn()
                .fillLogin(credentials[0])
                .fillPassword(credentials[1])
                .clickLogIn();

        DashboardBO dashboardBO = new DashboardBO(driver);
        dashboardBO
                .initDashboardPage()
                .selectQuiz("Basics 1")
                .takeQuiz();

        QuizBO quizBO = new QuizBO(driver);
        quizBO
                .initQuizPage()
                .skipTask()
                .validateIsEnableAnswerInput();
    }
}

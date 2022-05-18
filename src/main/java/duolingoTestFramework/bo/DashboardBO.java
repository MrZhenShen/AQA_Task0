package duolingoTestFramework.bo;

import duolingoTestFramework.po.LearnDashboardPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DashboardBO {
    private final WebDriver driver;
    private LearnDashboardPO learnDashboardPO;
    private List<WebElement> quizList;

    public DashboardBO(WebDriver driver) {
        this.driver = driver;
    }

    public DashboardBO initDashboardPage() {
        learnDashboardPO = new LearnDashboardPO(driver);
        return this;
    }

    public DashboardBO selectQuiz(String quizTitle) {
        learnDashboardPO.clickQuiz(quizTitle);
        return this;
    }

    public DashboardBO takeQuiz() {
        learnDashboardPO.selectQuizMode();
        return this;
    }

    public DashboardBO printQuizzes() {
        quizList = learnDashboardPO.getQuizzesList();
        quizList.forEach(skill -> System.out.print(skill.getText() + ", "));
        return this;
    }

    public void validateQuizExistence(String quizTitle) {
        Assert.assertTrue(learnDashboardPO.findQuiz(quizTitle), "Such [" + quizTitle + "] does not exist");
    }
}

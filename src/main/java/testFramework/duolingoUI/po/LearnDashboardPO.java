package testFramework.duolingoUI.po;

import testFramework.duolingoUI.decorator.ButtonElement;
import testFramework.duolingoUI.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class LearnDashboardPO {
    private final WebDriver driver;

    public LearnDashboardPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @FindBy(className = "_1888P")
    private List<WebElement> skills;

    @FindBy(css = "#root > div > div._3W86r._1Xlh1 > div > div > div._33Mo9 > div._2PVaI > div > div._3YEom > div:nth-child(1) > div > div:nth-child(1) > div > div._3uS_y.eIZ_c > div > div._1KUxv._1GJUD._3lagd._1HSah > div._2I_Id > a")
    private List<WebElement> startButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]")
    private WebElement header;

    @FindBy(css = "#root > div > div._3W86r._1Xlh1 > div > div > div._1YfQ8 > div._2O43A._3ZuGY > div > div._1K5oY._23dOD > a")
    private ButtonElement editGoalButton;

    @FindBy(css = "#root > div > div._3W86r._1Xlh1 > div > div > div._1YfQ8 > div._2O43A._3ZuGY > div > div.dx6CP > div._3XQNj > div.MEmKK > div._15-md")
    private WebElement goalXP;

    public List<WebElement> getQuizzesList() {
        waitEnable(skills);
        return skills;
    }

    public boolean findQuiz(String quizTitle) {
        for (WebElement quiz : skills) {
            if (quiz.getText().equals(quizTitle)) {
                return true;
            }
        }
        return false;
    }

    public void clickQuiz(String quizTitle) {
        waitEnable(skills);
        for (WebElement skill : skills) {
            if (skill.getText().equals(quizTitle)) {
                skill.click();
            }
        }
    }

    public boolean isHeaderDisplayed() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return header.isDisplayed();
    }

    private void waitEnable(List<WebElement> elements) {
        while (elements.size() == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectQuizMode() {
        waitEnable(startButton);
        for(WebElement btn : startButton) {
            if(Objects.equals(btn.getAttribute("data-test"), "start-button")) {
                btn.click();
            }
        }
    }

    public void clickEditGoal() {
        editGoalButton.click();
    }

    public int getGoal() {
        return Integer.parseInt(goalXP.getText().split("[\\s/]")[1]);
    }
}

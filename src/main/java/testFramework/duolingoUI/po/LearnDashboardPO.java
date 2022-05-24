package testFramework.duolingoUI.po;

import testFramework.duolingoUI.decorator.ButtonElement;
import testFramework.duolingoUI.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LearnDashboardPO {
    private final WebDriver driver;

    public LearnDashboardPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @FindBy(className = "_1888P")
    private List<WebElement> skills;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div[1]/div[5]/a[2]")
    private ButtonElement startButton;

    public String getPageTitle() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public List<WebElement> getQuizzesList() {
        waitEnable();
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
        waitEnable();
        for (WebElement skill : skills) {
            if (skill.getText().equals(quizTitle)) {
                skill.click();
            }
        }
    }

    private void waitEnable() {
        while (skills.size() == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectQuizMode() {
        startButton.click();
    }
}

package testFramework.duolingoUI.bo;

import io.qameta.allure.Step;
import testFramework.duolingoUI.util.Translator;
import testFramework.duolingoUI.po.QuizPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class QuizBO {
    private final WebDriver driver;
    private QuizPO quizPO;

    private String fromText;
    private String translatedText = "";
    private String targetLanguage = "en";

    public QuizBO(WebDriver driver) {
        this.driver = driver;
        quizPO = new QuizPO(driver);
    }

    @Step
    public QuizBO readTask() {
        fromText = quizPO.readTask();
        return this;
    }

    @Step
    public QuizBO checkLanguage() {
        targetLanguage = quizPO.checkLanguage();
        return this;
    }

    @Step
    public QuizBO translate() {
        translatedText = Translator.translate(fromText, targetLanguage);
        return this;
    }

    @Step
    public QuizBO fillAnswer() {
        while (translatedText.equals("")) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        quizPO.fillAnswer(translatedText);
        return this;
    }

    @Step
    public QuizBO submitAnswer() {
        quizPO.clickCheck();
        translatedText = "";
        return this;
    }

    @Step
    public QuizBO skipTask() {
        quizPO.clickSkip();
        return this;
    }

    @Step
    public QuizBO goToNextTask() {
        quizPO.clickContinue();
        return this;
    }

    @Step
    public void validateDiffQuizTypes(int quizAmount) {
        Assert.assertNotEquals(quizPO.getQuizTypesInSkill(quizAmount).size(), 1, "All quizzes in skill were the same");
    }

    @Step
    public void validateCorrectAnswer() {
        Assert.assertTrue(quizPO.isAnswerCorrect(), "Incorrect quiz sentence:\nFrom\t" + fromText + "\nTo\t" + translatedText);
    }

    @Step
    public void validateIsEnableAnswerInput() {
        Assert.assertFalse(quizPO.isEnableAnswerInput(), "User is able to type an answer after seeing correct answer after skip task");
    }
}

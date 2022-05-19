package duolingoTestFramework.bo;

import duolingoTestFramework.util.Translator;
import duolingoTestFramework.po.QuizPO;
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
    }

    public QuizBO initQuizPage() {
        quizPO = new QuizPO(driver);
        return this;
    }

    public QuizBO readTask() {
        fromText = quizPO.readTask();
        return this;
    }

    public QuizBO checkLanguage() {
        targetLanguage = quizPO.checkLanguage();
        return this;
    }

    public QuizBO translate() {
        translatedText = Translator.translate(fromText, targetLanguage);
        return this;
    }

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

    public QuizBO submitAnswer() {
        quizPO.clickCheck();
        translatedText = "";
        return this;
    }

    public QuizBO skipTask() {
        quizPO.clickSkip();
        return this;
    }

    public QuizBO goToNextTask() {
        quizPO.clickContinue();
        return this;
    }

    public void validateCorrectAnswer() {
        Assert.assertTrue(quizPO.isAnswerCorrect(), "Incorrect quiz sentence:\nFrom\t" + fromText + "\nTo\t" + translatedText);
    }

    public void validateIsEnableAnswerInput() {
        Assert.assertFalse(quizPO.isEnableAnswerInput(), "User is able to type an answer after seeing correct answer after skip task");
    }
}

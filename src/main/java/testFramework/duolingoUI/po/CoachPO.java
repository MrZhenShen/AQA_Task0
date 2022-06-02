package testFramework.duolingoUI.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testFramework.duolingoUI.decorator.ButtonElement;
import testFramework.duolingoUI.decorator.MyFieldDecorator;

import java.util.List;
import java.util.Objects;

public class CoachPO {
    private final WebDriver driver;

    public CoachPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @FindBy(css = "#root > div > div._3W86r._1Xlh1 > div > div._33Mo9 > div._2PVaI > div > div._2Pkxr > div > label")
    private List<WebElement> goals;

    @FindBy(css = "#root > div > div._3W86r._1Xlh1 > div > div._33Mo9 > div._2PVaI > div > div._Bmuv > button")
    private ButtonElement saveButton;

    @FindBy(css = "#root > div > div._3W86r._1Xlh1 > div > div._33Mo9 > div._2PVaI > div > div._Bmuv > button > span")
    private WebElement saveButtonText;

    @FindBy(css = "a[data-test=\"home-nav\"]")
    private ButtonElement homePageButton;

    public int clickOnGoal(String name) {
        waitEnable(goals, 5);
        for (WebElement goal : goals) {
            List<WebElement> goalSpans = goal.findElements(By.tagName("span"));
            if (goalSpans.get(0).getText().equals(name)) {
                if (goal.findElement(By.tagName("input")).isSelected()) {
                    System.out.printf("Goal [%s] is already selected\n", name);
                    throw new IllegalArgumentException();
                }
                goal.click();
                return Integer.parseInt(goalSpans.get(1).getText().split("\\s")[0]);
            }
        }
        return -1;
    }

    private void waitEnable(List<WebElement> elements, int timeout) {
        int seconds = 0;
        while (elements.size() == 0 & seconds++ < timeout) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickSave() {
        saveButton.click();
        while (!Objects.equals(saveButtonText.getText(), "Changes saved")) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickHomePage() {
        homePageButton.click();
    }
}

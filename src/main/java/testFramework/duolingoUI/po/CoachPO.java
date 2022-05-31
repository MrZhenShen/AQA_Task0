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

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/div[1]/div/div[2]/div/label")
    private List<WebElement> goals;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/div[1]/div/div[1]/button")
    private ButtonElement saveButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/div[1]/div/div[1]/button/span")
    private WebElement saveButtonText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div[2]/div[1]/a")
    private ButtonElement homePageButton;

    public int clickOnGoal(String name) {
        waitEnable(goals, 5);
        for (WebElement goal : goals) {
            String goalDesc = goal.getText();
            if (goalDesc.startsWith(name)) {
                if (goal.findElement(By.tagName("input")).isSelected()) {
                    System.out.printf("Goal [%s] is already selected\n", name);
                    throw new IllegalArgumentException();
                }
                goal.click();
                return Integer.parseInt(goalDesc.split(" ")[0].substring(name.length()));
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

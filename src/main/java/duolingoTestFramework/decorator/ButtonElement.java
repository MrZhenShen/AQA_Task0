package duolingoTestFramework.decorator;

import org.openqa.selenium.WebElement;

public class ButtonElement extends DecorElement {

    public ButtonElement(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        waitForMe();
        System.out.printf("Try click [%s]\n", webElement.getText());
        webElement.click();
    }

    public String getTitle() {
        waitForMe();
        return webElement.getText();
    }
}

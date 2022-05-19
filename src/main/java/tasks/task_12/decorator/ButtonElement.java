package tasks.task_12.decorator;

import org.openqa.selenium.WebElement;

public class ButtonElement extends DecorElement {

    public ButtonElement(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        System.out.printf("Try click [%s]\n", webElement.getText());
        waitForMe();
        webElement.click();
    }
}

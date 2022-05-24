package testFramework.duolingoUI.decorator;

import org.openqa.selenium.WebElement;

public class InputElement extends DecorElement {

    public InputElement(WebElement webElement) {
        super(webElement);
    }

    public void input(String text) {
        System.out.printf("Try input text [\"%s\"] to [%s]\n", text, webElement.getAttribute("placeholder"));
        waitForMe();
        webElement.sendKeys(text);
    }
}

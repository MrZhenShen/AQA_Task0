package testFramework.duolingoUI.decorator;

import org.openqa.selenium.WebElement;

public class InputElement extends DecorElement {

    public InputElement(WebElement webElement) {
        super(webElement);
    }

    public void input(String text) {
        waitForMe();
        System.out.printf("Try input text [\"%s\"] to [%s]\n", text, webElement.getAttribute("placeholder"));
        webElement.sendKeys(text);
    }
}

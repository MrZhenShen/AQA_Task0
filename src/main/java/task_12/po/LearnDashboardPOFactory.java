package task_12.po;

import org.openqa.selenium.WebDriver;

public class LearnDashboardPOFactory {
    private final WebDriver driver;

    public LearnDashboardPOFactory(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }
}

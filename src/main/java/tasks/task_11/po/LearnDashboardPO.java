package tasks.task_11.po;

import org.openqa.selenium.WebDriver;

public class LearnDashboardPO {
    private final WebDriver driver;

    public LearnDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

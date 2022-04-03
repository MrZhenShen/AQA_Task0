package task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ElementTest {
    static WebDriver driver = new SafariDriver();

    @BeforeSuite
    public static void openPage() {
        driver.get("https://www.duolingo.com/");
    }

    @AfterSuite
    public static void end() {
        driver.close();
    }

    @DataProvider
    public static Object[][] xPathProvider() {
        return new Object[][]{
                {"//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[2]/button"},
                {"//*[@id=\"root\"]/div/div/span[1]/div/div[1]/div[2]/div[1]/a"},
                {"//*[@id=\"root\"]/div/div/div[1]/div/div"},
                {"//*[@id=\"root\"]/div/div/div[1]/div/a"}
        };
    }

    @Test(dataProvider = "xPathProvider")
    void elementTest(String xPath) {
        Assert.assertTrue(driver.findElement(By.xpath(xPath)).isEnabled(), "No such xPath");
    }
}

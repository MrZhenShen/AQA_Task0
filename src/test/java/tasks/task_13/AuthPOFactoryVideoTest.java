package tasks.task_13;

import com.automation.remarks.testng.UniversalVideoListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tasks.task_12.BrowserFactory;
import tasks.task_12.bo.AuthBOFactory;

@Listeners(UniversalVideoListener.class)
public class AuthPOFactoryVideoTest {
    WebDriver driver;

    @BeforeTest
    void init() {
        driver = BrowserFactory.getChromeDriver();
    }

    @AfterTest
    void end() {
        driver.close();
    }

    @Test
    void authTest() {
        AuthBOFactory authBO = new AuthBOFactory(driver);

        authBO.goToDuolingo()
                .goToLogIn()
                .fillLogin("mrzhenshen@gmail.com")
                .fillPassword("union1908")
                .clickLogIn()
                .validateLogIn();
    }
}

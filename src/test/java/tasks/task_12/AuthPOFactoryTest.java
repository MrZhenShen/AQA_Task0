package tasks.task_12;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tasks.task_12.BrowserFactory;
import tasks.task_12.bo.AuthBOFactory;

public class AuthPOFactoryTest {
    WebDriver driver;

    @BeforeTest
    void init() {
        driver = BrowserFactory.getSafariDriver();
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

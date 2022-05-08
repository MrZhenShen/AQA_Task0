package task_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import task_12.bo.AuthBOFactory;

public class AuthPOFactoryTest {
    WebDriver driver;

    @BeforeTest
    void init() {
        driver = new SafariDriver();
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

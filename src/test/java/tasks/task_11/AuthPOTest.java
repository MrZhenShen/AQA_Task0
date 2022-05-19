package tasks.task_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tasks.task_11.bo.AuthBO;

public class AuthPOTest {
    WebDriver driver;

    @BeforeSuite
    void init() {
        driver = new SafariDriver();
    }

    @AfterSuite
    void end() {
        driver.close();
    }

    @Test
    void duolingoTest() {
        AuthBO authBO = new AuthBO(driver);

        authBO.goToDuolingo()
                .goToLogIn()
                .fillLogin("mrzhenshen@gmail.com")
                .fillPassword("union1908")
                .clickLogIn()
                .validateLogIn();
    }
}

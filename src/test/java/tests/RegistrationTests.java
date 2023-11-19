package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationTests extends AppiumConfig {

    int i;
    @BeforeMethod
    public void precondition(){
        i = (int)(System.currentTimeMillis()/1000)%3600;
    }

    @Test
    public void registrationPositive(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("igor_" + i + "@abcd.com")
                .fillPassword("Ig12345$")
                .submitRegistration()
                .assertContactListActivityPresent();
    }

    @Test
    public void registrationPositiveModel(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder()
                        .email("igor_" + i + "@abcd.com")
                        .password("Ig12345$")
                        .build())
                .isContactListActivityPresent();
    }

    @Test
    public void registrationWrongEmail(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("igor_" + i + "abcd.com")
                .fillPassword("Ig12345$")
                .submitRegistrationNegative()
                .isErrorMessageContainsText("email address");
    }

    @Test
    public void registrationWrongPassword(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registrationNegative(Auth.builder()
                        .email("igor_" + i + "@abcd.com")
                        .password("Ig12345")
                        .build())
                .isErrorMessageContainsTextInAlert("password");
    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }

}

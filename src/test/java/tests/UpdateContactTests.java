package tests;

import config.AppiumConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class UpdateContactTests extends AppiumConfig {

    @BeforeSuite
    public void precondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("igor@abcd.com")
                .fillPassword("Ig12345$")
                .submitLogin();
    }

    @Test
    public void updateOneContact(){
        int i = new Random().nextInt(1000) + 1000;
        new ContactListScreen(driver)
                .updateOneContact()
                .updateName("Marisha" + i)
                .submitEditContactForm()
                .isContactContains("Marisha" + i);
    }

}

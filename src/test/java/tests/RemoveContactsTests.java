package tests;

import config.AppiumConfig;
import models.Contact;
import org.testng.annotations.*;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class RemoveContactsTests extends AppiumConfig {

    @BeforeClass
    public void precondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("igor@abcd.com")
                .fillPassword("Ig12345$")
                .submitLogin();
    }

    @BeforeMethod
    public void providerContacts(){
        new ContactListScreen(driver).provideContacts();
    }

    @Test
    public void removeOneContactPositive(){
        new ContactListScreen(driver)
                .removeOneContact()
                .isOneContactRemoved();
    }

    @Test
    public void removeAllContactPositive(){
        new ContactListScreen(driver)
                .removeAllContacts()
                .isNoContacts();
    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver).logout();
    }

}

package tests;

import config.AppiumConfig;
import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    int i;

    @BeforeSuite
    public void precondition(){
        //i = (int)(System.currentTimeMillis()/1000)%3600;
        i = new Random().nextInt(1000) + 1000;
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("igor@abcd.com")
                .fillPassword("Ig12345$")
                .submitLogin();
    }

    @Test(invocationCount = 3)
    public void addNewContactPositive(){
        Contact contact = Contact.builder()
                .name("Sarah" + i)
                .lastName("Conor")
                .email("sarah_" + i + "@mail.com")
                .phone("8765432" + i)
                .address("New York")
                .description("Lower" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAdded(contact);
    }

    @Test
    public void addNewContactNegativeEmptyName(){
        Contact contact = Contact.builder()
                //.name("Sarah" + i)
                .lastName("Conor")
                .email("sarah_" + i + "@mail.com")
                .phone("8765432" + i)
                .address("New York")
                .description("Lower" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageContainsTextInAlert("blank");
    }

    @Test
    public void addNewContactNegativeEmptyPhone(){
        Contact contact = Contact.builder()
                .name("Sarah" + i)
                .lastName("Conor")
                .email("sarah_" + i + "@mail.com")
                //.phone("8765432" + i)
                .address("New York")
                .description("Lower" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorMessageContainsTextInAlert("digits");
    }


}

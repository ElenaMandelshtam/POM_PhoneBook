package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class ViewContactScreen extends BaseScreen{

    public ViewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id="com.sheygam.contactapp:id/nameTxt")
    MobileElement nameText;
    @FindBy(id="com.sheygam.contactapp:id/lastNameTxt")
    MobileElement lastNameText;
    @FindBy(id="com.sheygam.contactapp:id/emailTxt")
    MobileElement emailText;
    @FindBy(id="com.sheygam.contactapp:id/phoneTxt")
    MobileElement phoneText;
    @FindBy(id="com.sheygam.contactapp:id/addressTxt")
    MobileElement addressText;
    @FindBy(id="com.sheygam.contactapp:id/descTxt")
    MobileElement descriptionText;

    public Contact viewContactObject(){
        return Contact.builder()
                .name(nameText.getText())
                .lastName(lastNameText.getText())
                .email(emailText.getText())
                .phone(phoneText.getText())
                .address(addressText.getText())
                .description(descriptionText.getText())
                .build();
    }
}

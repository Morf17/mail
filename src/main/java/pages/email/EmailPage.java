package pages.email;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class EmailPage extends BasePage {

    @FindBy(css = "div[class^='contactsContainer'] input")
    private WebElement contactsField;

    @FindBy(css = "div[role='textbox']")
    private WebElement emailBodyField;

    @FindBy(css = "span[data-title-shortcut='Ctrl+Enter']")
    private WebElement sendButton;

    public EmailPage(){
        waitForPageVisible(contactsField);
    }

    public EmailPage setContactEmail(String email){
        clearAndSendKeys(contactsField, email);
        return this;
    }

    public EmailPage setEmailBody(String emailBody){
        clearAndSendKeys(emailBodyField, emailBody);
        return this;
    }

    public EmailsPage clickSendButton(){
        clickElement(sendButton);
        return new EmailsPage();
    }
}

package pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.email.EmailsPage;

public class EnterPasswordPage extends BasePage {

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[data-testid='login-to-mail']")
    private WebElement enterButton;

    public EnterPasswordPage(){
        waitForPageVisible(passwordField);
    }

    public EnterPasswordPage setPassword(String password){
        clearAndSendKeys(passwordField, password);
        return this;
    }

    public EmailsPage clickEnterButton(){
        clickElement(enterButton);
        return new EmailsPage();
    }
}

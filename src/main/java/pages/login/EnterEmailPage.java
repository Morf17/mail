package pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class EnterEmailPage extends BasePage {

    @FindBy(css = ".email-input")
    private WebElement emailField;

    @FindBy(css = "button[data-testid='enter-password']")
    private WebElement enterButton;

    public EnterEmailPage(){
        waitForPageVisible(emailField);
    }

    public EnterEmailPage setEmail(String email){
        clearAndSendKeys(emailField, email);
        return this;
    }

    public EnterPasswordPage clickEnterButton(){
        clickElement(enterButton);
        return new EnterPasswordPage();
    }
}

package pages.email;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class EmailsPage extends BasePage {

    @FindBy(css = ".compose-button")
    private WebElement composeButton;

    @FindBy(css = ".layer-sent-page")
    private WebElement layerSent;

    public EmailsPage(){
        waitForPageVisible(composeButton);
    }

    public EmailPage clickComposeButton(){
        clickElement(composeButton);
        return new EmailPage();
    }

    public void waitForSentEmail(){
        waitForElementVisible(layerSent);
    }
}

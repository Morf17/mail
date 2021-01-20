import config.TestConfig;
import config.WebDriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.EnterEmailPage;

import java.util.UUID;

public class MessageTest {

    @BeforeMethod
    public void setUp(){
        WebDriverFactory.getDriver().get(TestConfig.ENVIRONMENT_URL);
    }

    @Test
    public void sendMessage(){
        new EnterEmailPage()
                .setEmail(TestConfig.EMAIL_PREFIX)
                .clickEnterButton()
                .setPassword(TestConfig.EMAIL_PASSWORD)
                .clickEnterButton()
                .clickComposeButton()
                .setContactEmail("test@test.ru")
                .setEmailBody("Message_" + UUID.randomUUID().toString())
                .clickSendButton()
                .waitForSentEmail();
    }

    @AfterMethod
    public void quit(){
        WebDriverFactory.quitDriver();
    }

}

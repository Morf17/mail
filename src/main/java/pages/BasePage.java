package pages;

import config.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static config.TestConfig.IMPLICITLY_WAIT_IN_SECONDS;
import static config.TestConfig.IMPLICITLY_WAIT_SHORT_TIMEOUT_IN_MILLISECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.fail;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = WebDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected void waitForPageVisible(WebElement element) {
        String pageName = getClass().getSimpleName();
        System.out.println("Wait page: " + pageName);

        try {
            waitDocumentReady();
            waitForElementVisible(element);
        } catch (Exception e) {
            String errorMessage = pageName + " was not loaded after " + IMPLICITLY_WAIT_IN_SECONDS + " seconds.\n";
            fail(errorMessage);
            e.printStackTrace();
        }

        System.out.println("Page " + pageName + " loaded");
    }

    protected void clickElement(WebElement element) {
        waitForElementClickable(element);
        element.click();
    }

    protected void clearAndSendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    protected void waitForElementClickable(WebElement element) {
        getWaiter().until(elementToBeClickable(element));
    }

    protected void waitForElementVisible(WebElement element) {
        getWaiter().until(visibilityOf(element));
    }

    private FluentWait<WebDriver> getWaiter() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(IMPLICITLY_WAIT_IN_SECONDS))
                .pollingEvery(Duration.ofMillis(IMPLICITLY_WAIT_SHORT_TIMEOUT_IN_MILLISECONDS))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    private void waitDocumentReady() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        getWaiter().until(f -> executor.executeScript("return document.readyState").equals("complete"));
    }
}
